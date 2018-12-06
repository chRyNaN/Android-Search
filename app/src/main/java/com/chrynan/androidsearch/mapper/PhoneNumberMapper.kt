package com.chrynan.androidsearch.mapper

import android.content.Context
import com.chrynan.androidsearch.R
import com.chrynan.androidsearch.viewmodel.AutoCompleteResultViewModel
import com.chrynan.mapper.UniDirectionalMapper
import javax.inject.Inject

class PhoneNumberMapper @Inject constructor(private val context: Context) : UniDirectionalMapper<String, List<AutoCompleteResultViewModel.PhoneNumber>> {

    private val phoneDescription by lazy { context.getString(R.string.auto_complete_description_phone_number) }
    private val smsDescription by lazy { context.getString(R.string.auto_complete_description_sms) }

    override fun map(value: String) =
            listOf(
                    AutoCompleteResultViewModel.PhoneNumber(
                            title = value,
                            description = phoneDescription,
                            defaultIconResId = 0,
                            iconFetcher = null,
                            actionIcon = null,
                            phoneNumber = value,
                            callAction = true),
                    AutoCompleteResultViewModel.PhoneNumber(
                            title = value,
                            description = smsDescription,
                            defaultIconResId = 0,
                            iconFetcher = null,
                            actionIcon = null,
                            phoneNumber = value,
                            callAction = false))
}