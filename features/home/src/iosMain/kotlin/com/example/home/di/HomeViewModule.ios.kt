package com.example.home.di

import com.example.home.HomeViewModel
import org.koin.dsl.module

actual val homeModelModule = module {
    single { HomeViewModel() }
}