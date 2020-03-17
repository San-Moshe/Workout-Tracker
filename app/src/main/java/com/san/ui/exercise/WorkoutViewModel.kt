package com.san.ui.exercise

import androidx.lifecycle.LiveData
import com.san.base.BaseViewModel
import com.san.room.model.ExerciseInfo
import com.san.room.model.WorkoutExercise
import com.san.ui.workout.IWorkoutRepository
import javax.inject.Inject

//TODO add abstraction layer for view model
class WorkoutViewModel @Inject constructor(
    private val exerciseRepository: IExerciseRepository,
    private val workoutRepository: IWorkoutRepository
) :
    BaseViewModel() {
    val liveDataExercisesInfo by lazy {
        fetchExerciseList()
    }

    val liveDataWorkoutExercises by lazy {
        //fetchWorkoutExercises()
    }

    /*private fun fetchWorkoutExercises(): LiveData<List<WorkoutExercise>> {

    }*/

    private fun fetchExerciseList(): LiveData<List<ExerciseInfo>> {
        exerciseRepository.fetchExercises()
        return exerciseRepository.getExercises()
    }

    fun selectExercise(item: ExerciseInfo) {
        //workoutRepository.addWorkoutExercise()
    }
}
