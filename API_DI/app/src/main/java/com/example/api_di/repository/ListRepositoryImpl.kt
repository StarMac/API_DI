package com.example.api_di.repository

import com.example.api_di.api.ListApiService

class ListRepositoryImpl(private val listService: ListApiService) : ListRepository {
    override suspend fun getItemList() = listService.getItems()
}