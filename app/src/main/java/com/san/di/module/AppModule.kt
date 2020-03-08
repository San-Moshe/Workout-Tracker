package com.san.di.module

import android.app.Application
import com.san.di.AppScope
import com.san.di.component.ActivityComponent
import com.san.di.component.FragmentComponent
import dagger.Module
import dagger.Provides

@Module(
    subcomponents = [
        ActivityComponent::class,
        FragmentComponent::class
    ]
)
class AppModule(private val app: Application) {

    @Provides
    @AppScope
    fun provideApp(): Application = app
}
