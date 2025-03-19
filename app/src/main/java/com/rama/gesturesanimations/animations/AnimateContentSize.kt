package com.rama.gesturesanimations.animations

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

@Composable
fun AnimateContentSizeExample() {
    var expanded by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .width(200.dp)
            .animateContentSize()  // Smoothly animates size changes
            .background(Color.Red)
            .clickable { expanded = !expanded }
    ) {
        Text(
            text = if (expanded) "Expanded Content" else "Tap to Expand",
            modifier = Modifier.padding(16.dp)
        )
    }
}
