package com.example.api_di.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.api_di.model.Item
import com.example.api_di.repository.ListUseCase
import kotlinx.coroutines.launch

class ListFragmentViewModel(private val listUseCase: ListUseCase) : ViewModel() {
    private val _itemList = MutableLiveData<List<Item>>()
    val itemList: LiveData<List<Item>> = _itemList

    fun loadItemList() {
        viewModelScope.launch {
            try {
                _itemList.value = listUseCase.loadItemList()
            } catch (e: Exception) {
                _itemList.value = listOf(Item(0, "${e.message}", ""))
            }
        }
    }
}