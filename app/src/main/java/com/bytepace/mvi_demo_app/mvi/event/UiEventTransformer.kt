package com.bytepace.mvi_demo_app.mvi.event

import com.bytepace.mvi_demo_app.mvi.feature.Feature1

class UiEventTransformer : (UiEvent) -> Feature1.Wish {
    override fun invoke(event: UiEvent): Feature1.Wish = when (event) {
        is UiEvent.CounterClicked -> Feature1.Wish.IncrementCounter
    }
}