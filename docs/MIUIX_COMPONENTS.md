# Miuix 0.9.4 组件参数总表

来源 commit 39c40f99 公共 composable 签名

## preference/ArrowPreference.kt

```kotlin
@Composable @NonRestartableComposable fun ArrowPreference( title: String, modifier: Modifier = Modifier, titleColor: BasicComponentColors = BasicComponentDefaults.titleColor(), summary: String? = null, summaryColor: BasicComponentColors = BasicComponentDefaults.summaryColor(), startAction: @Composable (() -> Unit)? = null, endActions: @Composable RowScope.() -> Unit = {}, bottomAction: (@Composable () -> Unit)? = null, insideMargin: PaddingValues = BasicComponentDefaults.InsideMargin, onClick: (() -> Unit)? = null, holdDownState: Boolean = false, enabled: Boolean = true, )
```


## preference/OverlayDropdownPreference.kt

```kotlin
@Composable fun OverlayDropdownPreference( items: List<String>, selectedIndex: Int, title: String, modifier: Modifier = Modifier, titleColor: BasicComponentColors = BasicComponentDefaults.titleColor(), summary: String? = null, summaryColor: BasicComponentColors = BasicComponentDefaults.summaryColor(), dropdownColors: DropdownColors = DropdownDefaults.dropdownColors(), startAction: @Composable (() -> Unit)? = null, bottomAction: (@Composable () -> Unit)? = null, insideMargin: PaddingValues = BasicComponentDefaults.InsideMargin, maxHeight: Dp? = null, enabled: Boolean = true, showValue: Boolean = true, renderInRootScaffold: Boolean = true, onExpandedChange: ((Boolean) -> Unit)? = null, onSelectedIndexChange: ((Int) -> Unit)? = null, )
```

```kotlin
@Composable fun OverlayDropdownPreference( entry: DropdownEntry, title: String, modifier: Modifier = Modifier, titleColor: BasicComponentColors = BasicComponentDefaults.titleColor(), summary: String? = null, summaryColor: BasicComponentColors = BasicComponentDefaults.summaryColor(), dropdownColors: DropdownColors = DropdownDefaults.dropdownColors(), startAction: @Composable (() -> Unit)? = null, bottomAction: (@Composable () -> Unit)? = null, insideMargin: PaddingValues = BasicComponentDefaults.InsideMargin, maxHeight: Dp? = null, enabled: Boolean = true, showValue: Boolean = true, renderInRootScaffold: Boolean = true, collapseOnSelection: Boolean = true, onExpandedChange: ((Boolean) -> Unit)? = null, )
```

```kotlin
@Composable fun OverlayDropdownPreference( entries: List<DropdownEntry>, title: String, modifier: Modifier = Modifier, titleColor: BasicComponentColors = BasicComponentDefaults.titleColor(), summary: String? = null, summaryColor: BasicComponentColors = BasicComponentDefaults.summaryColor(), dropdownColors: DropdownColors = DropdownDefaults.dropdownColors(), startAction: @Composable (() -> Unit)? = null, bottomAction: (@Composable () -> Unit)? = null, insideMargin: PaddingValues = BasicComponentDefaults.InsideMargin, maxHeight: Dp? = null, enabled: Boolean = true, showValue: Boolean = true, renderInRootScaffold: Boolean = true, collapseOnSelection: Boolean = entries.size <= 1, onExpandedChange: ((Boolean) -> Unit)? = null, )
```


## preference/OverlaySpinnerPreference.kt

```kotlin
@Composable fun OverlaySpinnerPreference( items: List<DropdownItem>, selectedIndex: Int, title: String, modifier: Modifier = Modifier, titleColor: BasicComponentColors = BasicComponentDefaults.titleColor(), summary: String? = null, summaryColor: BasicComponentColors = BasicComponentDefaults.summaryColor(), spinnerColors: DropdownColors = DropdownDefaults.dropdownColors(), startAction: @Composable (() -> Unit)? = null, bottomAction: (@Composable () -> Unit)? = null, insideMargin: PaddingValues = BasicComponentDefaults.InsideMargin, maxHeight: Dp? = null, enabled: Boolean = true, showValue: Boolean = true, renderInRootScaffold: Boolean = true, onExpandedChange: ((Boolean) -> Unit)? = null, onSelectedIndexChange: ((Int) -> Unit)? = null, )
```

```kotlin
@Composable fun OverlaySpinnerPreference( entry: DropdownEntry, title: String, modifier: Modifier = Modifier, titleColor: BasicComponentColors = BasicComponentDefaults.titleColor(), summary: String? = null, summaryColor: BasicComponentColors = BasicComponentDefaults.summaryColor(), spinnerColors: DropdownColors = DropdownDefaults.dropdownColors(), startAction: @Composable (() -> Unit)? = null, bottomAction: (@Composable () -> Unit)? = null, insideMargin: PaddingValues = BasicComponentDefaults.InsideMargin, maxHeight: Dp? = null, enabled: Boolean = true, showValue: Boolean = true, renderInRootScaffold: Boolean = true, collapseOnSelection: Boolean = true, onExpandedChange: ((Boolean) -> Unit)? = null, )
```

```kotlin
@Composable fun OverlaySpinnerPreference( entries: List<DropdownEntry>, title: String, modifier: Modifier = Modifier, titleColor: BasicComponentColors = BasicComponentDefaults.titleColor(), summary: String? = null, summaryColor: BasicComponentColors = BasicComponentDefaults.summaryColor(), spinnerColors: DropdownColors = DropdownDefaults.dropdownColors(), startAction: @Composable (() -> Unit)? = null, bottomAction: (@Composable () -> Unit)? = null, insideMargin: PaddingValues = BasicComponentDefaults.InsideMargin, maxHeight: Dp? = null, enabled: Boolean = true, showValue: Boolean = true, renderInRootScaffold: Boolean = true, collapseOnSelection: Boolean = entries.size <= 1, onExpandedChange: ((Boolean) -> Unit)? = null, )
```

```kotlin
@Composable fun OverlaySpinnerPreference( items: List<DropdownItem>, selectedIndex: Int, title: String, dialogButtonString: String, modifier: Modifier = Modifier, popupModifier: Modifier = Modifier, titleColor: BasicComponentColors = BasicComponentDefaults.titleColor(), summary: String? = null, summaryColor: BasicComponentColors = BasicComponentDefaults.summaryColor(), spinnerColors: DropdownColors = DropdownDefaults.dialogDropdownColors(), startAction: @Composable (() -> Unit)? = null, bottomAction: (@Composable () -> Unit)? = null, insideMargin: PaddingValues = BasicComponentDefaults.InsideMargin, enabled: Boolean = true, showValue: Boolean = true, renderInRootScaffold: Boolean = true, collapseOnSelection: Boolean = true, onExpandedChange: ((Boolean) -> Unit)? = null, onSelectedIndexChange: ((Int) -> Unit)? = null, )
```

```kotlin
@Composable fun OverlaySpinnerPreference( entry: DropdownEntry, title: String, dialogButtonString: String, modifier: Modifier = Modifier, popupModifier: Modifier = Modifier, titleColor: BasicComponentColors = BasicComponentDefaults.titleColor(), summary: String? = null, summaryColor: BasicComponentColors = BasicComponentDefaults.summaryColor(), spinnerColors: DropdownColors = DropdownDefaults.dialogDropdownColors(), startAction: @Composable (() -> Unit)? = null, bottomAction: (@Composable () -> Unit)? = null, insideMargin: PaddingValues = BasicComponentDefaults.InsideMargin, enabled: Boolean = true, showValue: Boolean = true, renderInRootScaffold: Boolean = true, collapseOnSelection: Boolean = true, onExpandedChange: ((Boolean) -> Unit)? = null, )
```

