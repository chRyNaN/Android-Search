package com.chrynan.androidsearch.action

import android.content.Context
import android.content.Intent
import android.net.Uri
import com.chrynan.androidsearch.model.wrapper.FileLocation
import com.chrynan.androidsearch.util.startIntentIfItExists
import java.net.URLConnection
import javax.inject.Inject


class OpenFileAction @Inject constructor() : QueryResultAction<FileLocation> {

    override fun perform(context: Context, item: FileLocation): Boolean {
        val intent = Intent(Intent.ACTION_VIEW).apply {
            setDataAndType(Uri.parse(item.value), URLConnection.guessContentTypeFromName(item.value))
        }

        return context.startIntentIfItExists(intent)
    }
}