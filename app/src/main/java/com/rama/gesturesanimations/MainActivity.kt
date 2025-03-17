package com.rama.gesturesanimations

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rama.gesturesanimations.ui.theme.GesturesAnimationsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GesturesAnimationsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Gestures",
                        modifier = Modifier.padding(innerPadding)
                    )
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
            Button(
                modifier = Modifier.padding(16.dp).fillMaxWidth(),
                onClick = {
                    counter.value++
                }
            ) {
                Text(
                    text = name,
                    fontSize = 24.sp
                )
            }
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