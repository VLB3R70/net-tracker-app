import core.NettrackerClient
import io.ktor.client.*
import io.ktor.client.engine.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class Greeting {
    private val client = NettrackerClient(serverAddress = "192.168.1.132")

    suspend fun greeting(): String {
        val networks = client.getNetworkFromName("redCasa")
        return Json.encodeToString(networks)
    }
}
