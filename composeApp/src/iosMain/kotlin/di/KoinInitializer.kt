package di

import com.example.home.di.dataModule
import com.example.home.di.homeModelModule
import org.koin.core.context.startKoin

actual class KoinInitializer {
    actual fun init() {
        startKoin{
            modules(dataModule, viewModelModule, homeModelModule)
        }
    }
}