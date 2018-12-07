package com.chrynan.androidsearch.action

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import com.chrynan.androidsearch.model.wrapper.Query
import com.chrynan.androidsearch.util.startIntentIfItExists
import javax.inject.Inject

class OpenSearchUrlInBrowserAction @Inject constructor() : QueryResultAction<Query> {

    override fun perform(context: Context, item: Query): Boolean {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(item.value)).apply {
            putExtra(SearchManager.QUERY, item.value)
        }

        return context.startIntentIfItExists(intent)
    }
}