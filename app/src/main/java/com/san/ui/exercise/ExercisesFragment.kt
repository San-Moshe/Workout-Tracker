package com.san.ui.exercise

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.san.R
import com.san.base.BaseFragment

//TODO adapter for recyclerview
//TODO design the xml file
class ExercisesFragment : BaseFragment() {
    private val vm by lazy {
        getViewModel(ExercisesViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.exercises_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        vm.liveDataExercises.observe(viewLifecycleOwner, Observer {
            Log.i("break", "break")
        })
    }
}
