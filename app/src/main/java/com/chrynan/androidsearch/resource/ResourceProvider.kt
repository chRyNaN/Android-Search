package com.chrynan.androidsearch.resource

import androidx.annotation.StringRes
import com.chrynan.androidsearch.util.AppContext
import com.chrynan.androidsearch.util.StringResourceId

open class ResourceProvider(private val appContext: AppContext) {

    protected fun string(@StringRes resourceId: StringResourceId): Lazy<String> =
            lazy { appContext.getString(resourceId) }
}