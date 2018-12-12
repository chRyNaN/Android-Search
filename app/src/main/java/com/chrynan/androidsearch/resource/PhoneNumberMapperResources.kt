package com.chrynan.androidsearch.resource

import com.chrynan.androidsearch.R
import com.chrynan.androidsearch.util.AppContext
import javax.inject.Inject

class PhoneNumberMapperResources @Inject constructor(appContext: AppContext) : ResourceProvider(appContext) {

    val phoneDescription by string(R.string.auto_complete_description_phone_number)
    val smsDescription by string(R.string.auto_complete_description_sms)
}