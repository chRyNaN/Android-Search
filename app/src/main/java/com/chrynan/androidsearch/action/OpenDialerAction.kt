package com.chrynan.androidsearch.action

import android.content.Context
import android.content.Intent
import android.net.Uri
import com.chrynan.androidsearch.util.startIntentIfItExists
import javax.inject.Inject


class OpenDialerAction @Inject constructor() {

    fun perform(context: Context, phoneNumber: String): Boolean {
        val intent = Intent(Intent.ACTION_DIAL).apply {
            data = Uri.parse("tel:$phoneNumber")
        }

        return context.startIntentIfItExists(intent)
    }
}