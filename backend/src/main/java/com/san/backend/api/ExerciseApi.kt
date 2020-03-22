package com.san.backend.api

import com.san.backend.model.Exercise
import com.san.backend.model.ImageURL
import com.san.backend.model.wrapper.GankIoResponse
import io.reactivex.Observable
import retrofit2.http.GET

interface ExerciseApi {

    //TODO add query parameter page
    @GET("exercise/?limit=1000&language=2&status=2")
    fun getExerciseList(
        //@Query("pageNum") pageNum: Int
    ): Observable<GankIoResponse<Exercise>>

    @GET("exerciseimage/?limit=1000&status=2")
    fun getExercisesImages(): Observable<GankIoResponse<ImageURL>>
}
