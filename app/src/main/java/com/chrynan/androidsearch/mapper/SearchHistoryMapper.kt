package com.chrynan.androidsearch.mapper

import com.chrynan.androidsearch.R
import com.chrynan.androidsearch.model.Search
import com.chrynan.androidsearch.model.wrapper.Query
import com.chrynan.androidsearch.util.AppContext
import com.chrynan.androidsearch.viewmodel.AutoCompleteResultViewModel
import com.chrynan.mapper.UniDirectionalMapper
import javax.inject.Inject

class SearchHistoryMapper @Inject constructor(private val context: AppContext) : UniDirectionalMapper<Search, AutoCompleteResultViewModel.SearchHistory> {

    private val searchHistoryDescriptionTitle by lazy { context.getString(R.string.auto_complete_description_title_search_history) }
    private val descriptionFormatter: (String) -> String = { context.getString(R.string.auto_complete_description, it) }
    private val searchHistoryDescription by lazy { descriptionFormatter(searchHistoryDescriptionTitle) }

    override fun map(value: Search): AutoCompleteResultViewModel.SearchHistory =
            AutoCompleteResultViewModel.SearchHistory(
                    title = value.query,
                    description = searchHistoryDescription,
                    defaultIconResId = 0,
                    iconFetcher = null,
                    actionIcon = null,
                    query = Query(value.query))
}