package com.chrynan.androidsearch.provider

import com.chrynan.androidsearch.mapper.TypeAheadMapper
import com.chrynan.androidsearch.repository.TypeAheadRepository
import com.chrynan.androidsearch.viewmodel.AutoCompleteResultViewModel
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.coroutineScope

class TypeAheadProvider(
        private val repository: TypeAheadRepository,
        private val mapper: TypeAheadMapper
) : ResultProvider<AutoCompleteResultViewModel.TypeAheadSearch> {

    override suspend fun query(query: String) = coroutineScope {
        async {
            try {
                repository.getBy(query)
                        .map(mapper::map)
            } catch (e: Exception) {
                emptySequence<AutoCompleteResultViewModel.TypeAheadSearch>()
            }
        }
    }
}