package com.example.api_di.di

import com.example.api_di.viewmodel.ListFragmentViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel {
        ListFragmentViewModel(listUseCase = get())
    }
}