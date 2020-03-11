package com.san.backend

import com.san.backend.api.ExerciseApi
import com.san.backend.di.module.ApiModule
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.junit.Ignore
import org.junit.Test
import javax.inject.Inject

class ApisTest {
    init {
        val httpClientBuilder = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor(
                logger = object : HttpLoggingInterceptor.Logger {
                    override fun log(message: String) {
                        println(message)
                    }
                }
            ).apply {
                level = HttpLoggingInterceptor.Level.BODY
            })

        DaggerTestComponent.builder()
            .apiModule(ApiModule(httpClientBuilder, GsonBuilder()))
            .build()
            .inject(this)
    }

    @Inject
    lateinit var exerciseApi: ExerciseApi

    @Test
    @Ignore("Please run this method manually.")
    fun getMeiziPics() {
        exerciseApi.getExerciseList(10, 0)
            .test()
            .assertNoErrors()
            .assertValue { response ->
                !response.error && response.results.size == 10
            }
    }
}
