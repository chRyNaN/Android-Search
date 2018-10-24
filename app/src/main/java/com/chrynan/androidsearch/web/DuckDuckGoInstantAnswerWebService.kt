package com.chrynan.androidsearch.web

import com.chrynan.androidsearch.model.answer.InstantAnswer
import kotlinx.coroutines.experimental.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface DuckDuckGoInstantAnswerWebService {

    @GET("?format=json&no_redirect=1&")
    fun getInstanceAnswer(@Query("q") query: String): Deferred<InstantAnswer>
}