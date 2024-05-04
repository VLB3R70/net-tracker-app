package ui.network

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import core.NettrackerClient
import kotlinx.coroutines.launch
import model.Network

@Composable
fun NetworkListView(innerPadding: PaddingValues, client: NettrackerClient) {
    var networks by remember { mutableStateOf(emptyList<Network>()) }
    val scope = rememberCoroutineScope()

    LaunchedEffect(true) {
        scope.launch {
            networks = try {
                client.getNetworks()
            } catch (e: Exception) {
                networks
            }
        }
    }

    LazyColumn(
        contentPadding = innerPadding,
    ) {
        items(networks) { network ->
            NetworkCard(networkAddress = network.address, networkName = network.networkName)
        }
    }
}