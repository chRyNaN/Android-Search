package com.chrynan.androidsearch.di.module

import com.chrynan.androidsearch.web.ContextualWebSuggestionWebService
import com.chrynan.androidsearch.web.DuckDuckGoInstantAnswerWebService
import com.chrynan.instantanswer.typeadapter.InstantAnswerJsonTypeAdapterFactory
import com.chrynan.instantanswer.typeadapter.IntAsBooleanOrNullTypeAdapter
import com.chrynan.instantanswer.typeadapter.StringAsIntOrNullTypeAdapter
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val WEB_MODULE = module {
    single {
        Moshi.Builder()
                .add(StringAsIntOrNullTypeAdapter())
                .add(IntAsBooleanOrNullTypeAdapter())
                .add(InstantAnswerJsonTypeAdapterFactory())
                .build()
    }
    single {
        Retrofit.Builder()
                .baseUrl("https://contextualwebsearch.com")
                .addConverterFactory(MoshiConverterFactory.create(get()))
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .build()
                .create(ContextualWebSuggestionWebService::class.java)
    }
    single {
        Retrofit.Builder()
                .baseUrl("https://api.duckduckgo.com/")
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(MoshiConverterFactory.create(get()))
                .build()
                .create(DuckDuckGoInstantAnswerWebService::class.java)
    }
}