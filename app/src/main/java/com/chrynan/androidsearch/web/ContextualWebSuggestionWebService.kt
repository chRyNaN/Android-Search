package com.chrynan.androidsearch.web

import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface ContextualWebSuggestionWebService {

    @GET("/api/spelling/AutoComplete?")
    fun getSearchSuggestions(@Query("text") query: String, @Query("count") count: Int = 3): Deferred<List<String>>
}