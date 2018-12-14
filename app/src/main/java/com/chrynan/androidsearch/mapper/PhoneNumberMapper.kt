package com.chrynan.androidsearch.mapper

import com.chrynan.androidsearch.R
import com.chrynan.androidsearch.model.wrapper.PhoneNumber
import com.chrynan.androidsearch.resource.PhoneNumberMapperResources
import com.chrynan.androidsearch.resource.source.PhoneNumberMapperResourcesSource
import com.chrynan.androidsearch.viewmodel.AutoCompleteResultViewModel
import com.chrynan.mapper.UniDirectionalMapper
import javax.inject.Inject

class PhoneNumberMapper @Inject constructor(res: PhoneNumberMapperResourcesSource) : UniDirectionalMapper<String, List<AutoCompleteResultViewModel.PhoneNumber>>,
        PhoneNumberMapperResources by res {

    override fun map(value: String) =
            listOf(
                    AutoCompleteResultViewModel.PhoneNumber(
                            title = value,
                            description = phoneDescription,
                            defaultIconResId = R.drawable.ic_adapter_phone,
                            iconFetcher = null,
                            actionIcon = null,
                            phoneNumber = PhoneNumber(value),
                            callAction = true),
                    AutoCompleteResultViewModel.PhoneNumber(
                            title = value,
                            description = smsDescription,
                            defaultIconResId = R.drawable.ic_adapter_text,
                            iconFetcher = null,
                            actionIcon = null,
                            phoneNumber = PhoneNumber(value),
                            callAction = false))
}