```kotlin
@Composable fun OverlaySpinnerPreference( entries: List<DropdownEntry>, title: String, dialogButtonString: String, modifier: Modifier = Modifier, popupModifier: Modifier = Modifier, titleColor: BasicComponentColors = BasicComponentDefaults.titleColor(), summary: String? = null, summaryColor: BasicComponentColors = BasicComponentDefaults.summaryColor(), spinnerColors: DropdownColors = DropdownDefaults.dialogDropdownColors(), startAction: @Composable (() -> Unit)? = null, bottomAction: (@Composable () -> Unit)? = null, insideMargin: PaddingValues = BasicComponentDefaults.InsideMargin, enabled: Boolean = true, showValue: Boolean = true, renderInRootScaffold: Boolean = true, collapseOnSelection: Boolean = entries.size <= 1, onExpandedChange: ((Boolean) -> Unit)? = null, )
```


## preference/RadioButtonPreference.kt

```kotlin
@Composable @NonRestartableComposable fun RadioButtonPreference( title: String, selected: Boolean, onClick: (() -> Unit)?, modifier: Modifier = Modifier, summary: String? = null, colors: RadioButtonPreferenceColors = RadioButtonPreferenceDefaults.radioButtonPreferenceColors(), radioButtonColors: RadioButtonColors = RadioButtonDefaults.radioButtonColors(), startAction: @Composable (() -> Unit)? = null, endActions: @Composable (RowScope.() -> Unit)? = null, radioButtonLocation: RadioButtonLocation = RadioButtonLocation.Start, bottomAction: (@Composable () -> Unit)? = null, insideMargin: PaddingValues = BasicComponentDefaults.InsideMargin, holdDownState: Boolean = false, enabled: Boolean = true, )
```


## preference/WindowDropdownPreference.kt

```kotlin
@Composable fun WindowDropdownPreference( items: List<String>, selectedIndex: Int, title: String, modifier: Modifier = Modifier, titleColor: BasicComponentColors = BasicComponentDefaults.titleColor(), summary: String? = null, summaryColor: BasicComponentColors = BasicComponentDefaults.summaryColor(), dropdownColors: DropdownColors = DropdownDefaults.dropdownColors(), startAction: @Composable (() -> Unit)? = null, bottomAction: (@Composable () -> Unit)? = null, insideMargin: PaddingValues = BasicComponentDefaults.InsideMargin, maxHeight: Dp? = null, enabled: Boolean = true, showValue: Boolean = true, onExpandedChange: ((Boolean) -> Unit)? = null, onSelectedIndexChange: ((Int) -> Unit)? = null, )
```

```kotlin
@Composable fun WindowDropdownPreference( entry: DropdownEntry, title: String, modifier: Modifier = Modifier, titleColor: BasicComponentColors = BasicComponentDefaults.titleColor(), summary: String? = null, summaryColor: BasicComponentColors = BasicComponentDefaults.summaryColor(), dropdownColors: DropdownColors = DropdownDefaults.dropdownColors(), startAction: @Composable (() -> Unit)? = null, bottomAction: (@Composable () -> Unit)? = null, insideMargin: PaddingValues = BasicComponentDefaults.InsideMargin, maxHeight: Dp? = null, enabled: Boolean = true, showValue: Boolean = true, collapseOnSelection: Boolean = true, onExpandedChange: ((Boolean) -> Unit)? = null, )
```

```kotlin
@Composable fun WindowDropdownPreference( entries: List<DropdownEntry>, title: String, modifier: Modifier = Modifier, titleColor: BasicComponentColors = BasicComponentDefaults.titleColor(), summary: String? = null, summaryColor: BasicComponentColors = BasicComponentDefaults.summaryColor(), dropdownColors: DropdownColors = DropdownDefaults.dropdownColors(), startAction: @Composable (() -> Unit)? = null, bottomAction: (@Composable () -> Unit)? = null, insideMargin: PaddingValues = BasicComponentDefaults.InsideMargin, maxHeight: Dp? = null, enabled: Boolean = true, showValue: Boolean = true, collapseOnSelection: Boolean = entries.size <= 1, onExpandedChange: ((Boolean) -> Unit)? = null, )
```


## preference/WindowSpinnerPreference.kt

```kotlin
@Composable fun WindowSpinnerPreference( items: List<DropdownItem>, selectedIndex: Int, title: String, modifier: Modifier = Modifier, titleColor: BasicComponentColors = BasicComponentDefaults.titleColor(), summary: String? = null, summaryColor: BasicComponentColors = BasicComponentDefaults.summaryColor(), spinnerColors: DropdownColors = DropdownDefaults.dropdownColors(), startAction: @Composable (() -> Unit)? = null, bottomAction: (@Composable () -> Unit)? = null, insideMargin: PaddingValues = BasicComponentDefaults.InsideMargin, maxHeight: Dp? = null, enabled: Boolean = true, showValue: Boolean = true, onExpandedChange: ((Boolean) -> Unit)? = null, onSelectedIndexChange: ((Int) -> Unit)? = null, )
```

```kotlin
@Composable fun WindowSpinnerPreference( entry: DropdownEntry, title: String, modifier: Modifier = Modifier, titleColor: BasicComponentColors = BasicComponentDefaults.titleColor(), summary: String? = null, summaryColor: BasicComponentColors = BasicComponentDefaults.summaryColor(), spinnerColors: DropdownColors = DropdownDefaults.dropdownColors(), startAction: @Composable (() -> Unit)? = null, bottomAction: (@Composable () -> Unit)? = null, insideMargin: PaddingValues = BasicComponentDefaults.InsideMargin, maxHeight: Dp? = null, enabled: Boolean = true, showValue: Boolean = true, collapseOnSelection: Boolean = true, onExpandedChange: ((Boolean) -> Unit)? = null, )
```

```kotlin
@Composable fun WindowSpinnerPreference( entries: List<DropdownEntry>, title: String, modifier: Modifier = Modifier, titleColor: BasicComponentColors = BasicComponentDefaults.titleColor(), summary: String? = null, summaryColor: BasicComponentColors = BasicComponentDefaults.summaryColor(), spinnerColors: DropdownColors = DropdownDefaults.dropdownColors(), startAction: @Composable (() -> Unit)? = null, bottomAction: (@Composable () -> Unit)? = null, insideMargin: PaddingValues = BasicComponentDefaults.InsideMargin, maxHeight: Dp? = null, enabled: Boolean = true, showValue: Boolean = true, collapseOnSelection: Boolean = entries.size <= 1, onExpandedChange: ((Boolean) -> Unit)? = null, )
```

```kotlin
@Composable fun WindowSpinnerPreference( items: List<DropdownItem>, selectedIndex: Int, title: String, dialogButtonString: String, modifier: Modifier = Modifier, popupModifier: Modifier = Modifier, titleColor: BasicComponentColors = BasicComponentDefaults.titleColor(), summary: String? = null, summaryColor: BasicComponentColors = BasicComponentDefaults.summaryColor(), spinnerColors: DropdownColors = DropdownDefaults.dialogDropdownColors(), startAction: @Composable (() -> Unit)? = null, bottomAction: (@Composable () -> Unit)? = null, insideMargin: PaddingValues = BasicComponentDefaults.InsideMargin, enabled: Boolean = true, showValue: Boolean = true, collapseOnSelection: Boolean = true, onExpandedChange: ((Boolean) -> Unit)? = null, onSelectedIndexChange: ((Int) -> Unit)? = null, )
```

