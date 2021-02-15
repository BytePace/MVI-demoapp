package com.bytepace.mvi_demo_app.navigation

import androidx.annotation.IdRes
import androidx.fragment.app.FragmentActivity
import com.github.terrakok.cicerone.androidx.AppNavigator

class Navigator(activity: FragmentActivity, @IdRes containerId: Int): AppNavigator(activity, containerId) {

}