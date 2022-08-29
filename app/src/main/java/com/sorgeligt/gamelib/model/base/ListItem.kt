package com.sorgeligt.gamelib.model.base


abstract class ListItem {
    abstract val itemId: Long

    abstract override fun equals(other: Any?): Boolean

    abstract override fun hashCode(): Int

}