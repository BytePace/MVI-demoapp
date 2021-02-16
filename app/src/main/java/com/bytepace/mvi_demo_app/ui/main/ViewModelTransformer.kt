package com.bytepace.mvi_demo_app.ui.main

import com.bytepace.mvi_demo_app.mvi.feature.Feature1

class ViewModelTransformer : (Feature1.State) -> ViewModel {
    override fun invoke(state: Feature1.State): ViewModel = ViewModel(state.counter.toString())
}