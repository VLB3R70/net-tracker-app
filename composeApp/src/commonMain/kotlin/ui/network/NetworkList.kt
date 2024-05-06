package ui.network

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import core.NettrackerClient
import kotlinx.coroutines.launch
import model.Network

@Composable
fun NetworkListView(navController: NavHostController, client: NettrackerClient?) {
    var networks by remember { mutableStateOf(emptyList<Network>()) }
    val scope = rememberCoroutineScope()

    LaunchedEffect(true) {
        scope.launch {
            if (client != null) {
                networks = try {
                    client.getNetworks()
                } catch (e: Exception) {
                    networks
                }
            }
        }
    }

    LazyColumn(
        modifier = Modifier.padding(8.dp).fillMaxWidth(),
    ) {
        items(networks) { network ->
            NetworkCard(navController = navController, network)
        }
    }
}