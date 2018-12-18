package com.chrynan.androidsearch.util

import android.content.Context
import android.util.TypedValue

val Context.selectableBackgroundDrawableResId: Int
    get() = with(TypedValue()) {
        theme.resolveAttribute(android.R.attr.selectableItemBackground, this, true)
        resourceId
    }