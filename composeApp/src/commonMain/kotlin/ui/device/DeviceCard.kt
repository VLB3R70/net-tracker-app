package ui.device

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import model.Device
import net_tracker_app.composeapp.generated.resources.Res
import net_tracker_app.composeapp.generated.resources.amazon
import net_tracker_app.composeapp.generated.resources.android
import net_tracker_app.composeapp.generated.resources.apple
import net_tracker_app.composeapp.generated.resources.globe_solid
import net_tracker_app.composeapp.generated.resources.linux
import net_tracker_app.composeapp.generated.resources.services_device_card
import net_tracker_app.composeapp.generated.resources.windows
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import ui.service.ServiceList

@OptIn(ExperimentalResourceApi::class)
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
            Row(
                modifier = Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically
            ) {
                val osIcon = when {
                    device.osType.contains("Linux") -> Res.drawable.linux
                    device.osType.contains("Amazon") -> Res.drawable.amazon
                    device.osType.contains("Windows") -> Res.drawable.windows
                    device.osType.contains("MAC") || device.osType.contains("IOS") -> Res.drawable.apple
                    device.osType.contains("Android") -> Res.drawable.android
                    else -> Res.drawable.globe_solid
                }
                Image(
                    painter = painterResource(osIcon),
                    contentDescription = null,
                    modifier = Modifier.padding(8.dp)
                )
                Column(
                    Modifier.padding(8.dp)
                ) {
                    Text(device.deviceName)
                    Text(device.address)
                    Text(device.osType)
                }
            }
            AnimatedVisibility(visible) {
                Column(
                    modifier = Modifier.padding(8.dp)
                ) {
                    Divider(
                        modifier = Modifier.fillMaxWidth().padding(16.dp)
                    )
                    Text(
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        text = stringResource(Res.string.services_device_card)
                    )
                    ServiceList(device.services)
                }
            }
        }
    }
}