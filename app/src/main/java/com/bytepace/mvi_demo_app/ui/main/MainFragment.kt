package com.bytepace.mvi_demo_app.ui.main

import android.os.Bundle
import android.view.View
import com.badoo.binder.Binder
import com.badoo.binder.named
import com.badoo.binder.using
import com.badoo.mvicore.android.lifecycle.CreateDestroyBinderLifecycle
import com.bytepace.mvi_demo_app.MainActivity
import com.bytepace.mvi_demo_app.R
import com.bytepace.mvi_demo_app.base.ObservableSourceFragment
import com.bytepace.mvi_demo_app.mvi.event.UiEvent
import com.bytepace.mvi_demo_app.mvi.event.UiEventTransformer
import com.bytepace.mvi_demo_app.mvi.feature.Feature1
import io.reactivex.functions.Consumer
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : ObservableSourceFragment<UiEvent>(R.layout.main_fragment), Consumer<ViewModel> {
    private val feature = Feature1()

    override fun onCreate(savedInstanceState: Bundle?) {
        (requireActivity() as MainActivity).app.appComponent.inject(this)
        super.onCreate(savedInstanceState)

        val binder = Binder(CreateDestroyBinderLifecycle(lifecycle))
        binder.bind(feature to this using ViewModelTransformer() named "MainFragment.ViewModels")
        binder.bind(this to feature using UiEventTransformer())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        message.setOnClickListener {
            onNext(UiEvent.CounterClicked)
        }
    }

    override fun accept(vm: ViewModel?) {
        message?.text = vm?.counter
    }
}