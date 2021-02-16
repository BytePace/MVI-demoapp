package com.bytepace.mvi_demo_app.networking

import io.reactivex.Observable

interface ImagesApi {
    fun getRandomImage(): Observable<List<Response>>
}