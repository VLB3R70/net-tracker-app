package ui.service

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import model.Service

@Composable
fun ServiceTable(services: List<Service>) {
    Column(
        modifier = Modifier.padding(8.dp)
    ) {
        Row(
            modifier = Modifier.padding(8.dp).fillMaxWidth()
        ) {
            Text(text = "Name", modifier = Modifier.weight(1f), fontWeight = FontWeight.Bold)
            Text(text = "Port", modifier = Modifier.weight(1f), fontWeight = FontWeight.Bold)
            Text(text = "Protocol", modifier = Modifier.weight(1f), fontWeight = FontWeight.Bold)
        }
        HorizontalDivider(
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        )
        services.forEach { service ->
            Row(
                modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = service.name, modifier = Modifier.weight(1f))
                Text(text = service.port.toString(), modifier = Modifier.weight(1f))
                Text(text = service.protocol, modifier = Modifier.weight(1f))
            }
            Divider(
                modifier = Modifier.fillMaxWidth().padding(8.dp)
            )
        }
    }
}
