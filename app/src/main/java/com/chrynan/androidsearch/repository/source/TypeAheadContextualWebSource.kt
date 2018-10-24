package com.chrynan.androidsearch.repository.source

import com.chrynan.androidsearch.model.TypeAhead
import com.chrynan.androidsearch.repository.TypeAheadRepository
import com.chrynan.androidsearch.web.ContextualWebSuggestionWebService

class TypeAheadContextualWebSource(private val webService: ContextualWebSuggestionWebService) : TypeAheadRepository {

    override suspend fun getBy(query: String): Sequence<TypeAhead> =
            webService.getSearchSuggestions(query = query)
                    .await()
                    .asSequence()
                    .take(3)
                    .map { TypeAhead(suggestion = it) }
}