```kotlin
@Composable fun WindowSpinnerPreference( entry: DropdownEntry, title: String, dialogButtonString: String, modifier: Modifier = Modifier, popupModifier: Modifier = Modifier, titleColor: BasicComponentColors = BasicComponentDefaults.titleColor(), summary: String? = null, summaryColor: BasicComponentColors = BasicComponentDefaults.summaryColor(), spinnerColors: DropdownColors = DropdownDefaults.dialogDropdownColors(), startAction: @Composable (() -> Unit)? = null, bottomAction: (@Composable () -> Unit)? = null, insideMargin: PaddingValues = BasicComponentDefaults.InsideMargin, enabled: Boolean = true, showValue: Boolean = true, collapseOnSelection: Boolean = true, onExpandedChange: ((Boolean) -> Unit)? = null, )
```

```kotlin
@Composable fun WindowSpinnerPreference( entries: List<DropdownEntry>, title: String, dialogButtonString: String, modifier: Modifier = Modifier, popupModifier: Modifier = Modifier, titleColor: BasicComponentColors = BasicComponentDefaults.titleColor(), summary: String? = null, summaryColor: BasicComponentColors = BasicComponentDefaults.summaryColor(), spinnerColors: DropdownColors = DropdownDefaults.dialogDropdownColors(), startAction: @Composable (() -> Unit)? = null, bottomAction: (@Composable () -> Unit)? = null, insideMargin: PaddingValues = BasicComponentDefaults.InsideMargin, enabled: Boolean = true, showValue: Boolean = true, collapseOnSelection: Boolean = entries.size <= 1, onExpandedChange: ((Boolean) -> Unit)? = null, )
```


## basic/BreadcrumbBar.kt

```kotlin
@Composable fun BreadcrumbBar( items: List<BreadcrumbItem>, onItemClick: (Int) -> Unit, modifier: Modifier = Modifier, highlightIndex: Int = items.lastIndex, enabled: Boolean = true, colors: BreadcrumbBarColors = BreadcrumbBarDefaults.breadcrumbBarColors(), insideMargin: PaddingValues = BreadcrumbBarDefaults.InsideMargin, itemMaxWidth: Dp = BreadcrumbBarDefaults.ItemMaxWidth, scrollState: ScrollState? = null, interactionSource: MutableInteractionSource? = null, indication: Indication? = LocalIndication.current, )
```


## basic/Button.kt

```kotlin
@Composable fun Button( onClick: () -> Unit, modifier: Modifier = Modifier, enabled: Boolean = true, cornerRadius: Dp = ButtonDefaults.CornerRadius, minWidth: Dp = ButtonDefaults.MinWidth, minHeight: Dp = ButtonDefaults.MinHeight, colors: ButtonColors = ButtonDefaults.buttonColors(), insideMargin: PaddingValues = ButtonDefaults.InsideMargin, interactionSource: MutableInteractionSource? = null, indication: Indication? = LocalIndication.current, content: @Composable RowScope.() -> Unit, )
```

```kotlin
@Composable fun TextButton( text: String, onClick: () -> Unit, modifier: Modifier = Modifier, enabled: Boolean = true, cornerRadius: Dp = ButtonDefaults.CornerRadius, minWidth: Dp = ButtonDefaults.MinWidth, minHeight: Dp = ButtonDefaults.MinHeight, colors: TextButtonColors = ButtonDefaults.textButtonColors(), insideMargin: PaddingValues = ButtonDefaults.InsideMargin, textStyle: TextStyle? = null, interactionSource: MutableInteractionSource? = null, indication: Indication? = LocalIndication.current, )
```


## basic/Checkbox.kt

```kotlin
@Composable fun Checkbox( state: ToggleableState, onClick: (() -> Unit)?, modifier: Modifier = Modifier, colors: CheckboxColors = CheckboxDefaults.checkboxColors(), enabled: Boolean = true, )
```


## basic/ColorPalette.kt

```kotlin
@Composable fun ColorPalette( color: Color, onColorChanged: (Color) -> Unit, modifier: Modifier = Modifier, rows: Int = 7, hueColumns: Int = 12, includeGrayColumn: Boolean = true, showPreview: Boolean = true, cornerRadius: Dp = 16.dp, indicatorRadius: Dp = 10.dp, )
```


## basic/Component.kt

```kotlin
@Composable fun BasicComponent( modifier: Modifier = Modifier, title: String? = null, titleColor: BasicComponentColors = BasicComponentDefaults.titleColor(), summary: String? = null, summaryColor: BasicComponentColors = BasicComponentDefaults.summaryColor(), startAction: @Composable (() -> Unit)? = null, endActions: @Composable (RowScope.() -> Unit)? = null, bottomAction: (@Composable () -> Unit)? = null, insideMargin: PaddingValues = BasicComponentDefaults.InsideMargin, onClick: (() -> Unit)? = null, onClickLabel: String? = null, role: Role? = null, holdDownState: Boolean = false, enabled: Boolean = true, interactionSource: MutableInteractionSource? = null, )
```

```kotlin
@Composable fun BasicComponent( modifier: Modifier = Modifier, startAction: @Composable (() -> Unit)? = null, endActions: @Composable (RowScope.() -> Unit)? = null, bottomAction: (@Composable () -> Unit)? = null, insideMargin: PaddingValues = BasicComponentDefaults.InsideMargin, onClick: (() -> Unit)? = null, onClickLabel: String? = null, role: Role? = null, holdDownState: Boolean = false, enabled: Boolean = true, interactionSource: MutableInteractionSource? = null, content: @Composable ColumnScope.() -> Unit, )
```


## basic/FloatingActionButton.kt

```kotlin
@Composable @NonRestartableComposable fun FloatingActionButton( onClick: () -> Unit, modifier: Modifier = Modifier, shape: Shape = CircleShape, containerColor: Color = MiuixTheme.colorScheme.primary, shadowElevation: Dp = FloatingActionButtonDefaults.ShadowElevation, minWidth: Dp = FloatingActionButtonDefaults.MinWidth, minHeight: Dp = FloatingActionButtonDefaults.MinHeight, content: @Composable () -> Unit, )
```


## basic/Icon.kt

```kotlin
@Composable fun Icon( imageVector: ImageVector, contentDescription: String?, modifier: Modifier = Modifier, tint: Color = LocalContentColor.current, )
```

```kotlin
@Composable fun Icon( bitmap: ImageBitmap, contentDescription: String?, modifier: Modifier = Modifier, tint: Color = LocalContentColor.current, )
```

```kotlin
@Composable fun Icon( painter: Painter, contentDescription: String?, modifier: Modifier = Modifier, tint: Color = LocalContentColor.current, )
```

```kotlin
@Composable fun Icon( painter: Painter, tint: ColorProducer?, contentDescription: String?, modifier: Modifier = Modifier, )
```


## basic/ListPopup.kt

```kotlin
@Composable fun ListPopupColumn( content: @Composable () -> Unit, )
```

```kotlin
@Composable fun rememberListPopupLayoutInfo( alignment: PopupPositionProvider.Align, popupPositionProvider: PopupPositionProvider, parentBounds: IntRect, popupContentSize: IntSize, )
```

```kotlin
@Composable fun ListPopupContent( popupContentSize: IntSize, onPopupContentSizeChange: (IntSize) -> Unit, fractionProgress: () -> Float, alphaProgress: () -> Float, popupLayoutPosition: PopupLayoutPosition, localTransformOrigin: TransformOrigin, modifier: Modifier = Modifier, content: @Composable () -> Unit, )
```


## basic/NavigationBar.kt

```kotlin
@Composable fun NavigationBar( modifier: Modifier = Modifier, color: Color = MiuixTheme.colorScheme.surface, showDivider: Boolean = true, defaultWindowInsetsPadding: Boolean = true, mode: NavigationBarDisplayMode = NavigationBarDisplayMode.IconAndText, content: @Composable RowScope.() -> Unit, )
```

