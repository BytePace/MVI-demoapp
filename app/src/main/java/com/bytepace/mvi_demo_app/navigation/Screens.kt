package com.bytepace.mvi_demo_app.navigation

import com.bytepace.mvi_demo_app.ui.main.MainFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {
    fun Main() = FragmentScreen { MainFragment() }
}