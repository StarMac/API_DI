package com.example.api_di.repository

class ListUseCase(private val itemsListRepository: ListRepository) {
    suspend fun loadItemList() = itemsListRepository.getItemList()
}