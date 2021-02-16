package com.bytepace.mvi_demo_app.di.components

import com.bytepace.mvi_demo_app.di.modules.NetworkingModule
import com.bytepace.mvi_demo_app.di.scope.ActivityScope
import com.bytepace.mvi_demo_app.di.scope.FragmentScope
import com.bytepace.mvi_demo_app.networking.ImagesApi
import com.bytepace.mvi_demo_app.ui.fragments.images.ImagesFragment
import dagger.Component

@FragmentScope
@Component(
    dependencies = [
        InteractorComponent::class
    ],
    modules = [
        NetworkingModule::class
    ]
)
interface NetworkingComponent {
    fun inject(fragment: ImagesFragment)

    fun provideImagesApi(): ImagesApi
}