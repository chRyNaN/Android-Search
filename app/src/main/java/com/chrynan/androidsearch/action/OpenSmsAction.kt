package com.chrynan.androidsearch.action

import android.content.Context
import android.content.Intent
import android.net.Uri
import com.chrynan.androidsearch.util.startIntentIfItExists
import javax.inject.Inject

class OpenSmsAction @Inject constructor() {

    fun perform(context: Context, phoneNumber: String): Boolean {
        val intent = Intent(Intent.ACTION_VIEW).apply {
            data = Uri.parse("sms:$phoneNumber")
        }

        return context.startIntentIfItExists(intent)
    }
}