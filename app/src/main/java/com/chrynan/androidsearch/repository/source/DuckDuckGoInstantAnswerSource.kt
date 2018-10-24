package com.chrynan.androidsearch.repository.source

import com.chrynan.androidsearch.repository.InstantAnswerRepository
import com.chrynan.androidsearch.web.DuckDuckGoInstantAnswerWebService

class DuckDuckGoInstantAnswerSource(private val webService: DuckDuckGoInstantAnswerWebService) : InstantAnswerRepository {

    override suspend fun getBy(query: String) =
            webService.getInstanceAnswer(query)
                    .await()
                    .run { copy(relatedTopics = relatedTopics.filter { it.isValid }, results = results.filter { it.isValid }) }
}