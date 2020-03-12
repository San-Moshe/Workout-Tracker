package com.san.ui.exercise

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.san.R
import com.san.base.BaseFragment
import kotlinx.android.synthetic.main.exercises_fragment.*

//TODO add click listener for adapter
//TODO design the xml file
class ExercisesFragment : BaseFragment() {
    private val vm by lazy {
        getViewModel(ExercisesViewModel::class.java)
    }

    private var exercisesAdapter: ExerciseAdapter = ExerciseAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.exercises_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        rv_all_exercises.adapter = exercisesAdapter

        vm.liveDataExercises.observe(viewLifecycleOwner, Observer {
            it?.let { exerciseList ->
                exercisesAdapter.submitList(exerciseList)
            }
        })
    }
}
