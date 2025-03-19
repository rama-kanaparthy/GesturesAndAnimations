@file:Suppress("DEPRECATION")

package com.rama.gesturesanimations.animations
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.*
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.background
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SwipeToDismissExample() {
    val items = remember { mutableStateListOf("Item 1", "Item 2", "Item 3") }
    val coroutineScope = rememberCoroutineScope()

    LazyColumn {
        items(items.size) { index ->
            val dismissState = rememberDismissState(
                confirmStateChange = { dismissValue ->
                    if (dismissValue == DismissValue.DismissedToStart) {
                        coroutineScope.launch {
                            items.removeAt(index) // Remove item on swipe
                        }
                    }
                    true
                }
            )

            SwipeToDismiss(
                state = dismissState,
                directions = setOf(DismissDirection.EndToStart),
                background = {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color.Red)
                            .padding(16.dp),
                        contentAlignment = Alignment.CenterEnd
                    ) {
                        Text("Deleting...", color = Color.White)
                    }
                },
                dismissContent = {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        elevation = 4.dp
                    ) {
                        Text(
                            text = items[index],
                            modifier = Modifier.padding(16.dp)
                        )
                    }
                }
            )
        }
    }
}

