package com.san.ui.exercise

import androidx.lifecycle.LiveData
import com.san.base.BaseViewModel

//TODO inject repository
class ExercisesViewModel : BaseViewModel() {
    val liveDataExercises by lazy {
        fetchExerciseList()
    }

    private fun fetchExerciseList(): LiveData<List<Exercise>> {
        //TODO get livedata list from repo
    }
}