```kotlin
@Composable fun RowScope.NavigationBarItem( selected: Boolean, onClick: () -> Unit, icon: ImageVector, label: String, modifier: Modifier = Modifier, enabled: Boolean = true, colors: NavigationBarItemColors = NavigationBarDefaults.navigationBarItemColors(), badge: (@Composable () -> Unit)? = null, )
```

```kotlin
@Composable fun FloatingNavigationBar( modifier: Modifier = Modifier, color: Color = MiuixTheme.colorScheme.surfaceContainer, cornerRadius: Dp = FloatingToolbarDefaults.CornerRadius, horizontalAlignment: Alignment.Horizontal = CenterHorizontally, horizontalOutSidePadding: Dp = FloatingNavigationBarDefaults.HorizontalOutSidePadding, shadowElevation: Dp = FloatingNavigationBarDefaults.ShadowElevation, showDivider: Boolean = false, defaultWindowInsetsPadding: Boolean = true, content: @Composable () -> Unit, )
```

```kotlin
@Composable fun FloatingNavigationBarItem( selected: Boolean, onClick: () -> Unit, icon: ImageVector, label: String, modifier: Modifier = Modifier, enabled: Boolean = true, colors: NavigationBarItemColors = NavigationBarDefaults.navigationBarItemColors(), badge: (@Composable () -> Unit)? = null, )
```


## basic/NavigationRail.kt

```kotlin
@Composable fun NavigationRail( modifier: Modifier = Modifier, expanded: Boolean = false, header: @Composable (ColumnScope.() -> Unit)? = null, color: Color = MiuixTheme.colorScheme.surface, showDivider: Boolean = true, defaultWindowInsetsPadding: Boolean = true, minWidth: Dp = NavigationRailDefaults.MinWidth, expandedWidth: Dp = NavigationRailDefaults.ExpandedWidth, scrollState: ScrollState = rememberScrollState(), content: @Composable ColumnScope.() -> Unit, )
```

```kotlin
@Composable fun NavigationRail( state: NavigationRailState, modifier: Modifier = Modifier, header: @Composable (ColumnScope.() -> Unit)? = null, color: Color = MiuixTheme.colorScheme.surface, showDivider: Boolean = true, defaultWindowInsetsPadding: Boolean = true, minWidth: Dp = NavigationRailDefaults.MinWidth, expandedWidth: Dp = NavigationRailDefaults.ExpandedWidth, expandContentDescription: String = NavigationRailDefaults.ExpandContentDescription, collapseContentDescription: String = NavigationRailDefaults.CollapseContentDescription, scrollState: ScrollState = rememberScrollState(), content: @Composable ColumnScope.() -> Unit, )
```

```kotlin
@Composable fun NavigationRailItem( selected: Boolean, onClick: () -> Unit, icon: ImageVector, label: String, modifier: Modifier = Modifier, enabled: Boolean = true, badge: (@Composable () -> Unit)? = null, )
```

```kotlin
@Composable fun rememberNavigationRailState( initialValue: NavigationRailValue = NavigationRailValue.Collapsed, )
```


## basic/PullToRefresh.kt

```kotlin
@Composable fun PullToRefresh( isRefreshing: Boolean, onRefresh: () -> Unit, modifier: Modifier = Modifier, pullToRefreshState: PullToRefreshState = rememberPullToRefreshState(), contentPadding: PaddingValues = PaddingValues(0.dp), topAppBarScrollBehavior: ScrollBehavior? = null, color: Color = PullToRefreshDefaults.color, circleSize: Dp = PullToRefreshDefaults.circleSize, refreshTexts: List<String> = PullToRefreshDefaults.refreshTexts, refreshTextStyle: TextStyle = PullToRefreshDefaults.refreshTextStyle, onPullProgress: ((Float) -> Unit)? = null, content: @Composable () -> Unit, )
```

```kotlin
@Composable fun rememberPullToRefreshState( refreshThreshold: Float = 0.25f, )
```


## basic/Scaffold.kt

```kotlin
@Composable fun Scaffold( modifier: Modifier = Modifier, topBar: @Composable () -> Unit = {}, bottomBar: @Composable () -> Unit = {}, floatingActionButton: @Composable () -> Unit = {}, floatingActionButtonPosition: FabPosition = FabPosition.End, floatingToolbar: @Composable () -> Unit = {}, floatingToolbarPosition: ToolbarPosition = ToolbarPosition.BottomCenter, snackbarHost: @Composable () -> Unit = {}, popupHost: @Composable () -> Unit = { MiuixPopupHost() }, containerColor: Color = MiuixTheme.colorScheme.surface, contentWindowInsets: WindowInsets = WindowInsets.systemBars.union(WindowInsets.displayCutout), content: @Composable (PaddingValues) -> Unit, )
```


## basic/ScrollBar.kt

```kotlin
@ExperimentalScrollBarApi @Composable fun rememberScrollBarAdapter( scrollState: ScrollState, )
```

```kotlin
@ExperimentalScrollBarApi @Composable fun rememberScrollBarAdapter( scrollState: LazyListState, )
```

```kotlin
@ExperimentalScrollBarApi @Composable fun rememberScrollBarAdapter( scrollState: LazyGridState, )
```

```kotlin
@ExperimentalScrollBarApi @Composable fun VerticalScrollBar( adapter: ScrollBarAdapter, modifier: Modifier = Modifier, reverseLayout: Boolean = false, trackPadding: PaddingValues = PaddingValues(0.dp), colors: ScrollBarColors = ScrollBarDefaults.scrollBarColors(), thumbWidth: Dp = ScrollBarDefaults.ThumbWidth, cornerRadius: Dp = ScrollBarDefaults.CornerRadius, thumbMinLength: Dp = ScrollBarDefaults.ThumbMinLength, endPadding: Dp = ScrollBarDefaults.EndPadding, )
```

```kotlin
@ExperimentalScrollBarApi @Composable fun HorizontalScrollBar( adapter: ScrollBarAdapter, modifier: Modifier = Modifier, reverseLayout: Boolean = false, trackPadding: PaddingValues = PaddingValues(0.dp), colors: ScrollBarColors = ScrollBarDefaults.scrollBarColors(), thumbWidth: Dp = ScrollBarDefaults.ThumbWidth, cornerRadius: Dp = ScrollBarDefaults.CornerRadius, thumbMinLength: Dp = ScrollBarDefaults.ThumbMinLength, endPadding: Dp = ScrollBarDefaults.EndPadding, )
```


## basic/SearchBar.kt

```kotlin
@Composable fun SearchBar( inputField: @Composable () -> Unit, onExpandedChange: (Boolean) -> Unit, modifier: Modifier = Modifier, insideMargin: DpSize = SearchBarDefaults.InsideMargin, expanded: Boolean = false, outsideEndAction: @Composable (() -> Unit)? = null, content: @Composable ColumnScope.() -> Unit, )
```

```kotlin
@Composable fun InputField( query: String, onQueryChange: (String) -> Unit, onSearch: (String) -> Unit, expanded: Boolean, onExpandedChange: (Boolean) -> Unit, modifier: Modifier = Modifier, label: String = "", enabled: Boolean = true, textStyle: TextStyle? = null, color: Color = MiuixTheme.colorScheme.surfaceContainerHigh, leadingIcon: @Composable (() -> Unit)? = null, trailingIcon: @Composable (() -> Unit)? = null, interactionSource: MutableInteractionSource? = null, )
```


## basic/Slider.kt

```kotlin
@Composable fun Slider( value: Float, onValueChange: (Float) -> Unit, modifier: Modifier = Modifier, enabled: Boolean = true, valueRange: ClosedFloatingPointRange<Float> = 0f..1f, @IntRange(from = 0) steps: Int = 0, onValueChangeFinished: (() -> Unit)? = null, reverseDirection: Boolean = false, height: Dp = SliderDefaults.MinHeight, colors: SliderColors = SliderDefaults.sliderColors(), hapticEffect: SliderDefaults.SliderHapticEffect = SliderDefaults.DefaultHapticEffect, showKeyPoints: Boolean = false, keyPoints: List<Float>? = null, magnetThreshold: Float = 0.02f, )
```

