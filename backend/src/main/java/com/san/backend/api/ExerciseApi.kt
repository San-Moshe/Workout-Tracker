package com.san.backend.api

import com.san.backend.model.Exercise
import com.san.backend.model.wrapper.GankIoResponse
import io.reactivex.Observable
import retrofit2.http.GET

interface ExerciseApi {

    //TODO add query parameter page
    @GET("exercise/?page=1&language=2&status=2")
    fun getExerciseList(
        //@Query("pageNum") pageNum: Int
    ): Observable<GankIoResponse<Exercise>>
}
