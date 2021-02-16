package com.bytepace.mvi_demo_app.di.components

import com.bytepace.mvi_demo_app.di.modules.NetworkingModule
import com.bytepace.mvi_demo_app.di.scope.ActivityScope
import com.bytepace.mvi_demo_app.ui.fragments.images.ImagesFragment
import com.github.terrakok.cicerone.Router
import dagger.Component

@ActivityScope
@Component(
    dependencies = [
        AppComponent::class
    ],
    modules = [
        NetworkingModule::class
    ]
)
interface NavigationComponent {
    fun inject(fragment: ImagesFragment)

    fun provideRouter(): Router
}