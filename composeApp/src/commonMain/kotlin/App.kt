
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import com.example.home.HomeScreen
import com.example.theme.AppTheme


import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
@Preview
fun App() {
    AppTheme {
        Scaffold(
            content = {
                Navigator(HomeScreen())
            }
        )
    }
}

