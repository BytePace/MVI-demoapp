package com.bytepace.mvi_demo_app.di.modules

import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class NavigationModule {
    @Provides
    @Singleton
    fun provideCicerone() : Cicerone<Router> {
        return Cicerone.create()
    }

    @Provides
    @Singleton
    fun provideCiceroneRouter(cicerone: Cicerone<Router>) : Router {
        return cicerone.router
    }

    @Provides
    @Singleton
    fun provideCiceroneHolder(cicerone: Cicerone<Router>) : NavigatorHolder {
        return cicerone.getNavigatorHolder()
    }
}
