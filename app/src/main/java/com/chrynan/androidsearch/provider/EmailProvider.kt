package com.chrynan.androidsearch.provider

import android.util.Patterns
import com.chrynan.androidsearch.mapper.EmailMapper
import com.chrynan.androidsearch.viewmodel.AutoCompleteResultViewModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class EmailProvider @Inject constructor(private val mapper: EmailMapper) : QueryResultProvider<AutoCompleteResultViewModel.Email> {

    companion object {

        private val EMAIL_REGEX = Patterns.EMAIL_ADDRESS.toRegex()
    }

    override fun handlesQuery(query: String) = query.isNotBlank() and EMAIL_REGEX.matches(query)

    override suspend fun query(query: String) = listOf(mapper.map(query))
}