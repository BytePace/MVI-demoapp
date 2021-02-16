package com.bytepace.mvi_demo_app.networking

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface CatApi: ImagesApi {
    @GET("images/search")
    fun getRandomImage(
        @Query("limit") limit: Int = 1,
        @Query("page") page: Int = 1,
        @Query("x-api-key") apiKey: String = "c2d780b2-15e4-4711-ae5a-18aa2fe0df0d",
        @Query("size") size: String = "med",
        @Query("type") type: String = "jpg",
        @Query("format") format: String = "json"
    ): Observable<List<Response>>
}