package com.example.composemapsstarter

import android.app.Application
import com.example.composemapsstarter.app.AppContainer
import com.example.composemapsstarter.app.DefaultAppContainer

class MapsComposeApplication : Application() {
    /** AppContainer instance used by the rest of classes to obtain dependencies */
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}