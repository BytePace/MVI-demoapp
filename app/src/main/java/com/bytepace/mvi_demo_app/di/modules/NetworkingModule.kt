package com.bytepace.mvi_demo_app.di.modules

import com.bytepace.mvi_demo_app.di.scope.FragmentScope
import com.bytepace.mvi_demo_app.networking.CatApi
import com.bytepace.mvi_demo_app.networking.ImagesApi
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkingModule {
    @Provides
    @FragmentScope
    fun imagesApi(): ImagesApi {
        return Retrofit.Builder()
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
            .create(CatApi::class.java)
    }
}
