package com.sorgeligt.gamelib.ui.mainscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import com.sorgeligt.gamelib.databinding.FragmentMainBinding
import com.sorgeligt.gamelib.ui.base.ListItem

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding

    private val adapter = ListDelegationAdapter<List<ListItem>>(
        MainScreenDelegates.gamesHorizontalDelegate
    )

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

        with(binding){
            recyclerView.adapter = adapter

            adapter.apply {
                items = listOf(GamesHorizontalItem(emptyList()))
                notifyDataSetChanged()
            }
        }
    }
}