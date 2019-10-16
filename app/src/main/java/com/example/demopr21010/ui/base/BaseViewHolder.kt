package com.example.demopr21010.ui.base

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

open class BaseViewHolder<T, VB : ViewDataBinding>(
    protected val binding: VB
) : RecyclerView.ViewHolder(binding.root) {

    protected var itemData: T? = null
    protected var itemPosition: Int = -1

    open fun onBindData(itemData: T) {
        this.itemData = itemData
    }
}