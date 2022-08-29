package com.sorgeligt.gamelib.ui.base

import androidx.recyclerview.widget.DiffUtil
import com.sorgeligt.gamelib.model.base.ListItem

open class BaseDiffUtilItemCallback<T : ListItem> : DiffUtil.ItemCallback<T>() {
    override fun areItemsTheSame(
        oldItem: T,
        newItem: T
    ): Boolean {
        return oldItem.itemId == newItem.itemId
    }

    override fun areContentsTheSame(
        oldItem: T,
        newItem: T
    ): Boolean {
        return oldItem == newItem
    }
}