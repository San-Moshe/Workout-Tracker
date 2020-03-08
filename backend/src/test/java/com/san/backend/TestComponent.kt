package com.san.backend

import com.san.backend.di.module.ApiModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ApiModule::class
    ]
)
interface TestComponent {
    fun inject(app: ApisTest)
}
