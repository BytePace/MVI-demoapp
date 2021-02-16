package com.bytepace.mvi_demo_app.di.modules

import com.bytepace.mvi_demo_app.di.scope.ActivityScope
import com.bytepace.mvi_demo_app.di.scope.FragmentScope
import com.bytepace.mvi_demo_app.interactor.DownloadRandomImageInteractor
import com.bytepace.mvi_demo_app.interactor.implementation.DownloadRandomImageInteractorImpl
import com.bytepace.mvi_demo_app.networking.ImagesApi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class InteractorModule {
    @Provides
    @FragmentScope
    fun downloadRandomImageInteractor(imagesApi: ImagesApi): DownloadRandomImageInteractor {
        return DownloadRandomImageInteractorImpl(imagesApi)
    }
}