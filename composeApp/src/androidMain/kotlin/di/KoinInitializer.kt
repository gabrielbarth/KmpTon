package di

import android.content.Context
import com.example.home.di.dataModule
import com.example.home.di.homeModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

actual class KoinInitializer(private val context: Context) {
    actual fun init() {
        startKoin{
            androidContext(context)
            androidLogger()
            modules(dataModule, viewModelModule, homeModelModule)
        }
    }
}