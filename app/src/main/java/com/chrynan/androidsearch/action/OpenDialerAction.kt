package com.chrynan.androidsearch.action

import android.content.Context
import android.content.Intent
import android.net.Uri
import com.chrynan.androidsearch.util.startIntentIfItExists


class OpenDialerAction {

    fun perform(context: Context, phoneNumber: String): Boolean {
        val intent = Intent(Intent.ACTION_DIAL).apply {
            data = Uri.parse("tel:$phoneNumber")
        }

        return context.startIntentIfItExists(intent)
    }
}