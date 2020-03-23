package com.san.ui.workout

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.san.R
import com.san.base.BaseFragment
import com.san.room.model.WorkoutExercise
import com.san.ui.base.OnViewHolderClickListener
import kotlinx.android.synthetic.main.workout_fragment.*

class WorkoutFragment : BaseFragment(), OnViewHolderClickListener<List<WorkoutExercise>>,
    ExerciseEditListener {
    private val vm: IWorkoutViewModel by lazy {
        getViewModel(WorkoutViewModel::class.java, requireActivity())
    }

    private lateinit var workoutAdapter: WorkoutAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        workoutAdapter = WorkoutAdapter(this, this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.workout_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_add_exercise.setOnClickListener {
            findNavController().navigate(WorkoutFragmentDirections.actionWorkoutFragmentToExercisesFragment())
        }

        btn_stop_workout.setOnClickListener {
            //TODO dialog are you sure
            //TODO navigate back to homeFragment
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        rv_exercises.apply {
            this.adapter = workoutAdapter
        }

        vm.getCurrentWorkout().observe(viewLifecycleOwner, Observer {
            it?.let { workoutWithExercises ->
                workoutAdapter.submitList(workoutWithExercises.exercises.groupBy { exercise -> exercise.exerciseId }.values.toList())
            }
        })
    }

    override fun onItemSelected(item: List<WorkoutExercise>) {

    }

    override fun onExerciseWeightEdit(exerciseId: Int, weight: Float) {
        vm.editExerciseWeight(exerciseId, weight)
    }

    override fun onExerciseRepsEdit(exerciseId: Int, reps: Short) {
        vm.editExerciseReps(exerciseId, reps)
    }
}
