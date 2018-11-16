package com.chrynan.androidsearch.web

import com.chrynan.instantanswer.api.InstantAnswer
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface DuckDuckGoInstantAnswerWebService {

    @GET("?format=json&no_redirect=1&")
    fun getInstantAnswer(@Query("q") query: String): Deferred<Response<InstantAnswer>>
}