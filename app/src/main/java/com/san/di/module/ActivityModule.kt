package com.san.di.module

import android.app.Activity
import com.san.di.ActivityScope
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private val activity: Activity) {

    @Provides
    @ActivityScope
    fun provideActivity(): Activity = activity
}
