package com.chrynan.androidsearch.action

import android.content.Context
import android.content.Intent
import android.net.Uri
import com.chrynan.androidsearch.util.startIntentIfItExists
import javax.inject.Inject

class OpenUrlAction @Inject constructor() {

    fun perform(context: Context, url: String): Boolean {
        val formattedUrl = if (url.startsWith("http://") or url.startsWith("https://")) url else "https://$url"
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(formattedUrl))

        return context.startIntentIfItExists(intent)
    }
}