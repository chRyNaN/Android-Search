package com.chrynan.androidsearch.provider

import com.chrynan.androidsearch.mapper.AppMapper
import com.chrynan.androidsearch.repository.ApplicationInfoRepository
import com.chrynan.androidsearch.util.containsQueryIgnoreCase
import com.chrynan.androidsearch.viewmodel.AutoCompleteResultViewModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppProvider @Inject constructor(
        private val repository: ApplicationInfoRepository,
        private val mapper: AppMapper
) : QueryResultProvider<AutoCompleteResultViewModel.App> {

    private var applications: Sequence<AutoCompleteResultViewModel.App>? = null

    override suspend fun query(query: String): Sequence<AutoCompleteResultViewModel.App> {
        if (applications == null) {
            applications = repository.getAll()
                    .map(mapper::map)
        }

        return applications!!.containsQueryIgnoreCase(query) { it.title }
    }
}