```kotlin
@Composable fun VerticalSlider( value: Float, onValueChange: (Float) -> Unit, modifier: Modifier = Modifier, enabled: Boolean = true, valueRange: ClosedFloatingPointRange<Float> = 0f..1f, @IntRange(from = 0) steps: Int = 0, onValueChangeFinished: (() -> Unit)? = null, reverseDirection: Boolean = false, width: Dp = SliderDefaults.MinHeight, colors: SliderColors = SliderDefaults.sliderColors(), effect: Boolean = false, hapticEffect: SliderDefaults.SliderHapticEffect = SliderDefaults.DefaultHapticEffect, showKeyPoints: Boolean = false, keyPoints: List<Float>? = null, magnetThreshold: Float = 0.02f, )
```

```kotlin
@Composable fun RangeSlider( value: ClosedFloatingPointRange<Float>, onValueChange: (ClosedFloatingPointRange<Float>) -> Unit, modifier: Modifier = Modifier, enabled: Boolean = true, valueRange: ClosedFloatingPointRange<Float> = 0f..1f, @IntRange(from = 0) steps: Int = 0, onValueChangeFinished: (() -> Unit)? = null, height: Dp = SliderDefaults.MinHeight, colors: SliderColors = SliderDefaults.sliderColors(), hapticEffect: SliderDefaults.SliderHapticEffect = SliderDefaults.DefaultHapticEffect, showKeyPoints: Boolean = false, keyPoints: List<Float>? = null, magnetThreshold: Float = 0.02f, )
```


## basic/Snackbar.kt

```kotlin
@Composable fun SnackbarHost( state: SnackbarHostState, modifier: Modifier = Modifier, canSwipeToDismiss: Boolean = true, content: @Composable (SnackbarData) -> Unit = { Snackbar(it) }, )
```

```kotlin
@Composable fun Snackbar( data: SnackbarData, modifier: Modifier = Modifier, cornerRadius: Dp = SnackbarDefaults.CornerRadius, colors: SnackbarColors = SnackbarDefaults.snackbarColors(), insideMargin: PaddingValues = SnackbarDefaults.InsideMargin, )
```


## basic/Switch.kt

```kotlin
@Composable fun Switch( checked: Boolean, onCheckedChange: ((Boolean) -> Unit)?, modifier: Modifier = Modifier, colors: SwitchColors = SwitchDefaults.switchColors(), enabled: Boolean = true, )
```


## basic/TabRow.kt

```kotlin
@Composable fun TabRow( tabs: List<String>, selectedTabIndex: Int, onTabSelected: (Int) -> Unit, modifier: Modifier = Modifier, colors: TabRowColors = TabRowDefaults.tabRowColors(), minWidth: Dp = TabRowDefaults.TabRowMinWidth, maxWidth: Dp = TabRowDefaults.TabRowMaxWidth, height: Dp = TabRowDefaults.TabRowHeight, cornerRadius: Dp = TabRowDefaults.TabRowCornerRadius, itemSpacing: Dp = 9.dp, contentAlignment: Alignment = Alignment.Center, listState: LazyListState? = null, interactionSource: MutableInteractionSource? = null, indication: Indication? = null, )
```

```kotlin
@Composable fun TabRowWithContour( tabs: List<String>, selectedTabIndex: Int, onTabSelected: (Int) -> Unit, modifier: Modifier = Modifier, colors: TabRowColors = TabRowDefaults.tabRowColors(), minWidth: Dp = TabRowDefaults.TabRowWithContourMinWidth, maxWidth: Dp = TabRowDefaults.TabRowWithContourMaxWidth, height: Dp = TabRowDefaults.TabRowWithContourHeight, cornerRadius: Dp = TabRowDefaults.TabRowWithContourCornerRadius, itemSpacing: Dp = 5.dp, contentAlignment: Alignment = Alignment.Center, listState: LazyListState? = null, interactionSource: MutableInteractionSource? = null, indication: Indication? = null, )
```


## basic/Text.kt

```kotlin
@Composable fun Text( text: String, modifier: Modifier = Modifier, color: Color = Color.Unspecified, autoSize: TextAutoSize? = null, fontSize: TextUnit = TextUnit.Unspecified, fontStyle: FontStyle? = null, fontWeight: FontWeight? = null, fontFamily: FontFamily? = null, letterSpacing: TextUnit = TextUnit.Unspecified, textDecoration: TextDecoration? = null, textAlign: TextAlign? = null, lineHeight: TextUnit = TextUnit.Unspecified, overflow: TextOverflow = TextOverflow.Clip, softWrap: Boolean = true, maxLines: Int = Int.MAX_VALUE, minLines: Int = 1, onTextLayout: ((TextLayoutResult) -> Unit)? = null, style: TextStyle = LocalTextStyles.current.main, )
```

```kotlin
@Composable fun Text( text: String, color: ColorProducer, modifier: Modifier = Modifier, autoSize: TextAutoSize? = null, fontSize: TextUnit = TextUnit.Unspecified, fontStyle: FontStyle? = null, fontWeight: FontWeight? = null, fontFamily: FontFamily? = null, letterSpacing: TextUnit = TextUnit.Unspecified, textDecoration: TextDecoration? = null, textAlign: TextAlign? = null, lineHeight: TextUnit = TextUnit.Unspecified, overflow: TextOverflow = TextOverflow.Clip, softWrap: Boolean = true, maxLines: Int = Int.MAX_VALUE, minLines: Int = 1, onTextLayout: ((TextLayoutResult) -> Unit)? = null, style: TextStyle = LocalTextStyles.current.main, )
```

```kotlin
@Composable fun Text( text: AnnotatedString, modifier: Modifier = Modifier, color: Color = Color.Unspecified, autoSize: TextAutoSize? = null, fontSize: TextUnit = TextUnit.Unspecified, fontStyle: FontStyle? = null, fontWeight: FontWeight? = null, fontFamily: FontFamily? = null, letterSpacing: TextUnit = TextUnit.Unspecified, textDecoration: TextDecoration? = null, textAlign: TextAlign? = null, lineHeight: TextUnit = TextUnit.Unspecified, overflow: TextOverflow = TextOverflow.Clip, softWrap: Boolean = true, maxLines: Int = Int.MAX_VALUE, minLines: Int = 1, inlineContent: Map<String, InlineTextContent> = mapOf(), onTextLayout: (TextLayoutResult) -> Unit = {}, style: TextStyle = LocalTextStyles.current.main, )
```

```kotlin
@Composable fun Text( text: AnnotatedString, color: ColorProducer, modifier: Modifier = Modifier, autoSize: TextAutoSize? = null, fontSize: TextUnit = TextUnit.Unspecified, fontStyle: FontStyle? = null, fontWeight: FontWeight? = null, fontFamily: FontFamily? = null, letterSpacing: TextUnit = TextUnit.Unspecified, textDecoration: TextDecoration? = null, textAlign: TextAlign? = null, lineHeight: TextUnit = TextUnit.Unspecified, overflow: TextOverflow = TextOverflow.Clip, softWrap: Boolean = true, maxLines: Int = Int.MAX_VALUE, minLines: Int = 1, inlineContent: Map<String, InlineTextContent> = mapOf(), onTextLayout: (TextLayoutResult) -> Unit = {}, style: TextStyle = LocalTextStyles.current.main, )
```


## basic/TextField.kt

