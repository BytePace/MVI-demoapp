package com.bytepace.mvi_demo_app.networking

import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

interface CatApi {
    @GET("images/search")
    fun getRandomImage(
        @Query("limit") limit: Int = 1,
        @Query("page") page: Int = 1,
        @Query("x-api-key") apiKey: String = "c2d780b2-15e4-4711-ae5a-18aa2fe0df0d",
        @Query("size") size: String = "med",
        @Query("type") type: String = "jpg",
        @Query("format") format: String = "json"
    ): Single<List<Response>>

    companion object {
        private var retrofit = Retrofit.Builder()
            .baseUrl("https://api.thecatapi.com/v1/")
            .addCallAdapterFactory(
                RxJava2CallAdapterFactory.createWithScheduler(
                    Schedulers.io()
                )
            )
            .addConverterFactory(
                GsonConverterFactory.create()
            )
            .build()

        val service = retrofit.create(CatApi::class.java)
    }
}