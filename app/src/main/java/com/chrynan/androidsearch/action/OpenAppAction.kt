package com.chrynan.androidsearch.action

import android.content.Context
import com.chrynan.androidsearch.model.wrapper.PackageName
import javax.inject.Inject

class OpenAppAction @Inject constructor() : QueryResultAction<PackageName> {

    override fun perform(context: Context, item: PackageName): Boolean {
        val intent = context.packageManager.getLaunchIntentForPackage(item.value)

        if (intent != null) {
            context.startActivity(intent)
            return true
        }

        return false
    }
}