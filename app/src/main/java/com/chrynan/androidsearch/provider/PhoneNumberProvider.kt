package com.chrynan.androidsearch.provider

import android.telephony.PhoneNumberUtils
import com.chrynan.androidsearch.mapper.PhoneNumberMapper
import com.chrynan.androidsearch.viewmodel.AutoCompleteResultViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PhoneNumberProvider @Inject constructor(private val mapper: PhoneNumberMapper) : QueryResultProvider<AutoCompleteResultViewModel.PhoneNumber> {

    companion object {

        private val PHONE_NUMBER_REGEX = Regex("^(\\+\\d{1,2}\\s)?\\(?\\d{3}\\)?[\\s.-]?\\d{3}[\\s.-]?\\d{4}\$")
    }

    override fun handlesQuery(query: String) =
            query.isNotBlank() and (PhoneNumberUtils.isGlobalPhoneNumber(query) or query.matches(PHONE_NUMBER_REGEX))

    override suspend fun query(query: String) = coroutineScope {
        async { mapper.map(query).asSequence() }
    }
}