package com.sorgeligt.gamelib.ui.mainscreen.recycler

import androidx.recyclerview.widget.DiffUtil
import com.hannesdorfmann.adapterdelegates4.AdapterDelegate
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import com.sorgeligt.gamelib.model.games.NestedRecyclerItem
import com.sorgeligt.gamelib.ui.base.BaseDiffUtilItemCallback

class NestedRecyclerAdapter(
    vararg adapterDelegate: AdapterDelegate<List<NestedRecyclerItem>>
) : AsyncListDifferDelegationAdapter<NestedRecyclerItem>(BaseDiffUtilItemCallback()) {
    init {
        adapterDelegate.forEach { delegatesManager.addDelegate(it) }
    }
}