```kotlin
@Composable fun TextField( state: TextFieldState, modifier: Modifier = Modifier, insideMargin: DpSize = TextFieldDefaults.InsideMargin, colors: TextFieldColors = TextFieldDefaults.textFieldColors(), cornerRadius: Dp = TextFieldDefaults.CornerRadius, label: String = "", useLabelAsPlaceholder: Boolean = false, enabled: Boolean = true, readOnly: Boolean = false, inputTransformation: InputTransformation? = null, textStyle: TextStyle = MiuixTheme.textStyles.main, keyboardOptions: KeyboardOptions = KeyboardOptions.Default, onKeyboardAction: KeyboardActionHandler? = null, lineLimits: TextFieldLineLimits = TextFieldLineLimits.Default, leadingIcon: @Composable (() -> Unit)? = null, trailingIcon: @Composable (() -> Unit)? = null, onTextLayout: (Density.(getResult: () -> TextLayoutResult?) -> Unit)? = null, interactionSource: MutableInteractionSource? = null, cursorBrush: Brush = SolidColor(colors.borderColor), outputTransformation: OutputTransformation? = null, scrollState: ScrollState = rememberScrollState(), )
```

```kotlin
@Composable fun TextField( value: TextFieldValue, onValueChange: (TextFieldValue) -> Unit, modifier: Modifier = Modifier, insideMargin: DpSize = TextFieldDefaults.InsideMargin, colors: TextFieldColors = TextFieldDefaults.textFieldColors(), cornerRadius: Dp = TextFieldDefaults.CornerRadius, label: String = "", useLabelAsPlaceholder: Boolean = false, enabled: Boolean = true, readOnly: Boolean = false, textStyle: TextStyle = MiuixTheme.textStyles.main, keyboardOptions: KeyboardOptions = KeyboardOptions.Default, keyboardActions: KeyboardActions = KeyboardActions.Default, leadingIcon: @Composable (() -> Unit)? = null, trailingIcon: @Composable (() -> Unit)? = null, singleLine: Boolean = false, maxLines: Int = if (singleLine) 1 else Int.MAX_VALUE, minLines: Int = 1, visualTransformation: VisualTransformation = VisualTransformation.None, onTextLayout: (TextLayoutResult) -> Unit = {}, interactionSource: MutableInteractionSource? = null, cursorBrush: Brush = SolidColor(colors.borderColor), )
```

```kotlin
@Composable fun TextField( value: String, onValueChange: (String) -> Unit, modifier: Modifier = Modifier, insideMargin: DpSize = TextFieldDefaults.InsideMargin, colors: TextFieldColors = TextFieldDefaults.textFieldColors(), cornerRadius: Dp = TextFieldDefaults.CornerRadius, label: String = "", useLabelAsPlaceholder: Boolean = false, enabled: Boolean = true, readOnly: Boolean = false, textStyle: TextStyle = MiuixTheme.textStyles.main, keyboardOptions: KeyboardOptions = KeyboardOptions.Default, keyboardActions: KeyboardActions = KeyboardActions.Default, leadingIcon: @Composable (() -> Unit)? = null, trailingIcon: @Composable (() -> Unit)? = null, singleLine: Boolean = false, maxLines: Int = if (singleLine) 1 else Int.MAX_VALUE, minLines: Int = 1, visualTransformation: VisualTransformation = VisualTransformation.None, onTextLayout: (TextLayoutResult) -> Unit = {}, interactionSource: MutableInteractionSource? = null, cursorBrush: Brush = SolidColor(colors.borderColor), )
```


## basic/Tooltip.kt

```kotlin
@Composable fun rememberTooltipState( initialIsVisible: Boolean = false, isPersistent: Boolean = false, mutatorMutex: MutatorMutex = BasicTooltipDefaults.GlobalMutatorMutex, )
```

```kotlin
@Composable fun TooltipBox( positionProvider: PopupPositionProvider, tooltip: @Composable TooltipScope.() -> Unit, state: TooltipState, modifier: Modifier = Modifier, focusable: Boolean = false, enableUserInput: Boolean = true, content: @Composable () -> Unit, )
```

```kotlin
@Composable fun TooltipScope.PlainTooltip( modifier: Modifier = Modifier, caretShape: Shape? = null, maxWidth: Dp = TooltipDefaults.PlainTooltipMaxWidth, cornerRadius: Dp = TooltipDefaults.PlainTooltipCornerRadius, containerColor: Color = TooltipDefaults.plainTooltipContainerColor, contentColor: Color = TooltipDefaults.plainTooltipContentColor, insideMargin: PaddingValues = TooltipDefaults.PlainTooltipInsideMargin, content: @Composable () -> Unit, )
```

```kotlin
@Composable fun TooltipScope.RichTooltip( modifier: Modifier = Modifier, title: (@Composable () -> Unit)? = null, action: (@Composable () -> Unit)? = null, caretShape: Shape? = null, maxWidth: Dp = TooltipDefaults.RichTooltipMaxWidth, cornerRadius: Dp = TooltipDefaults.RichTooltipCornerRadius, colors: RichTooltipColors = TooltipDefaults.richTooltipColors(), insideMargin: PaddingValues = TooltipDefaults.RichTooltipInsideMargin, text: @Composable () -> Unit, )
```

```kotlin
@Composable fun TooltipBox( text: String, modifier: Modifier = Modifier, state: TooltipState = rememberTooltipState(isPersistent = false), enabled: Boolean = true, positioning: TooltipAnchorPosition = TooltipAnchorPosition.Below, containerColor: Color = TooltipDefaults.plainTooltipContainerColor, contentColor: Color = TooltipDefaults.plainTooltipContentColor, content: @Composable () -> Unit, )
```

```kotlin
@Composable fun RichTooltipBox( text: String, modifier: Modifier = Modifier, state: TooltipState = rememberTooltipState(isPersistent = true), title: String? = null, actionText: String? = null, onActionClick: (() -> Unit)? = null, enabled: Boolean = true, positioning: TooltipAnchorPosition = TooltipAnchorPosition.Below, colors: RichTooltipColors = TooltipDefaults.richTooltipColors(), content: @Composable () -> Unit, )
```


## overlay/OverlayCascadingListPopup.kt

```kotlin
@Composable fun OverlayCascadingListPopup( show: Boolean, entries: List<DropdownEntry>, onDismissRequest: () -> Unit, popupModifier: Modifier = Modifier, onDismissFinished: (() -> Unit)? = null, popupPositionProvider: PopupPositionProvider = ListPopupDefaults.DropdownPositionProvider, alignment: PopupPositionProvider.Align = PopupPositionProvider.Align.End, enableWindowDim: Boolean = true, maxHeight: Dp? = null, minWidth: Dp = 200.dp, renderInRootScaffold: Boolean = true, dropdownColors: DropdownColors = DropdownDefaults.dropdownColors(), collapseOnSelection: Boolean = true, )
```


## theme/Colors.kt

