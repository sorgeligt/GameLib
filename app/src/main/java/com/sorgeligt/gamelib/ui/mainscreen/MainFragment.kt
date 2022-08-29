package com.sorgeligt.gamelib.ui.mainscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import com.sorgeligt.gamelib.databinding.FragmentMainBinding
import com.sorgeligt.gamelib.ui.mainscreen.recycler.MainScreenAdapters.nestedRecyclerAdapter
import com.sorgeligt.gamelib.ui.mainscreen.recycler.MainScreenDelegates
import com.sorgeligt.gamelib.ui.mainscreen.recycler.items.*

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.adapter = nestedRecyclerAdapter().apply {
            items = listOf(
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
                ),NestedRecyclerItem.HorizontalRecyclerItem(
                    "FINALY2",
                    (150..152).map { t ->
                        GameItem.ThinGameItem(t.toLong(), "Another Title $t")
                    }
                ),
            )
        }
    }
}