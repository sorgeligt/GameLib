package com.sorgeligt.gamelib.model.games

import com.sorgeligt.gamelib.model.base.ListItem

sealed class NestedRecyclerItem(
    open val title: String,
    open val games: List<GameItem>
) : ListItem() {
    data class HorizontalRecyclerItem(
        override val title: String,
        override val games: List<GameItem>
    ) : NestedRecyclerItem(title, games) {
        override val itemId: Long = title.hashCode().toLong()
    }
}