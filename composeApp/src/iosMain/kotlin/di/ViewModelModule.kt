package di

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import ui.MainViewModel

actual val viewModelModule = module {
    singleOf(::MainViewModel)
}