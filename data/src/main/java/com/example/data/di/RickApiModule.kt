package com.example.data.di

import com.example.data.rickapi.RickApiInfrastructure
import com.example.domain.services.RickApiService
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.singleton

val RickApiModule = DI.Module("rickApi"){
    bind<RickApiService>() with singleton {
        RickApiInfrastructure()
    }
}