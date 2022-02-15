package com.example.api_di.di

import com.example.api_di.repository.ListUseCase
import org.koin.dsl.module

val domainModule = module {
    factory {
        ListUseCase(itemsListRepository = get())
    }
}