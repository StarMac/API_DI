package com.example.api_di.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.api_di.R
import com.example.api_di.adapter.ListFragmentAdapter
import com.example.api_di.databinding.FragmentListBinding
import com.example.api_di.viewmodel.ListFragmentViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class ListFragment : Fragment() {

    private var binding: FragmentListBinding? = null

    private val viewModel by viewModel<ListFragmentViewModel>()
    private val listItemAdapter = ListFragmentAdapter()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(layoutInflater)
        viewModel.loadItemList()
        fragmentAdapter()
        fragmentObserver()

        return binding!!.root
    }

    private fun fragmentAdapter() {
        binding!!.recyclerViewItemList.apply {
            adapter = listItemAdapter
        }
    }

    private fun fragmentObserver() {
        viewModel.itemList.observe(viewLifecycleOwner) {
            listItemAdapter.submitList(it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}