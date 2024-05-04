package ui.network

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import net_tracker_app.composeapp.generated.resources.Res
import net_tracker_app.composeapp.generated.resources.network_wired_solid
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class, ExperimentalMaterialApi::class)
@Composable
fun NetworkCard(networkName: String, networkAddress: String) {
    Card(elevation = 4.dp, onClick = {/**/}) {
        Row {
            Image(
                painter = painterResource(resource = Res.drawable.network_wired_solid),
                contentDescription = "Description"
            )
            Column {
                Text(networkName)
                Text(networkAddress)
            }
        }
    }
}