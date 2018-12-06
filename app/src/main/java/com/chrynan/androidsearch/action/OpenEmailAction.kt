package com.chrynan.androidsearch.action

import android.content.Context
import android.content.Intent
import android.net.Uri
import com.chrynan.androidsearch.util.startIntentIfItExists
import javax.inject.Inject


class OpenEmailAction @Inject constructor() {

    fun perform(context: Context, email: String): Boolean {
        val intent = Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:$email"))

        return context.startIntentIfItExists(intent)
    }
}