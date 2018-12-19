package com.chrynan.androidsearch.repository.source

import com.chrynan.androidsearch.model.Search
import com.chrynan.androidsearch.repository.SearchHistoryRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SearchHistorySource @Inject constructor() : SearchHistoryRepository {

    override suspend fun getBy(query: String) = emptySequence<Search>()
}