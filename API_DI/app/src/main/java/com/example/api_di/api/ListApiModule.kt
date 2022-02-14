package com.example.api_di.api

import org.koin.dsl.module

val ListApiModule = module {
    factory { ListApi().start() }
}