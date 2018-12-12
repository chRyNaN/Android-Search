package com.chrynan.androidsearch.resource

import com.chrynan.androidsearch.R
import com.chrynan.androidsearch.util.AppContext
import javax.inject.Inject

class WebAddressMapperResources @Inject constructor(appContext: AppContext) : ResourceProvider(appContext) {

    val urlDescription by string(R.string.auto_complete_description_web_address)
}