```kotlin
fun lightColorScheme( primary: Color = Color(0xFF3482FF), onPrimary: Color = Color.White, primaryVariant: Color = Color(0xFF3482FF), onPrimaryVariant: Color = Color(0xFFAECDFF), error: Color = Color(0xFFE94634), onError: Color = Color(0xFFFFFFFF), errorContainer: Color = Color(0xFFFDF6F4), onErrorContainer: Color = Color(0xFF410002), disabledPrimary: Color = Color(0xFFC2D9FF), disabledOnPrimary: Color = Color(0xFFF3F8FF), disabledPrimaryButton: Color = Color(0xFFC2D9FF), disabledOnPrimaryButton: Color = Color(0xFFFFFFFF), disabledPrimarySlider: Color = Color(0xFFB8CFF5), primaryContainer: Color = Color(0xFF5D9BFF), onPrimaryContainer: Color = Color.White, secondary: Color = Color(0xFFE6E6E6), onSecondary: Color = Color.White, secondaryVariant: Color = Color(0xFFF0F0F0), onSecondaryVariant: Color = Color(0xFF303030), disabledSecondary: Color = Color(0xFFF0F0F0), disabledOnSecondary: Color = Color(0xFFFCFCFC), disabledSecondaryVariant: Color = Color(0xFFF2F2F2), disabledOnSecondaryVariant: Color = Color(0xFFB2B2B2), secondaryContainer: Color = Color(0xFFF0F0F0), onSecondaryContainer: Color = Color(0xFFA9A9A9), secondaryContainerVariant: Color = Color(0xFFF0F0F0), onSecondaryContainerVariant: Color = Color(0xFFA8A8A8), tertiaryContainer: Color = Color(0xFFEAF2FF), onTertiaryContainer: Color = Color(0xFF3482FF), tertiaryContainerVariant: Color = Color(0xFFEAF2FF), background: Color = Color.White, onBackground: Color = Color.Black, onBackgroundVariant: Color = Color(0xFF8C93B0), surface: Color = Color(0xFFF7F7F7), onSurface: Color = Color.Black, surfaceVariant: Color = Color.White, onSurfaceSecondary: Color = Color(0xCC000000), onSurfaceVariantSummary: Color = Color(0x99000000), onSurfaceVariantActions: Color = Color(0x66000000), disabledOnSurface: Color = Color(0xFFB2B2B2), surfaceContainer: Color = Color.White, onSurfaceContainer: Color = Color.Black, onSurfaceContainerVariant: Color = Color(0xFF959595), surfaceContainerHigh: Color = Color(0xFFE8E8E8), onSurfaceContainerHigh: Color = Color(0xFFA2A2A2), surfaceContainerHighest: Color = Color(0xFFE8E8E8), onSurfaceContainerHighest: Color = Color.Black, outline: Color = Color(0xFFD9D9D9), dividerLine: Color = Color(0xFFE0E0E0), windowDimming: Color = Color.Black.copy(alpha = 0.3F), sliderKeyPoint: Color = Color(0x4DA3B3CD), sliderKeyPointForeground: Color = Color(0xFF6EB5FF), sliderBackground: Color = Color(0x0F000000), )
```

```kotlin
fun darkColorScheme( primary: Color = Color(0xFF277AF7), onPrimary: Color = Color.White, primaryVariant: Color = Color(0xFF0073DD), onPrimaryVariant: Color = Color(0xFF99C7F1), error: Color = Color(0xFFF12522), onError: Color = Color.White, errorContainer: Color = Color(0xFF2E0603), onErrorContainer: Color = Color(0xFFFFDAD6), disabledPrimary: Color = Color(0xFF253E64), disabledOnPrimary: Color = Color(0xFF677993), disabledPrimaryButton: Color = Color(0xFF253E64), disabledOnPrimaryButton: Color = Color(0xFF677893), disabledPrimarySlider: Color = Color(0xFF44587C), primaryContainer: Color = Color(0xFF338FE4), onPrimaryContainer: Color = Color.White, secondary: Color = Color(0xFF505050), onSecondary: Color = Color.White, secondaryVariant: Color = Color(0xFF434343), onSecondaryVariant: Color = Color(0xFFD9D9D9), disabledSecondary: Color = Color(0xFF3F3F3F), disabledOnSecondary: Color = Color(0xFF797979), disabledSecondaryVariant: Color = Color(0xFF404040), disabledOnSecondaryVariant: Color = Color(0xFF707170), secondaryContainer: Color = Color(0xFF434343), onSecondaryContainer: Color = Color(0xFF7C7C7C), secondaryContainerVariant: Color = Color(0xFF4F4F4F), onSecondaryContainerVariant: Color = Color(0xFF959595), tertiaryContainer: Color = Color(0xFF2B3B54), onTertiaryContainer: Color = Color(0xFF4788ff), tertiaryContainerVariant: Color = Color(0xFF505050), background: Color = Color(0xFF242424), onBackground: Color = Color(0xE6FFFFFF), onBackgroundVariant: Color = Color(0xFF787E96), surface: Color = Color.Black, onSurface: Color = Color(0xFFF2F2F2), surfaceVariant: Color = Color(0xFF242424), onSurfaceSecondary: Color = Color(0xCCFFFFFF), onSurfaceVariantSummary: Color = Color(0x80FFFFFF), onSurfaceVariantActions: Color = Color(0x66FFFFFF), disabledOnSurface: Color = Color(0xFF666666), surfaceContainer: Color = Color(0xFF242424), onSurfaceContainer: Color = Color(0xE6FFFFFF), onSurfaceContainerVariant: Color = Color(0xFF737373), surfaceContainerHigh: Color = Color(0xFF242424), onSurfaceContainerHigh: Color = Color(0xFF666666), surfaceContainerHighest: Color = Color(0xFF2D2D2D), onSurfaceContainerHighest: Color = Color(0xFFE9E9E9), outline: Color = Color(0xFF404040), dividerLine: Color = Color(0xFF393939), windowDimming: Color = Color.Black.copy(alpha = 0.6F), sliderKeyPoint: Color = Color(0x4D7A8AA6), sliderKeyPointForeground: Color = Color(0xFF5DAAFF), sliderBackground: Color = Color(0x26FFFFFF), )
```


## theme/MiuixTheme.kt

```kotlin
@Composable fun MiuixTheme( controller: ThemeController, textStyles: TextStyles = MiuixTheme.textStyles, content: @Composable () -> Unit, )
```

```kotlin
@Composable fun MiuixTheme( colors: Colors = MiuixTheme.colorScheme, textStyles: TextStyles = MiuixTheme.textStyles, content: @Composable () -> Unit, )
```


## theme/TextStyles.kt

```kotlin
fun defaultTextStyles( main: TextStyle = Main, paragraph: TextStyle = Paragraph, body1: TextStyle = Body1, body2: TextStyle = Body2, button: TextStyle = Button, footnote1: TextStyle = Footnote1, footnote2: TextStyle = Footnote2, headline1: TextStyle = Headline1, headline2: TextStyle = Headline2, subtitle: TextStyle = Subtitle, title1: TextStyle = Title1, title2: TextStyle = Title2, title3: TextStyle = Title3, title4: TextStyle = Title4, )
```


## window/WindowBottomSheet.kt

```kotlin
@Composable fun WindowBottomSheet( show: Boolean, modifier: Modifier = Modifier, title: String? = null, startAction: @Composable (() -> Unit)? = null, endAction: @Composable (() -> Unit)? = null, backgroundColor: Color = BottomSheetDefaults.backgroundColor(), enableWindowDim: Boolean = true, cornerRadius: Dp = BottomSheetDefaults.cornerRadius, sheetMaxWidth: Dp = BottomSheetDefaults.maxWidth, onDismissRequest: (() -> Unit)? = null, onDismissFinished: (() -> Unit)? = null, outsideMargin: DpSize = BottomSheetDefaults.outsideMargin, insideMargin: DpSize = BottomSheetDefaults.insideMargin, defaultWindowInsetsPadding: Boolean = true, dragHandleColor: Color = BottomSheetDefaults.dragHandleColor(), allowDismiss: Boolean = true, enableNestedScroll: Boolean = true, content: @Composable () -> Unit, )
```

## 主题颜色 token

