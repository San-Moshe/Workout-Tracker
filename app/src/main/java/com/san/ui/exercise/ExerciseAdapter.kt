package com.san.ui.exercise

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.san.R
import com.san.backend.model.Exercise
import kotlinx.android.synthetic.main.exercise_details_list_item.view.*

class ExerciseAdapter :
    ListAdapter<Exercise, ExerciseAdapter.ExerciseViewHolder>(diffCallback) {
    inner class ExerciseViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image = view.img_exercise_detail_image
        val name = view.tv_exercise_detail_name
        val equipment = view.tv_exercise_detail_equipment


        //TODO bind the exercise image
        fun bind(exercise: Exercise) {
            name.text = exercise.name
            equipment.text = exercise.equipment
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExerciseViewHolder {
        return ExerciseViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.exercise_details_list_item,
                parent
            )
        )
    }

    override fun onBindViewHolder(holder: ExerciseViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        @JvmStatic
        var diffCallback = object : DiffUtil.ItemCallback<Exercise>() {
            override fun areItemsTheSame(oldItem: Exercise, newItem: Exercise): Boolean =
                oldItem.id == newItem.id


            override fun areContentsTheSame(oldItem: Exercise, newItem: Exercise): Boolean =
                (oldItem.name == newItem.name && oldItem.description == newItem.description && oldItem.equipment == newItem.description)

        }
    }
}