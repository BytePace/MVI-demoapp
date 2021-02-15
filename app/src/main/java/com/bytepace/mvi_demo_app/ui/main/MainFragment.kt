package com.bytepace.mvi_demo_app.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.bytepace.mvi_demo_app.MainActivity
import com.bytepace.mvi_demo_app.R

class MainFragment : Fragment(R.layout.main_fragment) {
    override fun onCreate(savedInstanceState: Bundle?) {
        (requireActivity() as MainActivity).app.appComponent.inject(this)
        super.onCreate(savedInstanceState)
    }
}