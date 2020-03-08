package com.san.backend.api

import com.san.backend.model.MeiziPic
import com.san.backend.model.wrapper.GankIoResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface PicApi {

    @GET("{count}/{pageNum}")
    fun getMeiziPics(
        @Path("count") count: Int,
        @Path("pageNum") pageNum: Int
    ): Observable<GankIoResponse<MeiziPic>>
}
