package com.chrynan.androidsearch.action

import android.content.Context
import javax.inject.Inject

class OpenAppAction @Inject constructor() {

    fun perform(context: Context, packageName: String): Boolean {
        val intent = context.packageManager.getLaunchIntentForPackage(packageName)

        if (intent != null) {
            context.startActivity(intent)
            return true
        }

        return false
    }
}