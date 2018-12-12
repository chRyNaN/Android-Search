package com.chrynan.androidsearch.resource

import com.chrynan.androidsearch.R
import com.chrynan.androidsearch.util.AppContext
import javax.inject.Inject

class AppMapperResources @Inject constructor(appContext: AppContext) : ResourceProvider(appContext) {

    val descriptionTextFormatter by formattedString<String>(R.string.auto_complete_description)
    val appDescription by lazy { descriptionTextFormatter(appDescriptionTitle) }

    private val appDescriptionTitle by string(R.string.auto_complete_description_title_apps)
}