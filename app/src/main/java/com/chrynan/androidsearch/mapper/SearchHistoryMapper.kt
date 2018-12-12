package com.chrynan.androidsearch.mapper

import com.chrynan.androidsearch.model.Search
import com.chrynan.androidsearch.model.wrapper.Query
import com.chrynan.androidsearch.resource.SearchHistoryMapperResources
import com.chrynan.androidsearch.viewmodel.AutoCompleteResultViewModel
import com.chrynan.mapper.UniDirectionalMapper
import javax.inject.Inject

class SearchHistoryMapper @Inject constructor(private val res: SearchHistoryMapperResources) : UniDirectionalMapper<Search, AutoCompleteResultViewModel.SearchHistory> {

    override fun map(value: Search): AutoCompleteResultViewModel.SearchHistory =
            AutoCompleteResultViewModel.SearchHistory(
                    title = value.query,
                    description = res.searchHistoryDescription,
                    defaultIconResId = 0,
                    iconFetcher = null,
                    actionIcon = null,
                    query = Query(value.query))
}