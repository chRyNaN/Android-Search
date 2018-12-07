package com.chrynan.androidsearch.action

import android.content.Context

interface QueryResultAction<T : Any> {

    fun perform(context: Context, item: T): Boolean
}