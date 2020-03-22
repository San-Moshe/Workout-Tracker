package com.san.ui.workout

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.san.room.dao.WorkoutDao
import com.san.room.model.Workout
import com.san.room.model.WorkoutExercise

interface IWorkoutRepository {
    fun addWorkoutExercise(exercise: WorkoutExercise)
    fun deleteWorkoutExercise(exercise: WorkoutExercise)
    fun editWorkoutExercise(exercise: WorkoutExercise)
    fun getWorkoutDetails(workoutId: Int): LiveData<List<WorkoutExercise>>
    fun addNewWorkout(workout: Workout)
}

//TODO reference room dao
//TODO fetch data from remote server
class WorkoutRepository() : IWorkoutRepository {
    override fun addWorkoutExercise(exercise: WorkoutExercise) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteWorkoutExercise(exercise: WorkoutExercise) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun editWorkoutExercise(exercise: WorkoutExercise) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getWorkoutDetails(workoutId: Int): LiveData<List<WorkoutExercise>> =
        MutableLiveData()

    override fun addNewWorkout(workout: Workout) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}