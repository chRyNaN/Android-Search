package com.chrynan.androidsearch.resource.source

import com.chrynan.androidsearch.R
import com.chrynan.androidsearch.resource.AppMapperResources
import com.chrynan.androidsearch.resource.ResourceProvider
import com.chrynan.androidsearch.util.AppContext
import javax.inject.Inject

class AppMapperResourcesSource @Inject constructor(appContext: AppContext) : ResourceProvider(appContext),
        AppMapperResources {

    override val appDescription by lazy { descriptionTextFormatter(appDescriptionTitle) }

    private val appDescriptionTitle by string(R.string.auto_complete_description_title_apps)
    private val descriptionTextFormatter by formattedString<String>(R.string.auto_complete_description)
}