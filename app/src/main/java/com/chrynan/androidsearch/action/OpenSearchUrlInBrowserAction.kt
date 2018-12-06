package com.chrynan.androidsearch.action

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import com.chrynan.androidsearch.util.startIntentIfItExists
import javax.inject.Inject

class OpenSearchUrlInBrowserAction @Inject constructor() {

    fun perform(context: Context, url: String, query: String): Boolean {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("$url$query")).apply {
            putExtra(SearchManager.QUERY, query)
        }

        return context.startIntentIfItExists(intent)
    }
}