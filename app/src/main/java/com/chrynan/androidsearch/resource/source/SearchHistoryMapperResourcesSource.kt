package com.chrynan.androidsearch.resource.source

import com.chrynan.androidsearch.R
import com.chrynan.androidsearch.resource.ResourceProvider
import com.chrynan.androidsearch.resource.SearchHistoryMapperResources
import com.chrynan.androidsearch.util.AppContext
import javax.inject.Inject

class SearchHistoryMapperResourcesSource @Inject constructor(appContext: AppContext) : ResourceProvider(appContext),
        SearchHistoryMapperResources {

    override val searchHistoryDescription by lazy { descriptionFormatter(searchHistoryDescriptionTitle) }

    private val descriptionFormatter by formattedString<String>(R.string.auto_complete_description)
    private val searchHistoryDescriptionTitle by string(R.string.auto_complete_description_title_search_history)
}