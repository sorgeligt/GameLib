package com.sorgeligt.gamelib.ui.viewmodel.mainscreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.sorgeligt.gamelib.model.games.GameItem
import com.sorgeligt.gamelib.model.games.NestedRecyclerItem
import com.sorgeligt.gamelib.ui.viewmodel.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

class MainScreenViewModel : BaseViewModel() {

    private val _data = MutableLiveData<List<NestedRecyclerItem>>()
    val data: LiveData<List<NestedRecyclerItem>> = _data

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
                "Top Games",
                (1..8).map { t ->
                    GameItem.ProgressWideGameItem(t.toLong(), "Title Number $t")
                }
            ),
            NestedRecyclerItem.HorizontalRecyclerItem(
                "Stars Games",
                (1..8).map { t ->
                    GameItem.ProgressThinGameItem(t.toLong(), "Another Title $t")

                }
            ),
            NestedRecyclerItem.HorizontalRecyclerItem(
                "Top Games",
                (1..8).map { t ->
                    GameItem.ProgressWideGameItem(t.toLong(), "Title Number $t")
                }
            ))
    }

    private suspend fun getItems(): List<NestedRecyclerItem> {
        delay(2000L)
        return listOf(
            NestedRecyclerItem.HorizontalRecyclerItem(
                "Top Games",
                (1..20).map { t ->
                    GameItem.WideGameItem(t.toLong(), "Title Number $t")
                }
            ),
            NestedRecyclerItem.HorizontalRecyclerItem(
                "Stars Games",
                (20..50).map { t ->
                    GameItem.ThinGameItem(t.toLong(), "Another Title $t")

                }
            ),
            NestedRecyclerItem.HorizontalRecyclerItem(
                "Cool Games",
                (70..120).map { t ->
                    GameItem.WideGameItem(t.toLong(), "Title Number $t")
                }
            ),
            NestedRecyclerItem.HorizontalRecyclerItem(
                "Bad Games",
                (120..150).map { t ->
                    GameItem.ThinGameItem(t.toLong(), "Another Title $t")
                }
            ),

            NestedRecyclerItem.HorizontalRecyclerItem(
                "FINALY",
                (120..150).map { t ->
                    GameItem.ThinGameItem(t.toLong(), "Another Title $t")
                }
            ),
            NestedRecyclerItem.HorizontalRecyclerItem(
                "FINALY2",
                (150..152).map { t ->
                    GameItem.ThinGameItem(t.toLong(), "Another Title $t")
                }
            ))

    }
}
