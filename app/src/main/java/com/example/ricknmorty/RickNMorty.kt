package com.example.ricknmorty

import android.app.Application
import com.example.data.di.RickApiModule
import com.example.ui.di.uiModule
import org.kodein.di.DI
import org.kodein.di.DIAware

class RickNMorty: Application(), DIAware {

    override val di = DI{
        import(RickApiModule)
        import(uiModule)
    }
    override fun onCreate() {
        super.onCreate()
    }

}