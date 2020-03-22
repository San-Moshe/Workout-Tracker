package com.san.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.san.R
import com.san.base.BaseFragment
import com.san.ui.workout.IWorkoutWriteOnlyViewModel
import com.san.ui.workout.WorkoutViewModel
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : BaseFragment() {
    private val vm: IWorkoutWriteOnlyViewModel by lazy {
        getViewModel(WorkoutViewModel::class.java, requireActivity())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_start_workout.text = getString(R.string.start_workout)
        btn_start_workout.setOnClickListener {
            vm.startNewWorkout()
            findNavController().navigate(HomeFragmentDirections.actionHomeToWorkoutGraph())
        }
    }
}
