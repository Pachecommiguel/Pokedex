package com.example.domain.application

import android.app.Application
import android.content.res.Resources
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {

    companion object {
        lateinit var resources: Resources private set
    }

    override fun onCreate() {
        super.onCreate()
        Companion.resources = resources
    }
}