import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import core.NettrackerClient
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.ui.tooling.preview.Preview

import ui.MainPage

@OptIn(ExperimentalResourceApi::class)
@Composable
@Preview
fun App() {
    MaterialTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
//            val scope = rememberCoroutineScope()
//            var text by remember { mutableStateOf("Loading") }
//            LaunchedEffect(true) {
//                scope.launch {
//                    text = try {
//                        Greeting().greeting()
//                    } catch (e: Exception) {
//                        e.message ?: "error"
//                    }
//                }
//            }
//            GreetingView(text)
            val client = NettrackerClient(serverAddress = null.toString())
            MainPage(client)
        }
    }
}

@Composable
fun GreetingView(text: String) {
    Text(text = text)
}

