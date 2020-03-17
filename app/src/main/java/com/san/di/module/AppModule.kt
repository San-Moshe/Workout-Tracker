package com.san.di.module

import android.app.Application
import androidx.room.Room
import com.san.di.AppScope
import com.san.di.component.ActivityComponent
import com.san.di.component.FragmentComponent
import com.san.room.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

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

    @Singleton
    @Provides
    fun provideDb(): AppDatabase =
        Room.databaseBuilder(app, AppDatabase::class.java, "com.san.workout_tracker.db").build()
}
