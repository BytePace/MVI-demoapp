package com.bytepace.mvi_demo_app.di

import com.bytepace.mvi_demo_app.MainActivity
import com.bytepace.mvi_demo_app.di.modules.NavigationModule
import com.bytepace.mvi_demo_app.ui.main.MainFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NavigationModule::class])
interface AppComponent {
    fun inject(activity: MainActivity)

    fun inject(fragment: MainFragment)
}
