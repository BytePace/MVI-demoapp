package com.bytepace.mvi_demo_app.di.components

import com.bytepace.mvi_demo_app.MainActivity
import com.bytepace.mvi_demo_app.di.modules.ImagesScreenModule
import com.bytepace.mvi_demo_app.di.modules.InteractorModule
import com.bytepace.mvi_demo_app.di.modules.NavigationModule
import com.bytepace.mvi_demo_app.di.modules.NetworkingModule
import com.bytepace.mvi_demo_app.di.scope.ActivityScope
import dagger.Component

@ActivityScope
@Component(modules = [ImagesScreenModule::class])
interface AppComponent {
    fun inject(activity: MainActivity)
}
