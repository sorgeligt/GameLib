package com.sorgeligt.gamelib.ui.mainscreen.recycler

import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegate
import com.sorgeligt.gamelib.R
import com.sorgeligt.gamelib.ui.mainscreen.recycler.MainScreenAdapters.horizontalAdapter
import com.sorgeligt.gamelib.ui.mainscreen.recycler.items.GameItem
import com.sorgeligt.gamelib.ui.mainscreen.recycler.items.NestedRecyclerItem
import kotlin.random.Random

object MainScreenDelegates {

    fun thinGameAdapterDelegate(thinGameClickListener: (GameItem.ThinGameItem) -> Unit) =
        adapterDelegate<GameItem.ThinGameItem, GameItem>(R.layout.item_game_thin) {
            val title: TextView = findViewById(R.id.titleTextView)
            val imageView: ImageView = findViewById(R.id.imageView)

            this.itemView.setOnClickListener { thinGameClickListener(item) }

            bind {
                title.text = item.title
                Glide.with(this.itemView)
                    .load("https://source.unsplash.com/random/1200x1200?sig=${Random.nextInt()}")
                    .placeholder(R.drawable.loading_plug)
                    .centerCrop()
                    .into(imageView)
            }
        }

    fun wideGameAdapterDelegate(wideGameClickListener: (GameItem.WideGameItem) -> Unit) =
        adapterDelegate<GameItem.WideGameItem, GameItem>(R.layout.item_game_wide) {
            val title: TextView = findViewById(R.id.titleTextView)
            val imageView: ImageView = findViewById(R.id.imageView)

            this.itemView.setOnClickListener { wideGameClickListener(item) }

            bind {
                title.text = item.title
                Glide.with(this.itemView)
                    .load("https://source.unsplash.com/random/1200x1200?sig=${Random.nextInt()}")
                    .centerCrop()
                    .placeholder(R.drawable.loading_plug)
                    .into(imageView)
            }
        }

    fun horizontalRecyclerDelegate(
        recyclerClickListener: (NestedRecyclerItem.HorizontalRecyclerItem) -> Unit
    ) = adapterDelegate<NestedRecyclerItem.HorizontalRecyclerItem, NestedRecyclerItem>(
        R.layout.item_games_horizontal
    ) {
        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        val title: TextView = findViewById(R.id.titleGamesTextView)

        this.itemView.setOnClickListener { recyclerClickListener(item) }


        bind {
            title.text = item.title
            recyclerView.adapter = horizontalAdapter().apply {
                items = item.games
                notifyDataSetChanged() // TODO
            }
        }
    }

}