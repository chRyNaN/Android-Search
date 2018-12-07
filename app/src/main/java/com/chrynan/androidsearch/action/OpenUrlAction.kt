package com.chrynan.androidsearch.action

import android.content.Context
import android.content.Intent
import android.net.Uri
import com.chrynan.androidsearch.model.wrapper.Url
import com.chrynan.androidsearch.util.startIntentIfItExists
import javax.inject.Inject

class OpenUrlAction @Inject constructor() : QueryResultAction<Url> {

    override fun perform(context: Context, item: Url): Boolean {
        val formattedUrl = if (item.value.startsWith("http://") or item.value.startsWith("https://")) item.value else "https://${item.value}"
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(formattedUrl))

        return context.startIntentIfItExists(intent)
    }
}