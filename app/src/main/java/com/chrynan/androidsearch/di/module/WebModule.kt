package com.chrynan.androidsearch.di.module

import com.chrynan.androidsearch.web.ContextualWebSuggestionWebService
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
internal abstract class WebModule {

    @Module
    companion object {

        @JvmStatic
        @Provides
        @Singleton
        fun provideMoshi(): Moshi =
                Moshi.Builder()
                        .build()

        @JvmStatic
        @Provides
        @Singleton
        fun provideTypeAheadWebService(moshi: Moshi): ContextualWebSuggestionWebService =
                Retrofit.Builder()
                        .baseUrl("https://contextualwebsearch.com")
                        .addConverterFactory(MoshiConverterFactory.create(moshi))
                        .addCallAdapterFactory(CoroutineCallAdapterFactory())
                        .build()
                        .create(ContextualWebSuggestionWebService::class.java)
    }
}