package com.chrynan.androidsearch.action

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import com.chrynan.androidsearch.model.wrapper.Query
import com.chrynan.androidsearch.util.startIntentIfItExists
import javax.inject.Inject

class OpenSearchAppAction @Inject constructor() : QueryResultAction<Query> {

    override fun perform(context: Context, item: Query): Boolean {
        val intent = Intent(Intent.ACTION_WEB_SEARCH).apply {
            putExtra(SearchManager.QUERY, item.value)
        }

        return context.startIntentIfItExists(intent)
    }
}