package com.sorgeligt.gamelib.ui.mainscreen.recycler

import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter

object MainScreenAdapters {
    fun nestedRecyclerAdapter() = ListDelegationAdapter(
        MainScreenDelegates.horizontalRecyclerDelegate { }
    )

    fun horizontalAdapter() = ListDelegationAdapter(
        MainScreenDelegates.thinGameAdapterDelegate {},
        MainScreenDelegates.wideGameAdapterDelegate {}
    )
}