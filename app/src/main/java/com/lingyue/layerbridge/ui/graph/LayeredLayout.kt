package com.lingyue.layerbridge.ui.graph

/**
 * 垂直分层布局 带自动间距与线路由
 * 每层一行 层内水平居中
 * 层间距按跨层连线数量自动加大
 * 每条连线在层间分配独立通道 减少大面积并行重叠 允许交叉
 */
data class GraphNodeInput(
    val id: String,
    val width: Float = 100f,
    val height: Float = 60f,
)

data class GraphEdgeInput(val from: String, val to: String)

data class PlacedNode(
    val id: String,
    val x: Float,
    val y: Float,
    val width: Float,
    val height: Float,
)

data class PlacedEdge(val points: List<Pair<Float, Float>>)

data class LayeredLayoutResult(
    val nodes: List<PlacedNode>,
    val edges: List<PlacedEdge>,
    val width: Float,
    val height: Float,
)

object LayeredLayout {

    private const val BASE_H_GAP = 50f
    private const val BASE_V_GAP = 140f
    private const val LANE_GAP = 25f
    private const val LANE_PADDING = 45f

    fun layout(
        nodes: List<GraphNodeInput>,
        edges: List<GraphEdgeInput>,
    ): LayeredLayoutResult {
        if (nodes.isEmpty()) return LayeredLayoutResult(emptyList(), emptyList(), 0f, 0f)
        val byId = nodes.associateBy { it.id }
        val clean = edges.filter { it.from in byId && it.to in byId && it.from != it.to }.distinct()
        val acyclic = removeCycles(nodes.map { it.id }, clean)
        val ranks = assignRanks(nodes.map { it.id }, acyclic)

        val layers = mutableMapOf<Int, MutableList<GraphNodeInput>>()
        nodes.forEach { node -> layers.getOrPut(ranks.getValue(node.id)) { mutableListOf() } += node }
        layers.values.forEach { it.sortBy { node -> node.id } }
        val maxRank = ranks.values.maxOrNull() ?: 0

        // 每层宽度
        fun rowWidth(layer: List<GraphNodeInput>): Float =
            layer.sumOf { it.width.toDouble() }.toFloat() + (layer.size - 1) * BASE_H_GAP
        val maxWidth = layers.values.maxOf { rowWidth(it) }

        // 跨层连线数量 决定层间距
        val gapEdges = IntArray(maxRank) { 0 }
        acyclic.forEach { edge ->
            val from = ranks.getValue(edge.from)
            val to = ranks.getValue(edge.to)
            for (g in from until to) if (g in gapEdges.indices) gapEdges[g]++
        }
        val vGaps = FloatArray(maxRank) { g ->
            BASE_V_GAP + gapEdges[g].coerceAtMost(12) * LANE_GAP
        }

        val rowY = FloatArray(maxRank + 1)
        for (rank in 1..maxRank) {
            val cardHeight = layers[rank]?.first()?.height ?: layers[0]?.first()?.height ?: 60f
            rowY[rank] = rowY[rank - 1] + cardHeight + vGaps[rank - 1]
        }

        val placed = mutableListOf<PlacedNode>()
        layers.toSortedMap().forEach { (rank, layer) ->
            var x = (maxWidth - rowWidth(layer)) / 2f
            layer.forEach { node ->
                placed += PlacedNode(node.id, x, rowY[rank], node.width, node.height)
                x += node.width + BASE_H_GAP
            }
        }
        val posById = placed.associateBy { it.id }

        // 层间通道 每条边一个 x 偏移 按目标 x 排序 均分
        val laneSlots = mutableMapOf<Pair<Int, Int>, Float>()
        (0 until maxRank).forEach { gap ->
            val crossing = acyclic.filter { edge ->
                val from = ranks.getValue(edge.from)
                val to = ranks.getValue(edge.to)
                from <= gap && gap < to
            }.sortedBy { edge ->
                val from = posById[edge.from]
                val to = posById[edge.to]
                (from?.let { it.x + it.width / 2 } ?: 0f) + (to?.let { it.x + it.width / 2 } ?: 0f)
            }
            crossing.forEachIndexed { index, edge ->
                laneSlots[gap to index] = index.toFloat()
                laneSlots[edge.hashCode() to gap] = index.toFloat()
            }
            // 保存该间隙的总数 供计算偏移
            laneSlots[gap to -1] = crossing.size.toFloat()
        }

        val placedEdges = acyclic.map { edge ->
            val from = posById.getValue(edge.from)
            val to = posById.getValue(edge.to)
            val fromRank = ranks.getValue(edge.from)
            val toRank = ranks.getValue(edge.to)
            val points = mutableListOf<Pair<Float, Float>>()
            var currentX = from.x + from.width / 2
            var currentY = from.y + from.height
            points += currentX to currentY
            for (gap in fromRank until toRank) {
                val fromX = currentX
                val toX = to.x + to.width / 2
                val laneCount = (laneSlots[gap to -1] ?: 1f).toInt().coerceAtLeast(1)
                val slot = laneSlots[edge.hashCode() to gap]?.toInt() ?: 0
                // 通道 x 在源与目标之间 按槽位横向偏移 避免长距离平行
                val baseX = fromX + (toX - fromX) * ((gap + 1).toFloat() / (toRank - fromRank + 1))
                val laneX = baseX + (slot - (laneCount - 1) / 2f) * LANE_GAP
                val gapTop = rowY[gap] + (layers[gap]?.first()?.height ?: 60f)
                val gapBottom = rowY[gap + 1]
                points += laneX to (gapTop + LANE_PADDING)
                points += laneX to (gapBottom - LANE_PADDING)
                currentX = laneX
                currentY = gapBottom - LANE_PADDING
            }
            points += (to.x + to.width / 2) to to.y
            PlacedEdge(points)
        }

        val width = placed.maxOfOrNull { it.x + it.width } ?: 0f
        val height = placed.maxOfOrNull { it.y + it.height } ?: 0f
        return LayeredLayoutResult(placed, placedEdges, width, height)
    }

