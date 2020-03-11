package com.san.backend.api

import com.san.backend.model.ExerciseList
import com.san.backend.model.wrapper.GankIoResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface ExerciseApi {

    @GET("?language=2&page={pageNum}&&status=2")
    fun getExerciseList(
        @Path("pageNum") pageNum: Int
    ): Observable<GankIoResponse<ExerciseList>>
}
