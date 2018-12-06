package com.chrynan.androidsearch.action

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import com.chrynan.androidsearch.util.startIntentIfItExists
import javax.inject.Inject

class OpenSearchAppAction @Inject constructor() {

    fun perform(context: Context, query: String): Boolean {
        val intent = Intent(Intent.ACTION_WEB_SEARCH).apply {
            putExtra(SearchManager.QUERY, query)
        }

        return context.startIntentIfItExists(intent)
    }
}