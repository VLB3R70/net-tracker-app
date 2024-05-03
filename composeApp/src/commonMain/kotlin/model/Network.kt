package model

import kotlinx.serialization.*

@Serializable
data class Network(
    @SerialName("_id")
    val networkId: String,
    val address: String,
    val devices: List<Device>? = null,
    val gateway: Device? = null,
    @SerialName("network_name")
    val networkName: String,
    @SerialName("subnet_mask")
    val subnetMask: Int,
)