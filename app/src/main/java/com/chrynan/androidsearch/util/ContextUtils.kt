package com.chrynan.androidsearch.util

import android.content.Context
import android.content.Intent

fun Context.startIntentIfItExists(intent: Intent): Boolean {
    if (intent.resolveActivity(packageManager) != null) {
        startActivity(intent)
        return true
    }

    return false
}