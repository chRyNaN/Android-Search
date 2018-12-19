package com.chrynan.androidsearch.provider

import android.util.Patterns
import com.chrynan.androidsearch.mapper.WebAddressMapper
import com.chrynan.androidsearch.viewmodel.AutoCompleteResultViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WebAddressProvider @Inject constructor(private val mapper: WebAddressMapper) : QueryResultProvider<AutoCompleteResultViewModel.WebAddress> {

    companion object {

        private val URL_REGEX = Patterns.WEB_URL.toRegex()
    }

    override fun handlesQuery(query: String) = query.isNotBlank() and URL_REGEX.matches(query)

    override suspend fun query(query: String) = coroutineScope {
        async { sequenceOf(mapper.map(query)) }
    }
}