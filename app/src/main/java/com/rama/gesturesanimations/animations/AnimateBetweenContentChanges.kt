package com.rama.gesturesanimations.animations

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.sp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AnimatedTextChange() {
    var count by remember { mutableStateOf(0) }
    Column(
        modifier = Modifier.padding(32.dp).fillMaxSize(),
        verticalArrangement = Arrangement.Center
        ) {
        AnimatedContent(targetState = count) { targetCount ->
            Text(text = "Count: $targetCount", fontSize = 24.sp)
        }

        Button(onClick = { count++ }) {
            Text("Increase Count")
        }
    }

}
