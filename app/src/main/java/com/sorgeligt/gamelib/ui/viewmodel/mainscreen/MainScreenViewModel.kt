package com.sorgeligt.gamelib.ui.viewmodel.mainscreen

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.sorgeligt.gamelib.core.network.di.NetworkComponent
import com.sorgeligt.gamelib.model.games.GameItem
import com.sorgeligt.gamelib.model.games.NestedRecyclerItem
import com.sorgeligt.gamelib.ui.viewmodel.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainScreenViewModel : BaseViewModel() {

    private val _data = MutableLiveData<List<NestedRecyclerItem>>()
    val data: LiveData<List<NestedRecyclerItem>> = _data
    private val api = NetworkComponent.createApi()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            _data.postValue(getLoaders())

            val items = getItems()
            _data.postValue(items)
        }
    }

    private suspend fun getLoaders(): List<NestedRecyclerItem> {
        return listOf(
            NestedRecyclerItem.HorizontalRecyclerItem(
                "Top upcoming",
                (1..8).map {
                    GameItem.ProgressWideGameItem()
                }
            ),
            NestedRecyclerItem.HorizontalRecyclerItem(
                "Latest releases",
                (1..8).map {
                    GameItem.ProgressThinGameItem()

                }
            ),
            NestedRecyclerItem.HorizontalRecyclerItem(
                "The most rated in 2022 ",
                (1..8).map {
                    GameItem.ProgressWideGameItem()
                }
            ))
    }

    private suspend fun getItems(): List<NestedRecyclerItem> {
        val firstResult = api.games()
        val secondResult = api.games(ordering = "rating")
        Log.e("MEM", "$firstResult \n $secondResult")
        return listOf(
            NestedRecyclerItem.HorizontalRecyclerItem(
                title = "Top upcoming",
                games = firstResult.results?.map {
                    GameItem.WideGameItem(
                        id = it.id,
                        title = it.name,
                        imageUrl = it.imageUrl
                    )
                } ?: listOf(GameItem.ProgressWideGameItem())
            ),
            NestedRecyclerItem.HorizontalRecyclerItem(
                title = "Latest releases",
                games = secondResult.results?.map {
                    GameItem.ThinGameItem(
                        id = it.id,
                        title = it.name,
                        imageUrl = it.imageUrl
                    )
                }?: listOf(GameItem.ProgressWideGameItem())
            ),
            NestedRecyclerItem.HorizontalRecyclerItem(
                title = "The most rated in 2022 ",
                games = api.games(dates = "2019-09-01,2019-09-30").results?.map {
                    GameItem.ThinGameItem(
                        id = it.id,
                        title = it.name,
                        imageUrl = it.imageUrl
                    )
                }?: listOf(GameItem.ProgressWideGameItem())
            )
        )
    }
}
