package com.bytepace.mvi_demo_app.ui.fragments.images

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import com.bumptech.glide.Glide
import com.bytepace.mvi_demo_app.MainActivity
import com.bytepace.mvi_demo_app.R
import com.bytepace.mvi_demo_app.common.ObservableSourceFragment
import com.bytepace.mvi_demo_app.di.ImagesScreenInjector
import com.bytepace.mvi_demo_app.ui.fragments.images.event.UiEvent
import com.bytepace.mvi_demo_app.ui.fragments.images.viewmodel.ViewModel
import io.reactivex.functions.Consumer
import kotlinx.android.synthetic.main.images_fragment.*
import javax.inject.Inject

class ImagesFragment : ObservableSourceFragment<UiEvent>(R.layout.images_fragment), Consumer<ViewModel> {
    @Inject
    lateinit var bindings: ImagesFragmentBindings

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ImagesScreenInjector.get(this).inject(this)
        bindings.setup(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindClickListeners()
    }

    override fun accept(viewModel: ViewModel?) {
        viewModel ?: return
        progress_bar?.isVisible = viewModel.imageIsLoading
        viewModel.imageUri?.let {
            loadImage(it)
        }
    }

    private fun bindClickListeners() {
        next_image.setOnClickListener {
            onNext(UiEvent.NextClicked)
        }

        save_image.setOnClickListener {
            onNext(UiEvent.SaveClicked)
        }
    }

    private fun loadImage(uri: String) {
        Glide.with(this)
            .load(uri)
            .centerCrop()
            .into(image)
    }
}