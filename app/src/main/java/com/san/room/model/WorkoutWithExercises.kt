package com.san.room.model

import androidx.room.Embedded
import androidx.room.Relation
import com.san.backend.model.Exercise

data class WorkoutWithExercises(
    @Embedded
    val workout: Workout,
    @Relation(
        parentColumn = "uid",
        entityColumn = "workout_id",
        entity = Exercise::class
    )
    val exercises: MutableList<WorkoutExercise> = mutableListOf()
)