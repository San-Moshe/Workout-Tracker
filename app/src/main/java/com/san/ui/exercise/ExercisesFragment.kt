package com.san.ui.exercise

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.DividerItemDecoration.VERTICAL
import com.san.R
import com.san.base.BaseFragment
import com.san.room.model.ExerciseInfo
import com.san.ui.base.OnViewHolderClickListener
import com.san.ui.workout.WorkoutViewModel
import kotlinx.android.synthetic.main.exercises_fragment.*

class ExercisesFragment : BaseFragment(),
    OnViewHolderClickListener<ExerciseInfo> {

    private val workoutVM: WorkoutViewModel by lazy {
        getViewModel(WorkoutViewModel::class.java, requireActivity())
    }
    private val exerciseVM: ExerciseViewModel by lazy {
        getViewModel(ExerciseViewModel::class.java)
    }

    private lateinit var exercisesAdapter: ExerciseAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        exercisesAdapter = ExerciseAdapter(requireContext(), this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.exercises_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        rv_all_exercises.apply {
            adapter = exercisesAdapter
            addItemDecoration(DividerItemDecoration(context, VERTICAL))
        }

        exerciseVM.liveDataExercisesInfo.observe(viewLifecycleOwner, Observer {
            it?.let { exerciseList ->
                exercisesAdapter.submitList(exerciseList)
            }
        })
    }

    override fun onItemSelected(item: ExerciseInfo) {
        workoutVM.selectExercise(item)
        findNavController().popBackStack()
    }
}
