package com.san.ui.workout

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import com.san.R
import com.san.base.BaseFragment
import com.san.ui.exercise.WorkoutViewModel
import kotlinx.android.synthetic.main.fragment_pic.*

class PicFragment : BaseFragment() {
    private val vm: WorkoutViewModel by navGraphViewModels(R.id.workout_graph)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_pic, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_add_exercise.setOnClickListener {
            findNavController().navigate(PicFragmentDirections.actionPicToExercisesFragment())
        }

        btn_stop_workout.setOnClickListener {
            //TODO navigate back to homeFragment
        }
    }
}
