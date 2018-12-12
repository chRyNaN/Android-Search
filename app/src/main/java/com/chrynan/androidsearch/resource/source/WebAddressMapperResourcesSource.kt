package com.chrynan.androidsearch.resource.source

import com.chrynan.androidsearch.R
import com.chrynan.androidsearch.resource.ResourceProvider
import com.chrynan.androidsearch.resource.WebAddressMapperResources
import com.chrynan.androidsearch.util.AppContext
import javax.inject.Inject

class WebAddressMapperResourcesSource @Inject constructor(appContext: AppContext) : ResourceProvider(appContext),
        WebAddressMapperResources {

    override val urlDescription by string(R.string.auto_complete_description_web_address)
}