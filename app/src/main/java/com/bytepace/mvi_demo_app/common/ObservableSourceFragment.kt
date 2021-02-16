package com.bytepace.mvi_demo_app.common

import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import io.reactivex.ObservableSource
import io.reactivex.Observer
import io.reactivex.subjects.PublishSubject

abstract class ObservableSourceFragment<T>(@LayoutRes layoutId: Int) : Fragment(layoutId), ObservableSource<T> {
    private val source = PublishSubject.create<T>()

    protected fun onNext(t: T) {
        source.onNext(t)
    }

    override fun subscribe(observer: Observer<in T>) {
        source.subscribe(observer)
    }
}