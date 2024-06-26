package ui

import Routes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
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
import core.NettrackerClient
import net_tracker_app.composeapp.generated.resources.Res
import net_tracker_app.composeapp.generated.resources.find_server
import net_tracker_app.composeapp.generated.resources.server_address_main_page
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.stringResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun MainPage(client: NettrackerClient, navController: NavHostController) {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    Column(
        modifier = Modifier.fillMaxSize().padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(value = text,
            onValueChange = { newText -> text = newText },
            singleLine = true,
            placeholder = { Text(stringResource(Res.string.server_address_main_page)) })
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

