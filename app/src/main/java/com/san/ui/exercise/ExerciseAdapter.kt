package com.san.ui.exercise

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.san.R
import com.san.room.model.ExerciseInfo
import com.san.ui.base.BaseAdapter
import com.san.ui.base.BaseViewHolder
import com.san.ui.base.ClickableAdapter
import com.san.ui.base.OnViewHolderClickListener
import kotlinx.android.synthetic.main.exercise_details_list_item.view.*

class ExerciseAdapter(
    val context: Context,
    val onViewHolderClickListener: OnViewHolderClickListener<ExerciseInfo>
) :
    BaseAdapter<ExerciseInfo, BaseViewHolder<ExerciseInfo>>(
        diffCallback,
        onViewHolderClickListener
    ) {
    inner class ExerciseViewHolder(view: View, clickableAdapter: ClickableAdapter<ExerciseInfo>) :
        BaseViewHolder<ExerciseInfo>(view, onViewHolderClickListener, clickableAdapter) {
        private val image = view.img_exercise_detail_image
        private val name = view.tv_exercise_detail_name
        private val equipment = view.tv_exercise_detail_equipment

        override fun bind(item: ExerciseInfo) {
            name.text = item.name
            equipment.text = item.equipment.toString()
            CircularProgressDrawable(context).apply {
                strokeWidth = 5f
                centerRadius = 30f
                backgroundColor = Color.BLACK
                start()
            }.let {
                Glide.with(image).load(item.imageURL).centerInside()
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
            ),
            this
        )
    }


    override fun onBindViewHolder(holder: BaseViewHolder<ExerciseInfo>, position: Int) {
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