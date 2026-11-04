package com.lingyue.layerbridge.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Warning
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.kernelsustyleuikit.R
import com.lingyue.layerbridge.core.LbPaths
import top.yukonga.miuix.kmp.basic.Card
import top.yukonga.miuix.kmp.basic.Icon
import top.yukonga.miuix.kmp.basic.Text
import top.yukonga.miuix.kmp.preference.ArrowPreference
import top.yukonga.miuix.kmp.theme.MiuixTheme

@Composable
fun HomePage(state: UiState, modifier: Modifier = Modifier) {
    val granted = state.root?.granted == true
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        item { HeroStatusCard(granted, state.root?.managers.orEmpty().joinToString(", ") { it.name }) }
        if (!granted) {
            item { WarningCard(stringResource(R.string.home_root_summary)) }
        }
        item { StatsRow(state.installed.size, state.runtime?.appVersion ?: "0.1.0") }
        item { InfoCard(state) }
        item { SupportLinks() }
        item { Spacer(Modifier.height(24.dp)) }
    }
}

/** 大状态卡 深色底 右下装饰图标 顶部标签 参考 KernelSU 首页 */
@Composable
private fun HeroStatusCard(granted: Boolean, manager: String) {
    val accent = if (granted) Color(0xFF58C878) else MiuixTheme.colorScheme.error
    val container = if (granted) Color(0xFF1A3825) else MiuixTheme.colorScheme.errorContainer
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(188.dp)
            .clip(RoundedCornerShape(24.dp))
            .background(container),
    ) {
        Icon(
            if (granted) Icons.Default.CheckCircle else Icons.Default.Warning,
            contentDescription = null,
            tint = accent.copy(alpha = 0.25f),
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(end = 12.dp, bottom = 8.dp)
                .size(150.dp),
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(22.dp),
            verticalArrangement = Arrangement.SpaceBetween,
        ) {
            Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                Tag(if (granted) "Root" else "No root", accent)
                if (manager.isNotBlank()) Tag(manager, accent.copy(alpha = 0.75f))
            }
            Column {
                Text(
                    stringResource(if (granted) R.string.home_root_granted else R.string.home_root_denied),
                    style = MiuixTheme.textStyles.headline1,
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold,
                )
                Text(
                    stringResource(R.string.home_hero_summary),
                    style = MiuixTheme.textStyles.footnote2,
                    color = Color.White.copy(alpha = 0.7f),
                )
            }
        }
    }
}

@Composable
private fun Tag(label: String, color: Color) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(50))
            .background(color.copy(alpha = 0.18f))
            .padding(horizontal = 10.dp, vertical = 4.dp),
    ) {
        Text(label, style = MiuixTheme.textStyles.footnote2, color = color)
    }
}

@Composable
private fun WarningCard(message: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(MiuixTheme.colorScheme.errorContainer)
            .padding(16.dp),
    ) {
        Text(message, style = MiuixTheme.textStyles.body2, color = MiuixTheme.colorScheme.onErrorContainer)
    }
}

@Composable
private fun StatsRow(packages: Int, version: String) {
    Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
        StatCard(stringResource(R.string.home_packages_title), packages.toString(), Modifier.weight(1f))
        StatCard(stringResource(R.string.dash_app), version, Modifier.weight(1f))
    }
}

@Composable
private fun StatCard(label: String, value: String, modifier: Modifier) {
    Card(modifier) {
        Column(Modifier.padding(16.dp)) {
            Text(value, style = MiuixTheme.textStyles.title3)
            Text(
                label,
                style = MiuixTheme.textStyles.footnote2,
                color = MiuixTheme.colorScheme.onBackgroundVariant,
            )
        }
    }
}

@Composable
private fun InfoCard(state: UiState) {
    val runtime = state.runtime
    Card(Modifier.fillMaxWidth()) {
        Column(Modifier.padding(vertical = 8.dp)) {
            Text(
                stringResource(R.string.home_info),
                style = MiuixTheme.textStyles.footnote2,
                color = MiuixTheme.colorScheme.onBackgroundVariant,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 6.dp),
            )
            InfoRow(stringResource(R.string.dash_android), runtime?.android ?: "-")
            InfoRow(
                stringResource(R.string.dash_device),
                "${android.os.Build.MANUFACTURER} ${android.os.Build.MODEL}".trim(),
            )
            InfoRow(stringResource(R.string.home_prefix), LbPaths.PREFIX)
            InfoRow(stringResource(R.string.home_module), status(runtime?.module))
            InfoRow(stringResource(R.string.home_entry), status(runtime?.entry))
            InfoRow(stringResource(R.string.home_db), status(runtime?.db))
        }
    }
}

@Composable
private fun InfoRow(label: String, value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 6.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(label, style = MiuixTheme.textStyles.body2, color = MiuixTheme.colorScheme.onBackgroundVariant)
        Text(value, style = MiuixTheme.textStyles.body2)
    }
}

@Composable
private fun SupportLinks() {
    val context = androidx.compose.ui.platform.LocalContext.current
    Card(Modifier.fillMaxWidth()) {
        ArrowPreference(
            title = stringResource(R.string.dash_project),
            summary = stringResource(R.string.dash_project_summary),
            onClick = {
                runCatching {
                    context.startActivity(
                        android.content.Intent(
                            android.content.Intent.ACTION_VIEW,
                            android.net.Uri.parse("https://github.com/Lingyue166/LayerBridge"),
                        ),
                    )
                }
            },
        )
    }
}

@Composable
private fun status(value: Boolean?): String = when (value) {
    null -> stringResource(R.string.dash_checking)
    true -> stringResource(R.string.dash_ok)
    false -> stringResource(R.string.dash_missing)
}
