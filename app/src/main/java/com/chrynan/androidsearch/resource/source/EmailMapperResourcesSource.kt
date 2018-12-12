package com.chrynan.androidsearch.resource.source

import com.chrynan.androidsearch.R
import com.chrynan.androidsearch.resource.EmailMapperResources
import com.chrynan.androidsearch.resource.ResourceProvider
import com.chrynan.androidsearch.util.AppContext
import javax.inject.Inject

class EmailMapperResourcesSource @Inject constructor(appContext: AppContext) : ResourceProvider(appContext),
        EmailMapperResources {

    override val emailDescription by string(R.string.auto_complete_description_email)
}