package com.bytepace.mvi_demo_app.ui.fragments.images

import com.badoo.binder.using
import com.badoo.mvicore.android.AndroidBindings
import com.bytepace.mvi_demo_app.ui.fragments.images.event.UiEventTransformer
import com.bytepace.mvi_demo_app.ui.fragments.images.feature.Feature
import com.bytepace.mvi_demo_app.ui.fragments.images.news.NewsListener
import com.bytepace.mvi_demo_app.ui.fragments.images.viewmodel.ViewModelTransformer

class ImagesFragmentBindings(
    view: ImagesFragment,
    private val feature: Feature,
    private val newsListener: NewsListener
) : AndroidBindings<ImagesFragment>(view) {
    override fun setup(view: ImagesFragment) {
        binder.bind(feature to view using ViewModelTransformer())
        binder.bind(view to feature using UiEventTransformer())
        binder.bind(feature.news to newsListener)
    }
}