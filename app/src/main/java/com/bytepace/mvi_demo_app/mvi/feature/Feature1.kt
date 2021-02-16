package com.bytepace.mvi_demo_app.mvi.feature

import android.util.Log
import com.badoo.mvicore.element.Reducer
import com.badoo.mvicore.feature.ReducerFeature

class Feature1 : ReducerFeature<Feature1.Wish, Feature1.State, Nothing>(
    initialState = State(),
    reducer = ReducerImpl()
) {

    data class State(
        val counter: Int = 0
    )

    sealed class Wish {
        object IncrementCounter : Wish()
    }

    class ReducerImpl : Reducer<State, Wish> {
        override fun invoke(state: State, wish: Wish): State = when (wish) {
            Wish.IncrementCounter -> {
                Log.d("###REDUCER_INCR_COUNTER", state.counter.toString())
                state.copy(
                    counter = state.counter + 1
                )
            }
        }
    }
}