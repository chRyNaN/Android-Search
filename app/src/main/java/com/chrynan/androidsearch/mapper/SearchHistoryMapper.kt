package com.chrynan.androidsearch.mapper

import com.chrynan.androidsearch.R
import com.chrynan.androidsearch.model.Search
import com.chrynan.androidsearch.model.wrapper.Query
import com.chrynan.androidsearch.resource.SearchHistoryMapperResources
import com.chrynan.androidsearch.resource.source.SearchHistoryMapperResourcesSource
import com.chrynan.androidsearch.viewmodel.AutoCompleteResultViewModel
import com.chrynan.mapper.UniDirectionalMapper
import javax.inject.Inject

class SearchHistoryMapper @Inject constructor(res: SearchHistoryMapperResourcesSource) : UniDirectionalMapper<Search, AutoCompleteResultViewModel.SearchHistory>,
        SearchHistoryMapperResources by res {

    override fun map(value: Search): AutoCompleteResultViewModel.SearchHistory =
            AutoCompleteResultViewModel.SearchHistory(
                    title = value.query,
                    description = searchHistoryDescription,
                    defaultIconResId = R.drawable.ic_adapter_history,
                    iconFetcher = null,
                    actionIcon = null,
                    query = Query(value.query))
}