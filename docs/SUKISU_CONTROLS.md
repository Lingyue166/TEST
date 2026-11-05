# SukiSU 控件库提取清单

来源 SukiSU-Ultra/SukiSU-Ultra manager 模块 ui/component 共 95 个 Kotlin 文件
目标 收拢到本项目 com.lingyue.ksui 控件库 页面只允许使用该库

## 读代码后的结论
- AppCard 与 AppScaffold 不是新控件 是 Miuix Card 与 Scaffold 的薄封装
  额外提供 backgroundAwareCardColors TopBarVeil PressFeedbackType 与 popupHost
- 真正需要自建的是主题辅助 与 组合型页面组件 WarningCard StatusTag InfoCard StatsRow SupportLinks
- 大量文件是 KernelSU 业务特有 如 内核刷写 模块仓库 markdown 液体特效 外观取色
  这些按业务裁剪 不盲搬

## 分类与移植优先级

### P0 基础层 立刻需要
- theme 辅助 backgroundAwareCardColors LocalBackgroundImagePath
- AppScaffold AppCard WarningLevel WarningCard
- statustag 目录 3 个文件 StatusTag 与样式
- TopBarVeil MenuPositionProvider ScrollToTop KeyEventBlocker

### P1 导航与列表
- bottombar 5 个 BottomBar BottomBarMiuix BottomBarMaterial NavigationRail
- FloatingBottomBar SearchStatus
- 空态与列表包裹组件

### P2 弹层与交互
- dialog 4 个 DialogMiuix DialogMaterial DownloadDialog
- uninstalldialog 3 个
- rebootlistpopup 3 个
- choosekmidialog 3 个
- appearance 4 个
- profile 12 个

### P3 可选特效
- liquid 4 个 镜头 内阴影 融合背景
- markdown 2 个
- material 14 个 与 Miuix 双实现 仅保留 Miuix 版

### 不移植
- 与内核 模块 刷写 版本检查强绑定 且依赖 KernelSU 资源与数据的组件

## 库结构建议
com.lingyue.ksui
- theme 颜色辅助 背景图
- primitive AppCard AppScaffold WarningCard StatusTag TopBarVeil
- layout InfoCard StatsRow SupportLinks BottomBar
- overlay DialogMiuix UninstallDialog RebootListPopup
- effect Liquid Markdown 可选

## 强制规则
1 页面文件禁止直接 import top.yukonga.miuix.* 除 ksui 库自身
2 禁止自造按钮 卡片 弹层 一律用 ksui 暴露的组件
3 新增控件先入 ksui 再在页面使用

## 校验脚本
tools/check-ui-imports.sh 扫描页面目录 发现违规则失败
