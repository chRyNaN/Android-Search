package com.chrynan.androidsearch.action

import android.content.Context
import com.chrynan.androidsearch.model.wrapper.Query
import javax.inject.Inject

class SearchAction @Inject constructor(
        private val openSearchAppAction: OpenSearchAppAction,
        private val openSearchUrlInBrowserAction: OpenSearchUrlInBrowserAction
) : QueryResultAction<Query> {

    override fun perform(context: Context, item: Query) =
            openSearchUrlInBrowserAction.perform(context, Query("https://duckduckgo.com/?q=${item.value}"))
}