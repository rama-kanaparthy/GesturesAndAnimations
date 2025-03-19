package com.rama.gesturesanimations.animations

import androidx.compose.animation.core.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.ui.tooling.preview.Preview
import com.rama.gesturesanimations.Greeting
import com.rama.gesturesanimations.ui.theme.GesturesAnimationsTheme

@Composable
fun SimpleAnimation() {
    var expanded by remember { mutableStateOf(false) }

    val size by animateDpAsState(
        targetValue = if (expanded) 200.dp else 100.dp,
        animationSpec = tween(durationMillis = 500)
    )

    Box(
        modifier = Modifier
            .size(size)
            .background(Color.Blue)
            .clickable { expanded = !expanded }
    )
}



@Preview(showBackground = true, device = "id:pixel_8a")
@Composable
fun GreetingPreview() {
    GesturesAnimationsTheme {
        SimpleAnimation()
    }
}