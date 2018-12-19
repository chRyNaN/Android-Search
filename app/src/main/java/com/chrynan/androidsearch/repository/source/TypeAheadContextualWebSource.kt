package com.chrynan.androidsearch.repository.source

import com.chrynan.androidsearch.model.TypeAhead
import com.chrynan.androidsearch.repository.TypeAheadRepository
import com.chrynan.androidsearch.web.ContextualWebSuggestionWebService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TypeAheadContextualWebSource @Inject constructor(private val webService: ContextualWebSuggestionWebService) : TypeAheadRepository {

    override suspend fun getBy(query: String): Sequence<TypeAhead> =
            webService.getSearchSuggestions(query = query)
                    .await()
                    .asSequence()
                    .take(3)
                    .map { TypeAhead(suggestion = it) }
}