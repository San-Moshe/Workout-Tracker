package com.san.ui.workout

import com.san.room.dao.WorkoutDao
import com.san.room.model.WorkoutExercise

interface IWorkoutRepository {
    fun addWorkoutExercise(exercise: WorkoutExercise)
    fun deleteWorkoutExercise(exercise: WorkoutExercise)
    fun editWorkoutExercise(exercise: WorkoutExercise)
}

//TODO reference room dao
//TODO fetch data from remote server
class WorkoutRepository(private val workoutDao: WorkoutDao) : IWorkoutRepository {
    override fun addWorkoutExercise(exercise: WorkoutExercise) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteWorkoutExercise(exercise: WorkoutExercise) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun editWorkoutExercise(exercise: WorkoutExercise) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}