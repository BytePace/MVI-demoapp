package com.bytepace.mvi_demo_app.mvi.event

sealed class UiEvent {
    object CounterClicked: UiEvent()
}