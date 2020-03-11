package com.san.ui.workout

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.san.backend.api.ExerciseApi
import com.san.backend.model.Exercise
import com.san.base.BaseViewModel
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PicViewModel @Inject constructor(
    private val exerciseApi: ExerciseApi
) : BaseViewModel() {
    val liveData: LiveData<List<Exercise>> = MutableLiveData()

    init {
        fetchOnePic()
    }

    fun fetchOnePic() {
        /*liveData as MutableLiveData
        exerciseApi.getExerciseList(1, (1..10).random())
            .subscribeOn(Schedulers.io()).doOnError {

            }
            .autoDisposable()
            .subscribe { response ->
                liveData.postValue(response.results)
            }*/
    }
}
