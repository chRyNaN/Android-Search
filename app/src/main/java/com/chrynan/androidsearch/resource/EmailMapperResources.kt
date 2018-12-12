package com.chrynan.androidsearch.resource

import com.chrynan.androidsearch.R
import com.chrynan.androidsearch.util.AppContext
import javax.inject.Inject

class EmailMapperResources @Inject constructor(appContext: AppContext) : ResourceProvider(appContext) {

    val emailDescription by string(R.string.auto_complete_description_email)
}