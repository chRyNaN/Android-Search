package com.chrynan.androidsearch.action

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import com.chrynan.androidsearch.formatter.QueryUrlFormatter
import com.chrynan.androidsearch.model.wrapper.Query
import com.chrynan.androidsearch.preference.SearchPreferences
import com.chrynan.androidsearch.util.startIntentIfItExists
import javax.inject.Inject

class OpenSearchUrlInBrowserAction @Inject constructor(
        private val searchPreferences: SearchPreferences,
        private val queryUrlFormatter: QueryUrlFormatter
) : QueryResultAction<Query> {

    override fun perform(context: Context, item: Query): Boolean {
        val formattedUrl = queryUrlFormatter.format(searchPreferences.webUrl)

        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(formattedUrl + item.value)).apply {
            putExtra(SearchManager.QUERY, item.value)
        }

        return context.startIntentIfItExists(intent)
    }
}