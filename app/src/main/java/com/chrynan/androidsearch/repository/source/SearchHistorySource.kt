package com.chrynan.androidsearch.repository.source

import com.chrynan.androidsearch.model.Search
import com.chrynan.androidsearch.repository.SearchHistoryRepository

class SearchHistorySource : SearchHistoryRepository {

    override suspend fun getBy(query: String) = emptySequence<Search>()
}