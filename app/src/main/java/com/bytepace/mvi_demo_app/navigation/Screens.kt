package com.bytepace.mvi_demo_app.navigation

import com.bytepace.mvi_demo_app.ui.fragments.images.ImagesFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {
    fun firstScreen() = Images()

    fun Images() = FragmentScreen { ImagesFragment() }
}