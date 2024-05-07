package ui.device

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
import model.Device

@Composable
fun DeviceList(navController: NavHostController, client: NettrackerClient?, networkName: String) {
    var devices by remember { mutableStateOf(emptyList<Device>()) }
    val scope = rememberCoroutineScope()

    LaunchedEffect(true) {
        scope.launch {
            if (client != null) {
                devices = try {
                    client.getDevices(networkName)
                } catch (e: Exception) {
                    devices
                }
            }
        }
    }

    LazyColumn(
        modifier = Modifier.padding(8.dp).fillMaxWidth()
    ) {
        items(devices) { device ->
            DeviceCard(device)
        }
    }
}