package com.chrynan.androidsearch.provider

import android.util.Patterns
import com.chrynan.androidsearch.mapper.EmailMapper
import com.chrynan.androidsearch.viewmodel.AutoCompleteResultViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import javax.inject.Inject

class EmailProvider @Inject constructor(private val mapper: EmailMapper) : ResultProvider<AutoCompleteResultViewModel.Email> {

    companion object {

        private val EMAIL_REGEX = Patterns.EMAIL_ADDRESS.toRegex()
    }

    override fun handlesQuery(query: String) = query.isNotBlank() and EMAIL_REGEX.matches(query)

    override suspend fun query(query: String) = coroutineScope {
        async { sequenceOf(mapper.map(query)) }
    }
}