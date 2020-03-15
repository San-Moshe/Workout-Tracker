package com.san.ui.exercise

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.san.R
import com.san.room.model.ExerciseInfo
import kotlinx.android.synthetic.main.exercise_details_list_item.view.*

class ExerciseAdapter(val context: Context) :
    ListAdapter<ExerciseInfo, ExerciseAdapter.ExerciseViewHolder>(diffCallback) {
    inner class ExerciseViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image = view.img_exercise_detail_image
        val name = view.tv_exercise_detail_name
        val equipment = view.tv_exercise_detail_equipment

        fun bind(exercise: ExerciseInfo) {
            name.text = exercise.name
            equipment.text = exercise.equipment.toString()
            CircularProgressDrawable(context).apply {
                strokeWidth = 5f
                centerRadius = 30f
                backgroundColor = Color.BLACK
                start()
            }.let {
                Glide.with(image).load(exercise.imageURL).centerInside()
                    .placeholder(it)
                    .into(image)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExerciseViewHolder {
        return ExerciseViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.exercise_details_list_item,
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ExerciseViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        @JvmStatic
        val diffCallback = object : DiffUtil.ItemCallback<ExerciseInfo>() {
            override fun areItemsTheSame(oldItem: ExerciseInfo, newItem: ExerciseInfo): Boolean =
                oldItem.id == newItem.id


            override fun areContentsTheSame(oldItem: ExerciseInfo, newItem: ExerciseInfo): Boolean =
                (oldItem.name == newItem.name && oldItem.description == newItem.description && oldItem.equipment == newItem.equipment)

        }
    }
}