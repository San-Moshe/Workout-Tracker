package com.san.ui.workout

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textview.MaterialTextView
import com.san.R
import com.san.room.model.WorkoutExercise
import com.san.ui.base.BaseAdapter
import com.san.ui.base.BaseViewHolder
import com.san.ui.base.ClickableAdapter
import com.san.ui.base.OnViewHolderClickListener

//TODO notify edit when focus change
class WorkoutAdapter(val clickListener: OnViewHolderClickListener<List<WorkoutExercise>>) :
    BaseAdapter<List<WorkoutExercise>, BaseViewHolder<List<WorkoutExercise>>>(
        diffCallback
    ) {

    inner class WorkoutViewHolder(
        view: View,
        adapter: ClickableAdapter<List<WorkoutExercise>>
    ) :
        BaseViewHolder<List<WorkoutExercise>>(view, clickListener, adapter) {
        private val exerciseNameTextView =
            itemView.findViewById<MaterialTextView>(R.id.tv_exercise_title_name)
        private val exerciseRecyclerView =
            itemView.findViewById<RecyclerView>(R.id.rv_exercise_sets)
        private val workoutExerciseAdapter: WorkoutExerciseAdapter = WorkoutExerciseAdapter()

        init {
            //TODO consider adding item decoration
            exerciseRecyclerView.apply {
                this.adapter = workoutExerciseAdapter
            }
        }

        //TODO convert the id to the exercise name somehow
        override fun bind(item: List<WorkoutExercise>) {
            exerciseNameTextView.text = item.first().exerciseId.toString()

            workoutExerciseAdapter.submitList(item)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<List<WorkoutExercise>> {
        return WorkoutViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.exercise_list_item,
                parent, false
            ),
            this
        )
    }

    override fun onBindViewHolder(holder: BaseViewHolder<List<WorkoutExercise>>, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        @JvmStatic
        val diffCallback = object : DiffUtil.ItemCallback<List<WorkoutExercise>>() {
            override fun areItemsTheSame(
                oldItem: List<WorkoutExercise>,
                newItem: List<WorkoutExercise>
            ): Boolean =
                oldItem == newItem


            override fun areContentsTheSame(
                oldItem: List<WorkoutExercise>,
                newItem: List<WorkoutExercise>
            ): Boolean = oldItem == newItem
        }
    }
}