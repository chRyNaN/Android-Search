package com.chrynan.androidsearch.provider

import com.chrynan.androidsearch.mapper.AppMapper
import com.chrynan.androidsearch.repository.ApplicationInfoRepository
import com.chrynan.androidsearch.util.containsQueryIgnoreCase
import com.chrynan.androidsearch.viewmodel.AutoCompleteResultViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope

class AppProvider(
        private val repository: ApplicationInfoRepository,
        private val mapper: AppMapper
) : ResultProvider<AutoCompleteResultViewModel.App> {

    private var applications: Sequence<AutoCompleteResultViewModel.App>? = null

    override suspend fun query(query: String) = coroutineScope {
        async {
            if (applications == null) {
                applications = repository.getAll()
                        .map(mapper::map)
            }

            applications?.containsQueryIgnoreCase(query) { it.title }
                    ?: emptySequence()
        }
    }
}