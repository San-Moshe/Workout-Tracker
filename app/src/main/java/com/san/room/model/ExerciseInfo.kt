package com.san.room.model

import com.san.backend.model.Exercise
import com.san.backend.model.ImageURL

data class ExerciseInfo(
    val id: String,
    val description: String,
    val name: String,
    val category: String,
    val equipment: List<String>,
    var imageURL: String
) {
    companion object {
        @JvmStatic
        fun fromExercise(exercise: Exercise) = ExerciseInfo(
            exercise.id,
            exercise.description,
            exercise.name,
            exercise.category,
            exercise.equipment,
            ""
        )

        fun fromExerciseAndImage(exercise: Exercise, imageURL: ImageURL) =
            fromExercise(exercise).apply {
                this.imageURL = imageURL.imageURL
            }
    }

}

