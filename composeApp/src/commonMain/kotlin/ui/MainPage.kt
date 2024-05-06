package ui

import Routes
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.Navigator
import androidx.navigation.Navigator.Extras
import core.NettrackerClient
import net_tracker_app.composeapp.generated.resources.Res
import net_tracker_app.composeapp.generated.resources.find_server
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.stringResource

@OptIn(ExperimentalAnimationApi::class, ExperimentalResourceApi::class)
@Composable
fun MainPage(client: NettrackerClient, navController: NavHostController) {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    Column(
        modifier = Modifier.fillMaxSize().padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            TextField(value = text, onValueChange = { newText -> text = newText })
            Button(
                onClick = {
                    client.serverAddress = text.text
                    navController.navigate("${Routes.NetworksPage.name}?$client?$navController")
                }, modifier = Modifier.padding(start = 8.dp)
            ) {
                Text(stringResource(Res.string.find_server))
            }
        }
    }
}
