package com.sorgeligt.gamelib.ui.mainscreen.recycler

import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegate
import com.sorgeligt.gamelib.R
import com.sorgeligt.gamelib.model.games.GameItem
import com.sorgeligt.gamelib.model.games.NestedRecyclerItem

object MainScreenDelegates {

    private fun thinGameAdapterDelegate(thinGameClickListener: (GameItem.ThinGameItem) -> Unit) =
        adapterDelegate<GameItem.ThinGameItem, GameItem>(R.layout.item_game_thin) {
            val title: TextView = findViewById(R.id.titleTextView)
            val imageView: ImageView = findViewById(R.id.imageView)

            this.itemView.setOnClickListener { thinGameClickListener(item) }

            bind {
                title.text = item.title
                Glide.with(imageView)
                    .load(item.imageUrl) // TODO OVERRIDE
                    .transform(CenterCrop(), RoundedCorners(10)) // TODO RESOURCES
                    .transition(withCrossFade(450))
                    .into(imageView)
            }
            onViewRecycled {
                Glide.with(itemView.rootView).clear(imageView)
            }
        }

    private fun progressThinGameAdapterDelegate() =
        adapterDelegate<GameItem.ProgressThinGameItem, GameItem>(R.layout.item_progress_game_thin) {}

    private fun wideGameAdapterDelegate(wideGameClickListener: (GameItem.WideGameItem) -> Unit) =
        adapterDelegate<GameItem.WideGameItem, GameItem>(R.layout.item_game_wide) {
            val title: TextView = findViewById(R.id.titleTextView)
            val imageView: ImageView = findViewById(R.id.imageView)

            this.itemView.setOnClickListener { wideGameClickListener(item) }

            bind {
                title.text = item.title
                Glide.with(itemView.rootView)
                    .load(item.imageUrl) // TODO OVERRIDE
                    .transform(CenterCrop(), RoundedCorners(10)) // TODO RESOURCES
                    .transition(withCrossFade(450))
                    .into(imageView)
            }
            onViewRecycled {
                Glide.with(itemView.rootView).clear(imageView)
            }
        }

    private fun progressWideGameAdapterDelegate() =
        adapterDelegate<GameItem.ProgressWideGameItem, GameItem>(R.layout.item_progress_game_wide) {}

    fun horizontalRecyclerDelegate(
        recyclerClickListener: (NestedRecyclerItem.HorizontalRecyclerItem) -> Unit
    ) = adapterDelegate<NestedRecyclerItem.HorizontalRecyclerItem, NestedRecyclerItem>(
        R.layout.item_games_horizontal
    ) {
        this.itemView.setOnClickListener {
            recyclerClickListener(item)
        }

        val horizontalGamesCardAdapter = HorizontalGamesCardAdapter(
            thinGameAdapterDelegate {},
            progressThinGameAdapterDelegate(),
            wideGameAdapterDelegate {},
            progressWideGameAdapterDelegate()
        )

        findViewById<RecyclerView>(R.id.recycler_view).apply {
            adapter = horizontalGamesCardAdapter
        }
        val title: TextView = findViewById(R.id.titleGamesTextView)

        bind {
            title.text = item.title
            horizontalGamesCardAdapter.items = item.games
        }
    }

}

