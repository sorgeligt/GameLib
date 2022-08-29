package com.sorgeligt.gamelib.model.games

import com.sorgeligt.gamelib.model.base.ListItem

sealed class GameItem(
    open val id: Long,
    open val title: String,
    open val imageUrl: String?
) : ListItem() {
    data class ThinGameItem(
        override val id: Long,
        override val title: String,
        override val imageUrl: String?
    ) : GameItem(id, title, imageUrl) {
        override val itemId: Long = id
    }

    data class ProgressThinGameItem(
        override val id: Long = 0,
        override val title: String = "",
        override val imageUrl: String? = ""
    ) : GameItem(id, title, imageUrl) {
        override val itemId: Long = id
    }

    data class WideGameItem(
        override val id: Long,
        override val title: String,
        override val imageUrl: String?
    ) : GameItem(id, title, imageUrl) {
        override val itemId: Long = id
    }

    data class ProgressWideGameItem(
        override val id: Long = 0,
        override val title: String = "",
        override val imageUrl: String? = ""
    ) : GameItem(id, title, imageUrl) {
        override val itemId: Long = id
    }
}

