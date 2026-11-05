package com.lingyue.layerbridge.ui.graph

/**
 * 垂直分层布局：
 * 依赖在下 被依赖的包下沉 每层一行 层内水平排列 居中
 * 连线从卡片底部中点连到下一层卡片顶部中点
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

    fun layout(
        nodes: List<GraphNodeInput>,
        edges: List<GraphEdgeInput>,
        hGap: Float = 24f,
        vGap: Float = 64f,
    ): LayeredLayoutResult {
        if (nodes.isEmpty()) return LayeredLayoutResult(emptyList(), emptyList(), 0f, 0f)
        val byId = nodes.associateBy { it.id }
        val clean = edges.filter { it.from in byId && it.to in byId && it.from != it.to }.distinct()
        val acyclic = removeCycles(nodes.map { it.id }, clean)
        val ranks = assignRanks(nodes.map { it.id }, acyclic)

        val layers = mutableMapOf<Int, MutableList<GraphNodeInput>>()
        nodes.forEach { node -> layers.getOrPut(ranks.getValue(node.id)) { mutableListOf() } += node }
        layers.values.forEach { list -> list.sortBy { it.id } }

        val maxWidth = layers.values.maxOf { layer ->
            layer.sumOf { it.width.toDouble() }.toFloat() + (layer.size - 1) * hGap
        }

        val placed = mutableListOf<PlacedNode>()
        layers.toSortedMap().forEach { (rank, layer) ->
            val rowWidth = layer.sumOf { it.width.toDouble() }.toFloat() + (layer.size - 1) * hGap
            var x = (maxWidth - rowWidth) / 2f
            val y = rank * (layer.first().height + vGap)
            layer.forEach { node ->
                placed += PlacedNode(node.id, x, y, node.width, node.height)
                x += node.width + hGap
            }
        }
        val posById = placed.associateBy { it.id }

        val placedEdges = acyclic.mapNotNull { edge ->
            val from = posById[edge.from] ?: return@mapNotNull null
            val to = posById[edge.to] ?: return@mapNotNull null
            PlacedEdge(
                listOf(
                    (from.x + from.width / 2) to (from.y + from.height),
                    (to.x + to.width / 2) to to.y,
                ),
            )
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
