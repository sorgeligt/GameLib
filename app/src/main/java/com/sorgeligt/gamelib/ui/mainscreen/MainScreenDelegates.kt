package com.sorgeligt.gamelib.ui.mainscreen

import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegate
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import com.sorgeligt.gamelib.databinding.ItemGamesHorizontalBinding
import com.sorgeligt.gamelib.ui.base.ListItem

object MainScreenDelegates {
    val gamesHorizontalDelegate = adapterDelegateViewBinding<GamesHorizontalItem, ListItem, ItemGamesHorizontalBinding>(
        { layoutInflater, container ->
            ItemGamesHorizontalBinding.inflate(layoutInflater, container, false)
        }
    ){
        bind {

        }
    }
}