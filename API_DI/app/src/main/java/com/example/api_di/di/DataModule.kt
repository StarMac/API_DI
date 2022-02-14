package com.example.api_di.di

import com.example.api_di.repository.ListRepository
import com.example.api_di.repository.ListRepositoryImpl
import org.koin.dsl.module

val dataModule = module {
    single<ListRepository> {
        ListRepositoryImpl(listService = get())
    }
}