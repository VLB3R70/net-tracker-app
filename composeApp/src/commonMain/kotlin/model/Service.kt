package model

import kotlinx.serialization.*

@Serializable
data class Service(
    val name: String, val port: Int, val protocol: String
)
