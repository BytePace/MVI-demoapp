package com.bytepace.mvi_demo_app.interactor.implementation

import com.bytepace.mvi_demo_app.interactor.DownloadRandomImageInteractor
import com.bytepace.mvi_demo_app.model.Image
import com.bytepace.mvi_demo_app.networking.ImagesApi
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers

class DownloadRandomImageInteractorImpl(private val imagesApi: ImagesApi): DownloadRandomImageInteractor {
    override fun getRandomImage(): Observable<Image> {
        return imagesApi.getRandomImage()
            .map { Image(it.first().url ?: "") }
            .observeOn(AndroidSchedulers.mainThread())
    }
}