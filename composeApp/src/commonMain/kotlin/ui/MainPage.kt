package ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import core.NettrackerClient
import ui.network.NetworkListView

@Composable
fun MainPage(client: NettrackerClient) {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    Scaffold(topBar = {
        TopAppBar(contentColor = MaterialTheme.colors.primary, title = {
            Text(text = "APP")
        })
    }, floatingActionButton = {
        FloatingActionButton(
            onClick = {/*TODO*/ },
        ) {
            Icon(Icons.Filled.Add, "FAB")
        }
    }) { innerPadding ->
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                TextField(
                    value = text,
                    onValueChange = {
                        newText -> text = newText
                    }
                )
                Button(
                    shape = MaterialTheme.shapes.medium,
                    onClick = {
                              client.serverAddress
                    },
                ){
                    Text("Buscar")
                }
            }
            NetworkListView(innerPadding, client)
        }
    }
}