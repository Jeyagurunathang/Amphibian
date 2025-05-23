package com.example.amphibian

import android.app.Application
import com.example.amphibian.data.AppContainer
import com.example.amphibian.data.DefaultApplicationContainer

class AmphibianApplication : Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultApplicationContainer()
    }
}