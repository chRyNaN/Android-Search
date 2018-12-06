package com.chrynan.androidsearch.repository.source

import android.util.Log
import com.chrynan.androidsearch.repository.InstantAnswerRepository
import com.chrynan.androidsearch.web.DuckDuckGoInstantAnswerWebService
import com.chrynan.instantanswer.api.InstantAnswer
import com.chrynan.instantanswer.containsValidFields
import javax.inject.Inject

class DuckDuckGoInstantAnswerSource @Inject constructor(private val webService: DuckDuckGoInstantAnswerWebService) : InstantAnswerRepository {

    override suspend fun getBy(query: String): InstantAnswer {
        try {
            val response = webService.getInstantAnswer(query).await()

            val result = response.body()!!

            return result.run { copyWith(relatedTopics = relatedTopics.filter { it.containsValidFields }, results = results.filter { it.containsValidFields }) }
        } catch (e: Exception) {
            Log.e("Testing", "Error getting instant answer", e)
            throw RuntimeException("Error trying to fetch instant answer.")
        }
    }
}