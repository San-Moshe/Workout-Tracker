package com.san.ui.workout

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textview.MaterialTextView
import com.san.R
import com.san.room.model.WorkoutExercise

class WorkoutExerciseAdapter :
    ListAdapter<WorkoutExercise, WorkoutExerciseAdapter.WEViewHolder>(diffCallback) {
    inner class WEViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val setNumTextView = itemView.findViewById<MaterialTextView>(R.id.tv_set_number)
        private val setWeightEditText = itemView.findViewById<TextInputEditText>(R.id.et_set_weight)
        private val setRepsEditText = itemView.findViewById<TextInputEditText>(R.id.et_set_reps)

        fun bind(workoutExercise: WorkoutExercise) {
            setNumTextView.text = workoutExercise.setNum.toString()
            setWeightEditText.setText(workoutExercise.weight.toString())
            setRepsEditText.setText(workoutExercise.reps.toString())
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WEViewHolder =
        WEViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.set_list_item,
                parent,
                false
            )
        )


    override fun onBindViewHolder(holder: WEViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        @JvmStatic
        val diffCallback = object : DiffUtil.ItemCallback<WorkoutExercise>() {
            override fun areItemsTheSame(
                oldItem: WorkoutExercise,
                newItem: WorkoutExercise
            ): Boolean =
                oldItem == newItem


            override fun areContentsTheSame(
                oldItem: WorkoutExercise,
                newItem: WorkoutExercise
            ): Boolean =
                (oldItem.timeStarted == newItem.timeStarted && oldItem.setNum == newItem.reps && oldItem.reps == newItem.reps && oldItem.weight == newItem.weight)
        }
    }
}