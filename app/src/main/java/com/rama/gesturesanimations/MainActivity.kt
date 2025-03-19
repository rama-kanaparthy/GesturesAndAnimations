package com.rama.gesturesanimations

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rama.gesturesanimations.animations.AnimateContentSizeExample
import com.rama.gesturesanimations.animations.CrossfadeExample
import com.rama.gesturesanimations.animations.InfinitePulseExample
import com.rama.gesturesanimations.animations.SimpleAnimation
import com.rama.gesturesanimations.ui.theme.GesturesAnimationsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GesturesAnimationsTheme {
                Surface {
                    InfinitePulseExample()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    var counter = remember { mutableStateOf(0) }
    Column(
        modifier = Modifier.padding(16.dp).fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Box(
            contentAlignment = Alignment.TopCenter,
            modifier = Modifier.padding(16.dp).fillMaxWidth().weight(1f)
        ) {
            Text(
                text = "${counter.value}",
                modifier = modifier,
                fontSize = 100.sp
            )
        }

        Box(
            contentAlignment = Alignment.BottomCenter,
            modifier = Modifier.padding(16.dp).fillMaxWidth().weight(1f)
        ) {
            Icon(
                imageVector = Icons.Filled.Favorite,
                contentDescription = "Like",
                modifier = Modifier.size(150.dp).pointerInput(Unit) {
                    detectTapGestures(
                        onTap = { counter.value++ },       // Single Click - Increment by 1
                        onDoubleTap = { counter.value = 100 }, // Double Click - Increment by 2
                        onLongPress = { counter.value-- }  // Long Press - Reset Counter
                    )
                }
            )
        }
    }

}

@Preview(showBackground = true, device = "id:pixel_8a")
@Composable
fun GreetingPreview() {
    GesturesAnimationsTheme {
        Greeting("Increment")
    }
}