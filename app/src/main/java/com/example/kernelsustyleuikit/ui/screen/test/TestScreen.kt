package com.example.kernelsustyleuikit.ui.screen.test

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Slider
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

/** 独立测试页 用基础控件堆叠 验证滚动 卡片 输入 开关 滑杆 FAB 与底栏遮挡 */
// <我保证已经认真阅读过skill，确认符合设计语言以及用户要求，没有私自创建控件>
@Composable
fun TestScreen() {
    var query by remember { mutableStateOf("") }
    var checked by remember { mutableStateOf(true) }
    var progress by remember { mutableFloatStateOf(0.4f) }
    Box(Modifier.fillMaxSize().background(Color(0xFF101010))) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = androidx.compose.foundation.layout.PaddingValues(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            item {
                Text("空测试页", style = MaterialTheme.typography.headlineSmall, color = Color(0xFFE6E6E6))
                Spacer(Modifier.height(8.dp))
                Text("用于验证布局 安全区 底栏遮挡", style = MaterialTheme.typography.bodySmall, color = Color(0xFF9AA0A6))
            }
            item {
                OutlinedTextField(
                    value = query,
                    onValueChange = { query = it },
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = { Text("输入测试文本") },
                    singleLine = true,
                )
            }
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    Button(onClick = {}) { Text("主按钮") }
                    TextButton(onClick = {}) { Text("次按钮") }
                }
            }
            item {
                Card(colors = CardDefaults.cardColors(containerColor = Color(0xFF1C2024))) {
                    Row(
                        modifier = Modifier.fillMaxWidth().padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ) {
                        Column {
                            Text("开关项目", color = Color(0xFFE6E6E6))
                            Text("副标题说明", color = Color(0xFF9AA0A6), style = MaterialTheme.typography.bodySmall)
                        }
                        Switch(checked = checked, onCheckedChange = { checked = it })
                    }
                }
            }
            item {
                Card(colors = CardDefaults.cardColors(containerColor = Color(0xFF1C2024))) {
                    Column(Modifier.padding(16.dp)) {
                        Text("滑杆 ${(progress * 100).toInt()}%", color = Color(0xFFE6E6E6))
                        Slider(value = progress, onValueChange = { progress = it })
                    }
                }
            }
            items((1..10).toList()) { index ->
                Card(colors = CardDefaults.cardColors(containerColor = Color(0xFF1C2024))) {
                    Column(Modifier.fillMaxWidth().padding(16.dp)) {
                        Text("列表项 $index", color = Color(0xFFE6E6E6))
                        Text("副标题 $index", color = Color(0xFF9AA0A6), style = MaterialTheme.typography.bodySmall)
                    }
                }
            }
        }
        FloatingActionButton(
            onClick = {},
            modifier = Modifier.align(Alignment.BottomEnd).padding(16.dp),
        ) { Text("+") }
    }
}
