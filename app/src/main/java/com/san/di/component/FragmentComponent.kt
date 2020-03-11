package com.san.di.component

import androidx.fragment.app.Fragment
import com.san.di.FragmentScope
import com.san.di.module.FragmentModule
import com.san.ui.exercise.ExercisesFragment
import com.san.ui.home.HomeFragment
import com.san.ui.workout.PicFragment
import dagger.Subcomponent

@FragmentScope
@Subcomponent(
    modules = [
        FragmentModule::class
    ]
)
interface FragmentComponent {

    @Subcomponent.Builder
    interface Builder {
        fun fragmentModule(module: FragmentModule): Builder
        fun build(): FragmentComponent
    }

    fun inject(fragment: HomeFragment)
    fun inject(fragment: PicFragment)
    fun inject(fragment: ExercisesFragment)
}

fun FragmentComponent.Builder.buildAndInject(fragment: Fragment) {
    val component = fragmentModule(FragmentModule(fragment)).build()

    when (fragment) {
        is HomeFragment -> component.inject(fragment)
        is PicFragment -> component.inject(fragment)
        is ExercisesFragment -> component.inject(fragment)
    }
}
