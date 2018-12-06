package com.chrynan.androidsearch.action

import android.content.Context
import javax.inject.Inject

class SearchAction @Inject constructor(
        private val openSearchAppAction: OpenSearchAppAction,
        private val openSearchUrlInBrowserAction: OpenSearchUrlInBrowserAction
) {

    fun perform(context: Context, query: String) {
        openSearchUrlInBrowserAction.perform(context, "https://duckduckgo.com/?q=", query)
    }
}