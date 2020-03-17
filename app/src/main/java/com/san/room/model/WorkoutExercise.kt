package com.san.room.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//TODO Room
@Entity
data class WorkoutExercise(
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "weight") val weight: Float = 0f,
    @ColumnInfo(name = "set_number") val setNum: Short = 0,
    @ColumnInfo(name = "repetitions") val reps: Short = 0
)