package com.chrynan.androidsearch.action

import android.content.Context
import android.content.Intent
import android.net.Uri
import com.chrynan.androidsearch.model.wrapper.Email
import com.chrynan.androidsearch.util.startIntentIfItExists
import javax.inject.Inject


class OpenEmailAction @Inject constructor() : QueryResultAction<Email> {

    override fun perform(context: Context, item: Email): Boolean {
        val intent = Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:${item.value}"))

        return context.startIntentIfItExists(intent)
    }
}