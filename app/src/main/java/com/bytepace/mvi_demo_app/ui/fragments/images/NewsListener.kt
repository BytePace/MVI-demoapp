package com.bytepace.mvi_demo_app.ui.fragments.images

import android.content.Context
import android.widget.Toast
import com.bytepace.mvi_demo_app.ui.fragments.images.feature.Feature
import io.reactivex.functions.Consumer

class NewsListener(private val context: Context): Consumer<Feature.News> {
    override fun accept(news: Feature.News?) {
        when (news) {
            is Feature.News.ErrorExecutingRequest -> errorHappened(news.throwable)
        }
    }

    private fun errorHappened(throwable: Throwable) {
        Toast.makeText(context, "Simulated error was triggered", Toast.LENGTH_SHORT).show()
    }
}