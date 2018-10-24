package com.chrynan.androidsearch.repository

import com.chrynan.androidsearch.model.Search

interface SearchHistoryRepository {

    suspend fun getBy(query: String): Sequence<Search>
}