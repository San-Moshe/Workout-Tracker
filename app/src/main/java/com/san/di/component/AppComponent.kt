package com.san.di.component

import com.san.GankApplication
import com.san.backend.di.module.ApiModule
import com.san.di.AppScope
import com.san.di.module.AppModule
import com.san.di.module.FlipperModule
import com.san.di.module.ViewModelModule
import dagger.Component
import javax.inject.Singleton

@AppScope
@Singleton
@Component(
    modules = [
        AppModule::class,
        FlipperModule::class,
        ApiModule::class,
        ViewModelModule::class
    ]
)
interface AppComponent {

    fun inject(app: GankApplication)

    fun newActivityComponentBuilder(): ActivityComponent.Builder

    fun newFragmentComponentBuilder(): FragmentComponent.Builder
}
