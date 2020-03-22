package com.san.di.module

import com.san.backend.api.ExerciseApi
import com.san.ui.exercise.ExerciseRepository
import com.san.ui.exercise.IExerciseRepository
import com.san.ui.workout.IWorkoutRepository
import com.san.ui.workout.IWorkoutViewModel
import com.san.ui.workout.WorkoutRepository
import com.san.ui.workout.WorkoutViewModel
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideIExerciseRepository(exerciseApi: ExerciseApi): IExerciseRepository =
        ExerciseRepository(exerciseApi)

    @Provides
    fun provideIWorkoutRepository(): IWorkoutRepository =
        WorkoutRepository()
}