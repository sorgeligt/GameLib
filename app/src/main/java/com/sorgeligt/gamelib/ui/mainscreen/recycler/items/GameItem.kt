package com.sorgeligt.gamelib.ui.mainscreen.recycler.items

sealed class GameItem(
    open val id: Long,
    open val title: String
) {
    data class ThinGameItem(override val id: Long, override val title: String) : GameItem(id, title)
    data class WideGameItem(override val id: Long, override val title: String) : GameItem(id, title)
}

