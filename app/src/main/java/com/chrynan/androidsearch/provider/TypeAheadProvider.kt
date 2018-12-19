package com.chrynan.androidsearch.provider

import com.chrynan.androidsearch.mapper.TypeAheadMapper
import com.chrynan.androidsearch.repository.TypeAheadRepository
import com.chrynan.androidsearch.viewmodel.AutoCompleteResultViewModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TypeAheadProvider @Inject constructor(
        private val repository: TypeAheadRepository,
        private val mapper: TypeAheadMapper
) : QueryResultProvider<AutoCompleteResultViewModel.TypeAheadSearch> {

    override suspend fun query(query: String) =
            try {
                repository.getBy(query)
                        .map(mapper::map)
            } catch (e: Exception) {
                emptySequence<AutoCompleteResultViewModel.TypeAheadSearch>()
            }
}