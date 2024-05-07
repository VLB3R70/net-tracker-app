package ui.network

import androidx.compose.foundation.layout.Column
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
import model.Network
import ui.errors.NetworkErrorCard

@Composable
fun NetworkListView(navController: NavHostController, client: NettrackerClient?) {
    var networks by remember { mutableStateOf(emptyList<Network>()) }
    var errors by remember { mutableStateOf(false) }
    var capturedException: Exception? by remember { mutableStateOf(null) }
    val scope = rememberCoroutineScope()

    LaunchedEffect(true) {
        try {
            if (client != null) {
                networks = client.getNetworks()
            }
        } catch (e: Exception) {
            errors = true
            capturedException = e
        }
    }


    if (errors){
        Column {
            capturedException?.let { NetworkErrorCard(it) }
        }
    }else{
        LazyColumn(
            modifier = Modifier.padding(8.dp).fillMaxWidth(),
        ) {
            items(networks) { network ->
                NetworkCard(navController = navController, network)
            }
        }
    }
}