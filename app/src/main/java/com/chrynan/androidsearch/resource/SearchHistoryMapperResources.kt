package com.chrynan.androidsearch.resource

import com.chrynan.androidsearch.R
import com.chrynan.androidsearch.util.AppContext
import javax.inject.Inject

class SearchHistoryMapperResources @Inject constructor(appContext: AppContext) : ResourceProvider(appContext) {

    val searchHistoryDescriptionTitle by string(R.string.auto_complete_description_title_search_history)
    val searchHistoryDescription by lazy { descriptionFormatter(searchHistoryDescriptionTitle) }

    private val descriptionFormatter by formattedString<String>(R.string.auto_complete_description)
}