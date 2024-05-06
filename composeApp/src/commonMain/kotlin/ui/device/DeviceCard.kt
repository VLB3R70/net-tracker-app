package ui.device

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import model.Device

@Composable
fun DeviceCard(device: Device) {
    Card {
        Column {
            Text(device.deviceId)
            Text(device.deviceName)
            Text(device.address)
            Text(device.osType)
            Column {
                for (service in device.services){
                    Card {
                        Text(service.name)
                        Text(service.port.toString())
                        Text(service.protocol)
                    }
                }
            }
        }
    }
}