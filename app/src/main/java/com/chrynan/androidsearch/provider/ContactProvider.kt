package com.chrynan.androidsearch.provider

import com.chrynan.androidsearch.mapper.ContactMapper
import com.chrynan.androidsearch.repository.ContactRepository
import com.chrynan.androidsearch.viewmodel.AutoCompleteResultViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ContactProvider @Inject constructor(
        private val repository: ContactRepository,
        private val mapper: ContactMapper
) : QueryResultProvider<AutoCompleteResultViewModel.Contact> {

    override suspend fun query(query: String) = coroutineScope {
        async {
            repository.getBy(query)
                    .map(mapper::map)
        }
    }
}