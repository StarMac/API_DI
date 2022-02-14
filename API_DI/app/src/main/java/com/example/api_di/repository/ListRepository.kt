package com.example.api_di.repository

import com.example.api_di.model.Item

interface ListRepository {
    suspend fun getItemList(): List<Item>
}