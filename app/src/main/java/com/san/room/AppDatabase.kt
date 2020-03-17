package com.san.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.san.room.model.ExerciseInfo
import com.san.room.model.WorkoutExercise

@Database(
    entities = [WorkoutExercise::class, ExerciseInfo::class], version = 1
)
abstract class AppDatabase(
) : RoomDatabase() {

}