package com.bytepace.mvi_demo_app.interactor

import com.bytepace.mvi_demo_app.model.Image
import io.reactivex.Observable

interface DownloadRandomImageInteractor {
    fun getRandomImage(): Observable<Image>
}