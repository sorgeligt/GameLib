package com.sorgeligt.gamelib.ui.mainscreen.recycler

import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter

object MainScreenAdapters {
    val nestedRecyclerAdapter = ListDelegationAdapter(
        MainScreenDelegates.horizontalRecyclerDelegate { }
    )

    fun horizontalAdapter() = ListDelegationAdapter(
        MainScreenDelegates.thinGameAdapterDelegate {},
        MainScreenDelegates.progressThinGameAdapterDelegate(),

        MainScreenDelegates.wideGameAdapterDelegate {},
        MainScreenDelegates.progressWideGameAdapterDelegate()
    )
}