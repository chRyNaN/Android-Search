package com.chrynan.androidsearch.di.module

import com.chrynan.androidsearch.web.ContextualWebSuggestionWebService
import com.chrynan.androidsearch.web.DuckDuckGoInstantAnswerWebService
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.experimental.CoroutineCallAdapterFactory
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val WEB_MODULE = module {
    single {
        Retrofit.Builder()
                .baseUrl("https://contextualwebsearch.com")
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .build()
                .create(ContextualWebSuggestionWebService::class.java)
    }
    single {
        Retrofit.Builder()
                .baseUrl("https://api.duckduckgo.com/")
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .build()
                .create(DuckDuckGoInstantAnswerWebService::class.java)
    }
}