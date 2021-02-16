package com.bytepace.mvi_demo_app.ui.fragments.images.viewmodel

import com.bytepace.mvi_demo_app.ui.fragments.images.feature.Feature

class ViewModelTransformer : (Feature.State) -> ViewModel {
    override fun invoke(state: Feature.State): ViewModel = ViewModel(state.imageUri, state.isLoading)
}