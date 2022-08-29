package com.sorgeligt.gamelib.ui.mainscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.sorgeligt.gamelib.databinding.FragmentMainBinding
import com.sorgeligt.gamelib.ui.mainscreen.recycler.MainScreenDelegates
import com.sorgeligt.gamelib.ui.mainscreen.recycler.NestedRecyclerAdapter
import com.sorgeligt.gamelib.ui.viewmodel.mainscreen.MainScreenViewModel

class MainScreenFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private val viewModel by viewModels<MainScreenViewModel>()
    private val nestedRecyclerAdapter = NestedRecyclerAdapter(
        MainScreenDelegates.horizontalRecyclerDelegate { }
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
        binding.recyclerView.adapter = nestedRecyclerAdapter
        viewModel.data.observe(viewLifecycleOwner) {
            nestedRecyclerAdapter.items = it
        }

    }
}