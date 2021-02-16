package com.bytepace.mvi_demo_app.di.components

import com.bytepace.mvi_demo_app.di.modules.ImagesScreenModule
import com.bytepace.mvi_demo_app.di.modules.InteractorModule
import com.bytepace.mvi_demo_app.di.scope.FragmentScope
import com.bytepace.mvi_demo_app.ui.fragments.images.ImagesFragment
import dagger.Component

@FragmentScope
@Component(
    dependencies = [
        AppComponent::class
    ],
    modules = [
        InteractorModule::class,
        ImagesScreenModule::class
    ]
)
interface ImagesScreenComponent {
    fun inject(fragment: ImagesFragment)
}