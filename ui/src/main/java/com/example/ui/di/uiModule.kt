package com.example.ui.di

import com.example.domain.services.RickApiService
import com.example.ui.viewmodels.MainActivityViewModel
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.singleton

val uiModule = DI.Module("uiModule"){
    bind<MainActivityViewModel>() with singleton {
        MainActivityViewModel(instance<RickApiService>())
    }
}