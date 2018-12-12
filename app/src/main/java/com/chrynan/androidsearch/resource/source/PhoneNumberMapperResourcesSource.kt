package com.chrynan.androidsearch.resource.source

import com.chrynan.androidsearch.R
import com.chrynan.androidsearch.resource.PhoneNumberMapperResources
import com.chrynan.androidsearch.resource.ResourceProvider
import com.chrynan.androidsearch.util.AppContext
import javax.inject.Inject

class PhoneNumberMapperResourcesSource @Inject constructor(appContext: AppContext) : ResourceProvider(appContext),
        PhoneNumberMapperResources {

    override val phoneDescription by string(R.string.auto_complete_description_phone_number)
    override val smsDescription by string(R.string.auto_complete_description_sms)
}