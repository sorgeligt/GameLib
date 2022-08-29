package com.sorgeligt.gamelib.model.games

import com.sorgeligt.gamelib.model.base.ListItem

sealed class GameItem(
    open val id: Long,
    open val title: String
) : ListItem {
    data class ThinGameItem(override val id: Long, override val title: String) : GameItem(id, title)
    data class ProgressThinGameItem(override val id: Long, override val title: String) : GameItem(id, title)
    data class WideGameItem(override val id: Long, override val title: String) : GameItem(id, title)
    data class ProgressWideGameItem(override val id: Long, override val title: String) : GameItem(id, title)
}

