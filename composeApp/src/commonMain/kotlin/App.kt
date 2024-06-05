
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinContext

import com.example.home.navigation.addHomeScreen

@Composable
@Preview
fun App() {
    MaterialTheme {
        KoinContext {
            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = "home"
            ) {
                addHomeScreen()
            }
        }
    }
}

