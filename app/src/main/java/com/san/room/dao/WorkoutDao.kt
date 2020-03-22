package com.san.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.san.room.model.WorkoutExercise

@Dao
interface WorkoutDao {
    @Query("SELECT * FROM WorkoutExercise WHERE workout_id == :id ORDER BY time_started ASC")
    fun getWorkoutInfo(id: String): LiveData<List<WorkoutExercise>>
}
