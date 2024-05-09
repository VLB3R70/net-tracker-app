import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import core.NettrackerClient
import net_tracker_app.composeapp.generated.resources.Res
import net_tracker_app.composeapp.generated.resources.app_name
import net_tracker_app.composeapp.generated.resources.arrow_left_solid
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import ui.MainPage
import ui.device.DeviceList
import ui.network.NetworkListView

enum class Routes {
    Start, ServerFindPage, NetworksPage, DevicesPage
}

@OptIn(ExperimentalResourceApi::class)
@Composable
fun NetTrackerAppBar(
    currentScreen: Routes,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        modifier = modifier,
        title = { Text(text = stringResource(Res.string.app_name)) },
        backgroundColor = MaterialTheme.colors.primary,
        navigationIcon = {
            if (currentScreen == Routes.Start) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = ""
                    )
                }
            }
        }
    )
}

@Composable
fun App() {
    val navController = rememberNavController()
    val client = remember { NettrackerClient(serverAddress = "") }

    MaterialTheme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            Scaffold(topBar = {
                NetTrackerAppBar(currentScreen = Routes.Start,
                    canNavigateBack = false,
                    navigateUp = { navController.navigateUp() })
            }) { innerPadding ->
                NavHost(
                    navController = navController,
                    startDestination = Routes.ServerFindPage.name,
                    modifier = Modifier.fillMaxSize().padding(innerPadding)
                ) {
                    composable(
                        route = Routes.ServerFindPage.name,
                    ) {
                        MainPage(client, navController)
                    }
                    composable(
                        route = Routes.NetworksPage.name,
                    ) {
                        NetworkListView(navController, client)
                    }
                    composable(
                        "${Routes.DevicesPage.name}/{networkName}",
                        arguments = listOf(navArgument("networkName") { type = NavType.StringType })
                    ) { backStackEntry ->
                        val networkName = backStackEntry.arguments?.getString("networkName")
                        if (networkName != null) {
                            DeviceList(navController, client, networkName)
                        }
                    }
                }
            }
        }
    }
}
