package com.san.di.component

import android.app.Activity
import com.san.di.ActivityScope
import com.san.di.module.ActivityModule
import com.san.ui.MainActivity
import dagger.Subcomponent

@ActivityScope
@Subcomponent(
    modules = [
        ActivityModule::class
    ]
)
interface ActivityComponent {

    @Subcomponent.Builder
    interface Builder {
        fun activityModule(module: ActivityModule): Builder
        fun build(): ActivityComponent
    }

    fun inject(activity: MainActivity)
}

fun ActivityComponent.Builder.buildAndInject(activity: Activity) {
    val component = activityModule(ActivityModule(activity)).build()

    when (activity) {
        is MainActivity -> component.inject(activity)
    }
}
