package com.bytepace.mvi_demo_app.di.components

import com.bytepace.mvi_demo_app.di.modules.InteractorModule
import com.bytepace.mvi_demo_app.di.modules.NetworkingModule
import com.bytepace.mvi_demo_app.di.scope.ActivityScope
import com.bytepace.mvi_demo_app.di.scope.FragmentScope
import com.bytepace.mvi_demo_app.ui.fragments.images.ImagesFragment
import dagger.Component

@FragmentScope
@Component(
    dependencies = [
        ImagesScreenComponent::class
    ],
    modules = [
        InteractorModule::class,
        NetworkingModule::class
    ]
)
interface InteractorComponent {
    fun inject(fragment: ImagesFragment)
}