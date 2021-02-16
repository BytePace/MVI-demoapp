package com.bytepace.mvi_demo_app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bytepace.mvi_demo_app.navigation.Navigator
import com.bytepace.mvi_demo_app.navigation.Screens
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import javax.inject.Inject

class MainActivity : AppCompatActivity(R.layout.main_activity) {
    @Inject
    lateinit var router: Router

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    val app: App
        get() = applicationContext as App

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        app.appComponent.inject(this)
        navigatorHolder.setNavigator(Navigator(this, R.id.container))
        router.replaceScreen(Screens.firstScreen())
    }
}