package com.chrynan.androidsearch.action

import android.content.Context
import android.content.Intent
import android.net.Uri
import com.chrynan.androidsearch.util.startIntentIfItExists
import java.net.URLConnection


class OpenFileAction {

    fun perform(context: Context, fileLocation: String): Boolean {
        val intent = Intent(Intent.ACTION_VIEW).apply {
            setDataAndType(Uri.parse(fileLocation), URLConnection.guessContentTypeFromName(fileLocation))
        }

        return context.startIntentIfItExists(intent)
    }
}