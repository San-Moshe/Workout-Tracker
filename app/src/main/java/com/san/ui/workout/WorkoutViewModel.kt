package com.san.ui.workout

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.san.base.BaseViewModel
import com.san.room.model.ExerciseInfo
import com.san.room.model.Workout
import com.san.room.model.WorkoutExercise
import com.san.room.model.WorkoutWithExercises
import org.threeten.bp.LocalDate
import org.threeten.bp.LocalTime
import javax.inject.Inject

interface IWorkoutViewModel {
    fun getWorkoutExercises(): LiveData<List<WorkoutExercise>>
    fun getCurrentWorkout(): LiveData<WorkoutWithExercises>
    fun editExerciseWeight(uid: Int, weight: Float)
    fun editExerciseReps(uid: Int, reps: Short)

    fun saveWorkout()
}

//TODO rename
interface IWorkoutWriteOnlyViewModel {
    fun startNewWorkout()
    fun selectExercise(exercise: ExerciseInfo)
}

class WorkoutViewModel @Inject constructor(private val workoutRepository: IWorkoutRepository) :
    BaseViewModel(), IWorkoutViewModel, IWorkoutWriteOnlyViewModel {
    private var selectedWorkout = MutableLiveData<WorkoutWithExercises>()

    override fun getWorkoutExercises(): LiveData<List<WorkoutExercise>> =
        Transformations.switchMap(selectedWorkout) { workout ->
            workoutRepository.getWorkoutDetails(workout.workout.uid)
        }

    override fun getCurrentWorkout(): LiveData<WorkoutWithExercises> = selectedWorkout

    override fun editExerciseWeight(uid: Int, weight: Float) {
        getCurrentWorkout().value?.exercises?.find {
            it.uid == uid
        }?.weight = weight
    }

    override fun editExerciseReps(uid: Int, reps: Short) {
        getCurrentWorkout().value?.exercises?.find {
            it.uid == uid
        }?.reps = reps
    }

    override fun saveWorkout() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun startNewWorkout() {
        selectedWorkout.value =
            WorkoutWithExercises(Workout(0, LocalDate.now().toString(), LocalTime.now().toString()))
    }

    override fun selectExercise(exercise: ExerciseInfo) {
        (selectedWorkout.value as WorkoutWithExercises).apply {
            exercises.add(
                WorkoutExercise(
                    timeStarted = LocalTime.now().toString(),
                    exerciseId = exercise.uid,
                    exerciseName = exercise.name,
                    workoutId = workout.uid
                )
            )
        }
    }
}