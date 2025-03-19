package com.rama.gesturesanimations.animations

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
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
fun VisibilityExample() {
    var visible by remember { mutableStateOf(true) }

    Column {
        AnimatedVisibility(visible) {
            Box(modifier = Modifier.size(100.dp).background(Color.Cyan))
        }

        Button(onClick = { visible = !visible }) {
            Text("Toggle Visibility")
        }
    }
}
