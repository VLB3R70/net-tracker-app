package core

import io.ktor.client.*
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.request.*
import model.Network
import io.ktor.client.plugins.contentnegotiation.*
import kotlinx.serialization.json.*
import io.ktor.serialization.kotlinx.json.*

class NettrackerClient(
    private val client: HttpClient = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
                allowStructuredMapKeys=true
            })
        }
    }, private val serverAddress: String
) {

    suspend fun getNetworks(): List<Network> {
        val result: List<Network> = client.get("http://$serverAddress:5000/networks").body()
        return result
    }

    suspend fun getNetworkFromName(networkName: String): Network {
        return client.get("http://$serverAddress:5000/networks/$networkName").body()
    }

    suspend fun getDeviceFromAddress(networkName: String, address:String){
        return client.get("http://$serverAddress:5000/networks/$networkName/devices/$address").body()
    }

}