package com.san.room.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.san.backend.model.Exercise
import com.san.backend.model.ImageURL
import com.san.room.converters.ListConverter

@TypeConverters(ListConverter::class)
@Entity
data class ExerciseInfo(
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "category") val category: String,
    @ColumnInfo(name = "equipment") val equipment: List<String>,
    @ColumnInfo(name = "image_url") var imageURL: String
) {
    companion object {
        @JvmStatic
        fun fromExercise(exercise: Exercise) = ExerciseInfo(
            Integer.parseInt(exercise.id),
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

