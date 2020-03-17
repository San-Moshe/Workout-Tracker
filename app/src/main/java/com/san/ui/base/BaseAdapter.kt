package com.san.ui.base

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

interface ClickableAdapter<T> {
    fun onItemReq(pos: Int): T
}

abstract class BaseAdapter<T, VH : BaseViewHolder<T>>(
    diffCallBack: DiffUtil.ItemCallback<T>,
    clickListener: OnViewHolderClickListener<T>
) :
    ListAdapter<T, VH>(diffCallBack), ClickableAdapter<T> {

    override fun onItemReq(pos: Int): T = getItem(pos)
}