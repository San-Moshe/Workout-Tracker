package com.san.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.san.di.DaggerViewModelFactory
import com.san.di.ViewModelKey
import com.san.ui.exercise.ExercisesViewModel
import com.san.ui.workout.PicViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: DaggerViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(PicViewModel::class)
    abstract fun bindPicViewModel(viewModel: PicViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ExercisesViewModel::class)
    abstract fun bindExercisesViewModel(viewModel: ExercisesViewModel): ViewModel
}
