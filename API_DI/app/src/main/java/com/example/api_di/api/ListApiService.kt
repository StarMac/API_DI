package com.example.api_di.api

import com.example.api_di.model.Item
import retrofit2.http.GET

interface ListApiService {
    @GET("photos")
    suspend fun getItems(): List<Item>
}