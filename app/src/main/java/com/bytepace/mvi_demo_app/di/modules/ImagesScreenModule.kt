package com.bytepace.mvi_demo_app.di.modules

import android.content.Context
import android.os.Parcelable
import com.badoo.mvicore.element.TimeCapsule
import com.bytepace.mvi_demo_app.di.scope.FragmentScope
import com.bytepace.mvi_demo_app.interactor.DownloadRandomImageInteractor
import com.bytepace.mvi_demo_app.ui.fragments.images.ImagesFragment
import com.bytepace.mvi_demo_app.ui.fragments.images.ImagesFragmentBindings
import com.bytepace.mvi_demo_app.ui.fragments.images.feature.Feature
import com.bytepace.mvi_demo_app.ui.fragments.images.news.NewsListener
import dagger.Module
import dagger.Provides

@Module
class ImagesScreenModule(
    private val imagesFragment: ImagesFragment
) {
    @Provides
    fun imagesFragment(): ImagesFragment = imagesFragment

    @Provides
    @FragmentScope
    fun feature(downloadRandomImageInteractor: DownloadRandomImageInteractor): Feature =
        Feature(null, downloadRandomImageInteractor)

    @Provides
    @FragmentScope
    fun imagesFragmentBindings(
        view: ImagesFragment,
        feature: Feature,
        newsListener: NewsListener
    ): ImagesFragmentBindings = ImagesFragmentBindings(view, feature, newsListener)

    @Provides
    @FragmentScope
    fun newsListener(context: Context) = NewsListener(context)
}