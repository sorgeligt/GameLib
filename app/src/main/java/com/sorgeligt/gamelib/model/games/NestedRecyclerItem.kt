package com.sorgeligt.gamelib.model.games

import com.sorgeligt.gamelib.model.base.ListItem

sealed interface NestedRecyclerItem : ListItem {
    data class HorizontalRecyclerItem(
        val title: String,
        val games: List<GameItem>
    ) : NestedRecyclerItem
}