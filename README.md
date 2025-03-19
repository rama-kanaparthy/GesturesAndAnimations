## Jetpack Compose Animations Cheat Sheet

| Animation | Description |
|-----------|------------|
| `animateFloatAsState()` | Simple animations (size, opacity) |
| `animateContentSize()` | Auto-resizing animations |
| `Crossfade()` | Smooth UI state transitions |
| `rememberInfiniteTransition()` | Looping animations (e.g., pulsing) |
| `AnimatedVisibility()` | Show/hide UI elements with effects |
| `updateTransition()` | Animate multiple properties together |
| `AnimatedContent()` | Animate between content changes |
| `SwipeToDismiss()` | Swipe away list items |
| `Custom Enter/Exit` | Fade, scale, slide animations |

### Example Code Snippets

#### `animateFloatAsState()` - Simple Animation
```kotlin
val size by animateDpAsState(
    targetValue = if (expanded) 200.dp else 100.dp,
    animationSpec = tween(durationMillis = 500)
)
```

#### `animateContentSize()` - Auto Adjust Size
```kotlin
Box(
    modifier = Modifier.animateContentSize().background(Color.Red).clickable { expanded = !expanded }
) { /* Content */ }
```

#### `Crossfade()` - UI State Change
```kotlin
Crossfade(targetState = isFirst) { showFirst ->
    if (showFirst) Box(Modifier.size(100.dp).background(Color.Blue))
    else Box(Modifier.size(100.dp).background(Color.Green))
}
```

#### `rememberInfiniteTransition()` - Looping Animation
```kotlin
val scale by rememberInfiniteTransition().animateFloat(
    initialValue = 0.8f,
    targetValue = 1.2f,
    animationSpec = infiniteRepeatable(
        animation = tween(1000, easing = FastOutSlowInEasing),
        repeatMode = RepeatMode.Reverse
    )
)
```

#### `AnimatedVisibility()` - Toggle Visibility
```kotlin
AnimatedVisibility(visible) {
    Box(Modifier.size(100.dp).background(Color.Cyan))
}
```

#### `SwipeToDismiss()` - Swipe to Delete
```kotlin
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SwipeToDismissExample() {
    val dismissState = rememberDismissState()
    SwipeToDismiss(
        state = dismissState,
        directions = setOf(DismissDirection.EndToStart),
        background = { Box(Modifier.fillMaxSize().background(Color.Red)) },
        dismissContent = { Text("Swipe me", Modifier.padding(16.dp)) }
    )
}
```

🚀 **Use these animations to enhance your Jetpack Compose UI!**