primary, onPrimary, primaryVariant, onPrimaryVariant, error, onError, errorContainer, onErrorContainer, disabledPrimary, disabledOnPrimary, disabledPrimaryButton, disabledOnPrimaryButton, disabledPrimarySlider, primaryContainer, onPrimaryContainer, secondary, onSecondary, secondaryVariant, onSecondaryVariant, disabledSecondary, disabledOnSecondary, disabledSecondaryVariant, disabledOnSecondaryVariant, secondaryContainer, onSecondaryContainer, secondaryContainerVariant, onSecondaryContainerVariant, tertiaryContainer, onTertiaryContainer, tertiaryContainerVariant, background, onBackground, onBackgroundVariant, surface, onSurface, surfaceVariant, onSurfaceSecondary, onSurfaceVariantSummary, onSurfaceVariantActions, disabledOnSurface, surfaceContainer, onSurfaceContainer, onSurfaceContainerVariant, surfaceContainerHigh, onSurfaceContainerHigh, surfaceContainerHighest, onSurfaceContainerHighest, outline, dividerLine, windowDimming, sliderKeyPoint, sliderKeyPointForeground, sliderBackground

## 文字样式 token

main, paragraph, body1, body2, button, footnote1, footnote2, headline1, headline2, subtitle, title1, title2, title3, title4

## enum ThemeColorSpec

Spec2021, Spec2025

## enum ThemePaletteStyle

TonalSpot, Neutral, Vibrant, Expressive, Rainbow, FruitSalad, Monochrome, Fidelity, Content

## enum ColorSchemeMode

System, Light, Dark, MonetSystem, MonetLight, MonetDark


## 各组件的 Defaults 默认样式值

### ArrowPreferenceDefaults
- color = MiuixTheme.colorScheme.onSurfaceVariantActions
- disabledColor = MiuixTheme.colorScheme.disabledOnSecondaryVariant

### BreadcrumbBarDefaults
- InsideMargin = PaddingValues(horizontal = 12.dp, vertical = 8.dp)
- ItemHeight = 32.dp
- ItemHorizontalPadding = 10.dp
- ItemMaxWidth = 160.dp

### ButtonDefaults
- MinWidth = 58.dp
- MinHeight = 40.dp
- CornerRadius = 16.dp
- InsideMargin = PaddingValues(horizontal = 16.dp, vertical = 13.dp)

### BasicComponentDefaults
- InsideMargin = PaddingValues(16.dp)

### FloatingActionButtonDefaults
- MinWidth = 60.dp
- MinHeight = 60.dp
- ShadowElevation = 4.dp

### ListPopupDefaults
- FractionAnimationSpec = spring(dampingRatio = 0.82f, stiffness = 362.5f, visibilityThreshold = 0.0001f)
- AlphaEnterAnimationSpec = tween<Float>(durationMillis = 200)
- AlphaExitAnimationSpec = tween<Float>(durationMillis = 150)
- DimEnterAnimationSpec = tween<Float>(durationMillis = 300, easing = SinOutEasing)
- DimExitAnimationSpec = tween<Float>(durationMillis = 150, easing = SinOutEasing)
- ResetAnimationSpec = spring(dampingRatio = 0.82f, stiffness = 362.5f, visibilityThreshold = 0.0001f)
- MinWidth = 200.dp
- MinPopupHeight = 50.dp
- margins = PaddingValues(horizontal = horizontalMargin, vertical = verticalMargin)
- offsetX = if (alignment.resolve(layoutDirection) == PopupPositionProvider.Align.End) {
- offsetY = if (windowBounds.bottom - anchorBounds.bottom > popupContentSize.height) {
- DropdownPositionProvider = dropdownPositionProvider()
- ContextMenuPositionProvider = object : PopupPositionProvider {

### NavigationBarDefaults
- ItemHeight = 64.dp
- IconSize = 26.dp
- LabelFontSize = 12.sp
- IconTopPadding = 8.dp
- BottomPadding = 8.dp
- SelectedPressedAlpha = 0.5f
- UnselectedPressedAlpha = 0.6f
- UnselectedAlpha = 0.4f

### FloatingNavigationBarDefaults
- HorizontalOutSidePadding = 36.dp
- ShadowElevation = 1.dp
- HorizontalPadding = 12.dp
- ItemSpacing = 12.dp
- IconSize = 28.dp
- IconPadding = 10.dp
- SelectedPressedAlpha = 0.5f
- UnselectedPressedAlpha = 0.6f
- UnselectedAlpha = 0.4f

### NavigationRailDefaults
- MinWidth = 80.dp
- ExpandedWidth = 240.dp
- VerticalPadding = 24.dp
- HeaderSpacing = 24.dp
- IconSize = 28.dp
- IconTextSpacing = 4.dp
- ItemVerticalPadding = 12.dp
- LabelFontSize = 12.sp
- ExpandedLabelFontSize = 16.sp
- ExpandedItemHorizontalMargin = 12.dp
- ExpandedItemCornerRadius = 16.dp
- CollapsedIndicatorVerticalPadding = 4.dp
- ExpandedItemContentHorizontalPadding = 14.dp
- ExpandedItemContentVerticalPadding = 14.dp
- ExpandedItemIconTextSpacing = 16.dp
- ExpandContentDescription = "Expand navigation rail"
- CollapseContentDescription = "Collapse navigation rail"

### PullToRefreshDefaults
- color = Color.Gray
- circleSize = 20.dp
- refreshTexts = listOf(
- refreshTextStyle = TextStyle(

### ScrollBarDefaults
- ThumbWidth = 3.64.dp
- EndPadding = 3.46.dp
- ThumbMinLength = 36.dp
- CornerRadius = Dp.Unspecified
- FadeDelayMillis = 1000
- FadeDurationMillis = 500
- TouchTargetWidth = 48.dp
- DragThumbWidth = 6.dp
- ThumbAlpha = 0.1f
- DragThumbAlpha = 0.3f
- DragAnimationDurationMillis = 150

### SearchBarDefaults
- InsideMargin = DpSize(12.dp, 0.dp)
- InputFieldMinHeight = 45.dp
- InputFieldFontSize = 17.sp
- LeadingIconStartPadding = 16.dp
- LeadingIconEndPadding = 8.dp
- TrailingIconStartPadding = 8.dp
- TrailingIconEndPadding = 16.dp

### SliderDefaults
- MinHeight = 28.dp
- KeyPointRadius = 3.855.dp
- DefaultHapticEffect = SliderHapticEffect.Edge

### SnackbarDefaults
- CornerRadius = 16.dp
- InsideMargin = PaddingValues(all = 12.dp)
- OuterPadding = PaddingValues(start = 12.dp, end = 12.dp, top = 8.dp)
- ActionCornerRadius = 50.dp
- ActionInsideMargin = PaddingValues(horizontal = 12.dp, vertical = 0.dp)

### TabRowDefaults
- TabRowHeight = 42.dp
- TabRowWithContourHeight = 45.dp
- TabRowCornerRadius = 12.dp
- TabRowWithContourCornerRadius = 8.dp
- TabRowMinWidth = 76.dp
- TabRowWithContourMinWidth = 62.dp
- TabRowMaxWidth = 98.dp
- TabRowWithContourMaxWidth = 84.dp

### TextFieldDefaults
- CornerRadius = 16.dp
- InsideMargin = DpSize(16.dp, 16.dp)
- BorderWidth = 2.dp
- LabelFontSizeFloating = 10.dp
- LabelFontSizeNormal = 17.dp

### TooltipDefaults
- SpacingBetweenTooltipAndAnchor = 8.dp
- caretSize = DpSize(16.dp, 8.dp)
- PlainTooltipMaxWidth = 200.dp
- PlainTooltipCornerRadius = 12.dp
- PlainTooltipInsideMargin = PaddingValues(horizontal = 12.dp, vertical = 8.dp)
- RichTooltipMaxWidth = 320.dp
- RichTooltipCornerRadius = 16.dp
- RichTooltipInsideMargin = PaddingValues(all = 16.dp)
- RichTooltipActionCornerRadius = 8.dp
- RichTooltipActionInsideMargin = PaddingValues(horizontal = 12.dp, vertical = 6.dp)
- spacingPx = with(LocalDensity.current) { spacingBetweenTooltipAndAnchor.roundToPx() }
