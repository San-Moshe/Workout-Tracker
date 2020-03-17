package com.san.ui.exercise

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.san.backend.api.ExerciseApi
import com.san.backend.model.Exercise
import com.san.backend.model.ImageURL
import com.san.backend.model.wrapper.GankIoResponse
import com.san.room.model.ExerciseInfo
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

interface IExerciseRepository {
    fun getExercises(): LiveData<List<ExerciseInfo>>
    fun fetchExercises()
}

//TODO reference to room
//TODO read about the repository pattern, should it hold the data in memory? or should the view
//TODO model do it, how does it work with room and remote api
class ExerciseRepository @Inject
constructor(
    private val exerciseApi: ExerciseApi
) : IExerciseRepository {
    private val liveDataExercises: LiveData<List<ExerciseInfo>> = MutableLiveData()

    override fun getExercises() = liveDataExercises
    @SuppressLint("CheckResult")
    override fun fetchExercises() {
        val requests = ArrayList<Observable<*>>().apply {
            add(exerciseApi.getExerciseList())
            add(exerciseApi.getExercisesImages())
        }
        liveDataExercises as MutableLiveData

        Observable.zip(requests) { apiResults ->
            (apiResults[1] as GankIoResponse<ImageURL>).results.associateBy { it.exercise }
                .let { imageMap ->
                    (apiResults[0] as GankIoResponse<Exercise>).results.map { exercise ->
                        imageMap[exercise.id]?.let { imageUrl ->
                            ExerciseInfo.fromExerciseAndImage(exercise, imageUrl)
                        } ?: ExerciseInfo.fromExercise(exercise)
                    }
                }
        }.subscribeOn(Schedulers.io()).subscribe {
            liveDataExercises.postValue(it)
        }
    }
}