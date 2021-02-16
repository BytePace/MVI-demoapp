package com.bytepace.mvi_demo_app

import android.app.Application
import com.bytepace.mvi_demo_app.di.components.AppComponent
import com.bytepace.mvi_demo_app.di.DaggerAppComponent

class App : Application() {
    lateinit var appComponent: AppComponent
        private set

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
    }
}