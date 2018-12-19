@file:Suppress("unused")

package com.chrynan.androidsearch.util

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.TypedValue
import android.widget.TextView

const val EMPTY_STRING = ""

val Context.selectableBackgroundDrawableResId: Int
    get() = with(TypedValue()) {
        theme.resolveAttribute(android.R.attr.selectableItemBackground, this, true)
        resourceId
    }

fun TextView.onTextChanged(block: (String) -> Unit) {
    addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {}

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(charSequence: CharSequence?, start: Int, before: Int, count: Int) {
            block(charSequence?.toString() ?: EMPTY_STRING)
        }
    })
}