package com.sorgeligt.gamelib.ui.viewmodel.mainscreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.sorgeligt.gamelib.R
import com.sorgeligt.gamelib.core.network.di.NetworkComponent
import com.sorgeligt.gamelib.model.games.GameItem
import com.sorgeligt.gamelib.model.games.NestedRecyclerItem
import com.sorgeligt.gamelib.ui.viewmodel.base.BaseViewModel
import com.sorgeligt.gamelib.util.ResourceProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainScreenViewModel @Inject constructor(
    private val resource: ResourceProvider
) : BaseViewModel() {

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

    //TODO resource
    private fun getLoaders(): List<NestedRecyclerItem> {
        return listOf(
            NestedRecyclerItem.HorizontalRecyclerItem(
                resource.string(R.string.top_upcoming),
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

    //TODO resource
    private suspend fun getItems(): List<NestedRecyclerItem> {
        return listOf(
            NestedRecyclerItem.HorizontalRecyclerItem(
                title = "Top upcoming",
                games = api.games().results?.map {
                    GameItem.WideGameItem(
                        id = it.id,
                        title = it.name,
                        imageUrl = it.imageUrl
                    )
                } ?: listOf(GameItem.ProgressWideGameItem())
            ),
            NestedRecyclerItem.HorizontalRecyclerItem(
                title = "Latest releases",
                games = api.games().results?.map {
                    GameItem.ThinGameItem(
                        id = it.id,
                        title = it.name,
                        imageUrl = it.imageUrl
                    )
                } ?: listOf(GameItem.ProgressWideGameItem())
            ),
            NestedRecyclerItem.HorizontalRecyclerItem(
                title = "The most rated in 2022 ",
                games = api.games(dates = "2019-09-01,2019-09-30").results?.map {
                    GameItem.ThinGameItem(
                        id = it.id,
                        title = it.name,
                        imageUrl = it.imageUrl
                    )
                } ?: listOf(GameItem.ProgressWideGameItem())
            ),
            NestedRecyclerItem.HorizontalRecyclerItem(
                title = "Vanya gey",
                games = api.games(dates = "2018-09-01,2019-09-30").results?.map {
                    GameItem.WideGameItem(
                        id = it.id,
                        title = it.name,
                        imageUrl = it.imageUrl
                    )
                } ?: listOf(GameItem.ProgressWideGameItem())
            ),
            NestedRecyclerItem.HorizontalRecyclerItem(
                title = "Vanya cool",
                games = api.games(
                    dates = "2017-09-01,2021-09-30",
                    ordering = "rating"
                ).results?.map {
                    GameItem.ThinGameItem(
                        id = it.id,
                        title = it.name,
                        imageUrl = it.imageUrl
                    )
                } ?: listOf(GameItem.ProgressWideGameItem())
            )
        )
    }
}
