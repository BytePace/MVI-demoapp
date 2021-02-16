package com.bytepace.mvi_demo_app.ui.fragments.images.feature

import android.os.Parcelable
import com.badoo.mvicore.element.*
import com.badoo.mvicore.feature.ActorReducerFeature
import com.bytepace.mvi_demo_app.interactor.DownloadRandomImageInteractor
import com.bytepace.mvi_demo_app.model.Image
import io.reactivex.Observable
import io.reactivex.Observable.just
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.parcel.Parcelize

class Feature(
    timeCapsule: TimeCapsule<Parcelable>? = null,
    downloadRandomImageInteractor: DownloadRandomImageInteractor
) : ActorReducerFeature<Feature.Wish, Feature.Effect, Feature.State, Feature.News>(
    initialState = timeCapsule?.get(Feature::class.java) ?: State(),
    bootstrapper = BootstrapperImpl(),
    actor = ActorImpl(downloadRandomImageInteractor),
    reducer = ReducerImpl(),
    newsPublisher = NewsPublisherImpl()
) {
    init {
        timeCapsule?.register(Feature::class.java) {
            state.copy(
                isLoading = false
            )
        }
    }

    @Parcelize
    data class State(
        val isLoading: Boolean = false,
        val imageUri: String? = null
    ) : Parcelable

    sealed class Wish {
        object LoadNewImage : Wish()
    }

    sealed class Effect {
        object StartedLoading : Effect()
        data class LoadedImage(val uri: String) : Effect()
        data class ErrorLoading(val throwable: Throwable) : Effect()
    }

    sealed class News {
        data class ErrorExecutingRequest(val throwable: Throwable) : News()
    }

    private class BootstrapperImpl : Bootstrapper<Wish> {
        override fun invoke(): Observable<Wish> = just(Wish.LoadNewImage)
    }

    private class ActorImpl(private val downloadRandomImageInteractor: DownloadRandomImageInteractor) :
        Actor<State, Wish, Effect> {
        override fun invoke(state: State, wish: Wish): Observable<Effect> = when (wish) {
            is Wish.LoadNewImage -> loadRandomImage()
                .map { Effect.LoadedImage(it.uri) as Effect }
                .startWith(just(Effect.StartedLoading))
                .onErrorReturn { Effect.ErrorLoading(it) }
        }

        private fun loadRandomImage(): Observable<Image> {
            return downloadRandomImageInteractor.getRandomImage().observeOn(AndroidSchedulers.mainThread())
        }
    }

    class ReducerImpl : Reducer<State, Effect> {
        override fun invoke(state: State, effect: Effect): State = when (effect) {
            Effect.StartedLoading -> state.copy(
                isLoading = true
            )
            is Effect.LoadedImage -> state.copy(
                isLoading = false,
                imageUri = effect.uri
            )
            is Effect.ErrorLoading -> state.copy(
                isLoading = false
            )
        }
    }

    class NewsPublisherImpl : NewsPublisher<Wish, Effect, State, News> {
        override fun invoke(wish: Wish, effect: Effect, state: State): News? = when (effect) {
            is Effect.ErrorLoading -> {
                News.ErrorExecutingRequest(effect.throwable)
            }
            else -> null
        }
    }
}