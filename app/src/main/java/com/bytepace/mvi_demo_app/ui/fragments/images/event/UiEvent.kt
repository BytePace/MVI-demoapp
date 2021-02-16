package com.bytepace.mvi_demo_app.ui.fragments.images.event

sealed class UiEvent {
    object NextClicked: UiEvent()
    object SaveClicked: UiEvent()
}