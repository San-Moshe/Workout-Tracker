package com.san.ui.exercise

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.san.backend.api.ExerciseApi
import com.san.backend.model.Exercise
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

//TODO reference to room
//TODO get exercises from remote api
class ExerciseRepository @Inject
constructor(
    private val exerciseApi: ExerciseApi
) {
    val liveDataExercises: LiveData<List<Exercise>> = MutableLiveData()

    //TODO fetch exercises images
    fun fetchExercises() {
        liveDataExercises as MutableLiveData
        exerciseApi.getExerciseList()
            .subscribeOn(Schedulers.io()).doOnError {

            }
            .subscribe { response ->
                liveDataExercises.postValue(response.results)
            }
    }
}