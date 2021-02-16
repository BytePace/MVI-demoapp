package com.bytepace.mvi_demo_app.di.modules

import com.bytepace.mvi_demo_app.di.scope.ActivityScope
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class NavigationModule {
    @Provides
    @ActivityScope
    fun cicerone(): Cicerone<Router> {
        return Cicerone.create()
    }

    @Provides
    @ActivityScope
    fun ciceroneRouter(cicerone: Cicerone<Router>): Router {
        return cicerone.router
    }

    @Provides
    @ActivityScope
    fun ciceroneHolder(cicerone: Cicerone<Router>): NavigatorHolder {
        return cicerone.getNavigatorHolder()
    }
}
