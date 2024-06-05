package com.example.home.di

import com.example.home.HomeViewModel
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

actual val homeModelModule = module {
    single { HomeViewModel() }
}