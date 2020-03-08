package com.san.di.module

import androidx.fragment.app.Fragment
import com.san.di.FragmentScope
import dagger.Module
import dagger.Provides

@Module
class FragmentModule(private val fragment: Fragment) {

    @Provides
    @FragmentScope
    fun provideFragment(): Fragment = fragment
}
