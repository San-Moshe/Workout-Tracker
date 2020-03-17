package com.san.ui.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView

interface OnViewHolderClickListener<T> {
    fun onItemSelected(item: T)
}

abstract class BaseViewHolder<T>(
    view: View,
    private val onViewHolderClickListener: OnViewHolderClickListener<T>,
    private val clickableAdapter: ClickableAdapter<T>
) :
    RecyclerView.ViewHolder(view), View.OnClickListener {

    override fun onClick(v: View?) {
        onViewHolderClickListener.onItemSelected(clickableAdapter.onItemReq(adapterPosition))
    }

    abstract fun bind(item: T)
}