    private fun removeCycles(order: List<String>, edges: List<GraphEdgeInput>): List<GraphEdgeInput> {
        val adjacency = edges.groupBy { it.from }.mapValues { (_, list) -> list.map { it.to } }
        val state = mutableMapOf<String, Int>()
        val skipped = mutableSetOf<GraphEdgeInput>()
        fun visit(node: String) {
            state[node] = 1
            adjacency[node].orEmpty().forEach { next ->
                when (state[next] ?: 0) {
                    1 -> skipped += GraphEdgeInput(node, next)
                    0 -> visit(next)
                }
            }
            state[node] = 2
        }
        order.forEach { if ((state[it] ?: 0) == 0) visit(it) }
        return edges.filter { it !in skipped }
    }

    private fun assignRanks(order: List<String>, edges: List<GraphEdgeInput>): MutableMap<String, Int> {
        val indegree = order.associateWith { 0 }.toMutableMap()
        val successors = mutableMapOf<String, MutableList<String>>()
        edges.forEach { edge ->
            indegree[edge.to] = (indegree[edge.to] ?: 0) + 1
            successors.getOrPut(edge.from) { mutableListOf() } += edge.to
        }
        val rank = order.associateWith { 0 }.toMutableMap()
        val queue = ArrayDeque(order.filter { (indegree[it] ?: 0) == 0 })
        while (queue.isNotEmpty()) {
            val node = queue.removeFirst()
            successors[node].orEmpty().forEach { next ->
                rank[next] = maxOf(rank.getValue(next), rank.getValue(node) + 1)
                indegree[next] = indegree.getValue(next) - 1
                if (indegree.getValue(next) == 0) queue += next
            }
        }
        return rank
    }
}
