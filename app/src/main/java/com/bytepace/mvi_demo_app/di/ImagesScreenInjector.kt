package com.bytepace.mvi_demo_app.di

import com.bytepace.mvi_demo_app.di.components.ImagesScreenComponent
import com.bytepace.mvi_demo_app.di.modules.ImagesScreenModule
import com.bytepace.mvi_demo_app.di.modules.InteractorModule
import com.bytepace.mvi_demo_app.ui.fragments.images.ImagesFragment

object ImagesScreenInjector {
    fun get(fragment: ImagesFragment): ImagesScreenComponent =
        DaggerImagesScreenComponent.builder()
            .interactorModule(InteractorModule())
            .imagesScreenModule(ImagesScreenModule(fragment))
            .build()
}