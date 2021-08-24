package com.example.unittesting

import android.app.Application

class StartApp: Application() {

    override fun onCreate() {
        super.onCreate()
        ItemsProvider.starEmitting()
    }
}