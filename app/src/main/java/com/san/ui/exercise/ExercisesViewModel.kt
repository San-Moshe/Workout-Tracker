package com.san.ui.exercise

import androidx.lifecycle.LiveData
import com.san.backend.model.Exercise
import com.san.base.BaseViewModel
import javax.inject.Inject

//TODO inject repository
class ExercisesViewModel @Inject constructor(private val exerciseRepository: ExerciseRepository) :
    BaseViewModel() {
    val liveDataExercises by lazy {
        fetchExerciseList()
    }

    private fun fetchExerciseList(): LiveData<List<Exercise>> {
        exerciseRepository.fetchExercises()
        return exerciseRepository.liveDataExercises
    }
}
