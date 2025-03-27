## Jetpack Compose Animations & Gestures Cheat Sheet

### 🎨 **Animations**

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

#### Example Code Snippets
##### `animateFloatAsState()` - Simple Animation
```kotlin
val size by animateDpAsState(
    targetValue = if (expanded) 200.dp else 100.dp,
    animationSpec = tween(durationMillis = 500)
)
```


##### `animateContentSize()` - Auto Adjust Size
```kotlin
Box(
    modifier = Modifier.animateContentSize().background(Color.Red).clickable { expanded = !expanded }
) { /* Content */ }
```


##### `Crossfade()` - UI State Change
```kotlin
Crossfade(targetState = isFirst) { showFirst ->
    if (showFirst) Box(Modifier.size(100.dp).background(Color.Blue))
    else Box(Modifier.size(100.dp).background(Color.Green))
}
```

##### `rememberInfiniteTransition()` - Looping Animation
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

##### `AnimatedVisibility()` - Toggle Visibility
```kotlin
AnimatedVisibility(visible) {
    Box(Modifier.size(100.dp).background(Color.Cyan))
}
```

##### `SwipeToDismiss()` - Swipe to Delete
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

---

### ✋ **Gestures**

| Gesture | Description |
|---------|------------|
| `clickable {}` | Detects single taps |
| `combinedClickable {}` | Handles tap, long press, and double tap |
| `pointerInput {}` | Custom touch handling |
| `detectTapGestures()` | Detects tap, double tap, long press |
| `detectDragGestures()` | Detects drag movements |
| `detectTransformGestures()` | Detects pinch, zoom, rotation |

#### Example Code Snippets

##### `clickable {}` - Single Tap
```kotlin
Box(
    modifier = Modifier.size(100.dp).background(Color.Blue).clickable {
        println("Clicked!")
    }
)
```

##### `combinedClickable {}` - Multiple Gestures
```kotlin
Box(
    modifier = Modifier.size(100.dp).background(Color.Green).combinedClickable(
        onClick = { println("Single Click") },
        onDoubleClick = { println("Double Click") },
        onLongClick = { println("Long Press") }
    )
)
```

##### `detectTapGestures()` - Advanced Tap Handling
```kotlin
Modifier.pointerInput(Unit) {
    detectTapGestures(
        onTap = { println("Tapped") },
        onDoubleTap = { println("Double Tapped") },
        onLongPress = { println("Long Pressed") }
    )
}
```

##### `detectDragGestures()` - Drag Handling
```kotlin
Modifier.pointerInput(Unit) {
    detectDragGestures { change, dragAmount ->
        println("Dragging: $dragAmount")
    }
}
```

##### `detectTransformGestures()` - Pinch & Zoom
```kotlin
Modifier.pointerInput(Unit) {
    detectTransformGestures { _, pan, zoom, rotation ->
        println("Pan: $pan, Zoom: $zoom, Rotation: $rotation")
    }
}
```

🚀 **Use these gestures and animations to build smooth, interactive UI in Jetpack Compose!**

