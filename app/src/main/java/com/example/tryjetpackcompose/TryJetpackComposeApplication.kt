package com.example.tryjetpackcompose

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class TryJetpackComposeApplication : Application() {

    override fun onCreate() {
        super.onCreate()
    }
}
