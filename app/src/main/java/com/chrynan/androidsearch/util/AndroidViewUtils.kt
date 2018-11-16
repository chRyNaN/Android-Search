package com.chrynan.androidsearch.util

import android.os.Build
import android.support.v4.view.ViewCompat
import android.text.Html
import android.view.View
import android.widget.TextView

inline fun View.doOnLayout(crossinline action: View.() -> Unit) {
    if (ViewCompat.isLaidOut(this) && !isLayoutRequested) {
        action(this)
    } else {
        addOnLayoutChangeListener(object : View.OnLayoutChangeListener {
            override fun onLayoutChange(view: View, left: Int, top: Int, right: Int, bottom: Int, oldLeft: Int, oldTop: Int, oldRight: Int, oldBottom: Int) {
                view.removeOnLayoutChangeListener(this)
                action(view)
            }
        })
    }
}

var View.isVisible: Boolean
    get() = visibility == View.VISIBLE
    set(value) {
        visibility = if (value) View.VISIBLE else View.GONE
    }

@Suppress("DEPRECATION")
fun TextView.htmlFormattedText(htmlText: String?) {
    text = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        Html.fromHtml(htmlText, Html.FROM_HTML_MODE_COMPACT)
    } else {
        Html.fromHtml(htmlText)
    }
}