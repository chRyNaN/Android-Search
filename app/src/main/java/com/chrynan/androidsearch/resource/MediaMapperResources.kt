package com.chrynan.androidsearch.resource

import com.chrynan.androidsearch.R
import com.chrynan.androidsearch.util.AppContext
import javax.inject.Inject

class MediaMapperResources @Inject constructor(appContext: AppContext) : ResourceProvider(appContext) {

    val filesDescription by lazy { descriptionFormatter(string(R.string.auto_complete_description_title_files).value) }
    val musicDescription by lazy { descriptionFormatter(string(R.string.auto_complete_description_title_music).value) }
    val moviesDescription by lazy { descriptionFormatter(string(R.string.auto_complete_description_title_movies).value) }
    val picturesDescription by lazy { descriptionFormatter(string(R.string.auto_complete_description_title_pictures).value) }

    private val descriptionFormatter by formattedString<String>(R.string.auto_complete_description)
}