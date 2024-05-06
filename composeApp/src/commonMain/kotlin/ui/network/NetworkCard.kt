package ui.network

import Routes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import model.Network
import net_tracker_app.composeapp.generated.resources.Res
import net_tracker_app.composeapp.generated.resources.network_address_on_list
import net_tracker_app.composeapp.generated.resources.network_submask_on_list
import net_tracker_app.composeapp.generated.resources.network_wired_solid
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@OptIn(ExperimentalResourceApi::class, ExperimentalMaterialApi::class)
@Composable
fun NetworkCard(navController: NavController, network: Network) {
    Card(
        modifier = Modifier.padding(8.dp).fillMaxWidth(),
        elevation = 4.dp,
        onClick = {
            navController.navigate("${Routes.DevicesPage.name}/${network.networkName}")
        }
    ) {
        Row(
            modifier = Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(resource = Res.drawable.network_wired_solid),
                contentDescription = "Description"
            )
            Column(
                modifier = Modifier.padding(8.dp)
            ) {
                Text(
                    text = network.networkName,
                    fontSize = 30.sp,
                )
                Text(stringResource(Res.string.network_address_on_list) + network.address)
                Text(stringResource(Res.string.network_submask_on_list) + network.subnetMask.toString())
            }
        }
    }
}