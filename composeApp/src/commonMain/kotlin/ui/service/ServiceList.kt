package ui.service

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import model.Service

@Composable
fun ServiceList(services: List<Service>) {
    Column {
        services.forEach { service ->
            Text(text = service.name)
            Text(text = service.port.toString())
            Text(text = service.protocol)
        }
    }
}