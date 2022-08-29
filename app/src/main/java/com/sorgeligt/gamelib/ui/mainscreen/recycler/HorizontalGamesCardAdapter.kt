package com.sorgeligt.gamelib.ui.mainscreen.recycler

import com.hannesdorfmann.adapterdelegates4.AdapterDelegate
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import com.sorgeligt.gamelib.model.games.GameItem
import com.sorgeligt.gamelib.ui.base.BaseDiffUtilItemCallback

class HorizontalGamesCardAdapter(
    vararg adapterDelegate: AdapterDelegate<List<GameItem>>
) : AsyncListDifferDelegationAdapter<GameItem>(BaseDiffUtilItemCallback()) {
    init {
        adapterDelegate.forEach { delegatesManager.addDelegate(it) }
    }
}