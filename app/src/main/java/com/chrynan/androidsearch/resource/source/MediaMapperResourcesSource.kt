package com.chrynan.androidsearch.resource.source

import com.chrynan.androidsearch.R
import com.chrynan.androidsearch.resource.MediaMapperResources
import com.chrynan.androidsearch.resource.ResourceProvider
import com.chrynan.androidsearch.util.AppContext
import javax.inject.Inject

class MediaMapperResourcesSource @Inject constructor(appContext: AppContext) : ResourceProvider(appContext),
        MediaMapperResources {

    override val filesDescription by lazy { descriptionFormatter(string(R.string.auto_complete_description_title_files).value) }
    override val musicDescription by lazy { descriptionFormatter(string(R.string.auto_complete_description_title_music).value) }
    override val moviesDescription by lazy { descriptionFormatter(string(R.string.auto_complete_description_title_movies).value) }
    override val picturesDescription by lazy { descriptionFormatter(string(R.string.auto_complete_description_title_pictures).value) }

    private val descriptionFormatter by formattedString<String>(R.string.auto_complete_description)
}