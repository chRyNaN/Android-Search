package com.chrynan.androidsearch.provider

import com.chrynan.androidsearch.mapper.SearchHistoryMapper
import com.chrynan.androidsearch.repository.SearchHistoryRepository
import com.chrynan.androidsearch.viewmodel.AutoCompleteResultViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope

class SearchHistoryProvider(
        private val repository: SearchHistoryRepository,
        private val mapper: SearchHistoryMapper
) : ResultProvider<AutoCompleteResultViewModel.SearchHistory> {

    override fun handlesQuery(query: String) = false

    override suspend fun query(query: String) = coroutineScope {
        async {
            repository.getBy(query)
                    .map(mapper::map)
        }
    }
}