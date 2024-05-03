package model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Device(
    @SerialName("_id")
    val deviceId: String,
    val address: String,
    @SerialName("device_name")
    val deviceName: String,
    @SerialName("os_type")
    val osType: String,
    val services: List<Service>,
)
