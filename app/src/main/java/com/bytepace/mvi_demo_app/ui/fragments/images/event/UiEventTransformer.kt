package com.bytepace.mvi_demo_app.ui.fragments.images.event

import com.bytepace.mvi_demo_app.ui.fragments.images.feature.Feature

class UiEventTransformer : (UiEvent) -> Feature.Wish {
    override fun invoke(event: UiEvent): Feature.Wish = when (event) {
        is UiEvent.NextClicked -> Feature.Wish.LoadNewImage
        is UiEvent.SaveClicked -> Feature.Wish.LoadNewImage
    }
}