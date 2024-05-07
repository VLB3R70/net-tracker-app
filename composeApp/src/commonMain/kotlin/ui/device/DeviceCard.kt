package ui.device

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import model.Device
import ui.service.ServiceList

@Composable
fun DeviceCard(device: Device) {
    var visible by remember { mutableStateOf(false) }
    Card(
        modifier = Modifier.padding(8.dp).fillMaxWidth().clickable { visible = !visible },
        elevation = 4.dp,
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Text(device.deviceName)
            Text(device.address)
            Text(device.osType)
            AnimatedVisibility(visible) {
                ServiceList(device.services)
            }
        }
    }
}