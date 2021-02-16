package com.bytepace.mvi_demo_app.ui.fragments.images

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import com.badoo.binder.Binder
import com.badoo.binder.using
import com.badoo.mvicore.android.lifecycle.CreateDestroyBinderLifecycle
import com.bumptech.glide.Glide
import com.bytepace.mvi_demo_app.MainActivity
import com.bytepace.mvi_demo_app.R
import com.bytepace.mvi_demo_app.common.ObservableSourceFragment
import com.bytepace.mvi_demo_app.ui.fragments.images.event.UiEvent
import com.bytepace.mvi_demo_app.ui.fragments.images.event.UiEventTransformer
import com.bytepace.mvi_demo_app.ui.fragments.images.feature.Feature
import com.bytepace.mvi_demo_app.ui.fragments.images.viewmodel.ViewModel
import com.bytepace.mvi_demo_app.ui.fragments.images.viewmodel.ViewModelTransformer
import io.reactivex.functions.Consumer
import kotlinx.android.synthetic.main.images_fragment.*

class ImagesFragment: ObservableSourceFragment<UiEvent>(R.layout.images_fragment), Consumer<ViewModel> {
    private val feature = Feature()

    override fun onCreate(savedInstanceState: Bundle?) {
        (requireActivity() as MainActivity).app.appComponent.inject(this)
        super.onCreate(savedInstanceState)
        bindConnections()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindClicks()
    }

    private fun bindConnections() {
        val binder = Binder(CreateDestroyBinderLifecycle(lifecycle))

        binder.bind(feature to this using ViewModelTransformer())
        binder.bind(this to feature using UiEventTransformer())
        binder.bind(feature.news to NewsListener(requireContext()))
    }

    private fun bindClicks() {
        next_image.setOnClickListener {
            onNext(UiEvent.NextClicked)
        }

        save_image.setOnClickListener {
            onNext(UiEvent.SaveClicked)
        }
    }

    override fun accept(vm: ViewModel?) {
        vm ?: return
        progress_bar?.isVisible = vm.imageIsLoading
        vm.imageUri?.let {
            loadImage(it)
        }
    }

    private fun loadImage(uri: String) {
        Glide.with(this)
            .load(uri)
            .centerCrop()
            .into(image)
    }
}