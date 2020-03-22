package com.san.room.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey

@Entity(
    foreignKeys = [ForeignKey(
        entity = Workout::class,
        parentColumns = ["uid"],
        childColumns = ["workout_id"],
        onDelete = CASCADE
    ), ForeignKey(
        entity = ExerciseInfo::class,
        parentColumns = ["uid"],
        childColumns = ["exercise_id"],
        onDelete = CASCADE
    )]
)
data class WorkoutExercise(
    @PrimaryKey(autoGenerate = true) val uid: Int = 0,
    @ColumnInfo(name = "time_started") val timeStarted: String,
    @ColumnInfo(name = "weight") val weight: Float = 0f,
    @ColumnInfo(name = "set_number") val setNum: Short = 0,
    @ColumnInfo(name = "repetitions") val reps: Short = 0,
    @ColumnInfo(name = "exercise_id") val exerciseId: Int,
    @ColumnInfo(name = "workout_id") val workoutId: Int
)