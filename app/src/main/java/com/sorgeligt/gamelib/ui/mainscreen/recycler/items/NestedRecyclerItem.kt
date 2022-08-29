package com.sorgeligt.gamelib.ui.mainscreen.recycler.items

sealed interface NestedRecyclerItem {
    data class HorizontalRecyclerItem(val title:String, val games: List<GameItem>) : NestedRecyclerItem
}