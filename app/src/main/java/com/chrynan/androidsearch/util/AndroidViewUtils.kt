package com.chrynan.androidsearch.util

import android.graphics.drawable.Drawable
import android.os.Build
import android.support.v4.view.ViewCompat
import android.text.Editable
import android.text.Html
import android.text.TextWatcher
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import kotlinx.coroutines.experimental.*

fun EditText.onTextChanged(debounceTimeInMilliseconds: Long = 200, asyncBlock: suspend CoroutineScope.(String?) -> Unit): Cancellable {
    var lastTextChangeTime = 0L
    var lastJob: Job? = null

    val textWatcher = object : TextWatcher {

        override fun afterTextChanged(s: Editable?) {}

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            runInBackground {
                val currentTime = System.currentTimeMillis()
                lastJob?.cancelAndJoin()
                lastJob = launch {
                    if (currentTime > lastTextChangeTime + debounceTimeInMilliseconds) {
                        lastTextChangeTime = currentTime
                        asyncBlock(s?.toString())
                    } else {
                        val timeDiff = (lastTextChangeTime + debounceTimeInMilliseconds) - currentTime
                        delay(timeDiff)
                        asyncBlock(s?.toString())
                    }
                }
            }
        }
    }

    addTextChangedListener(textWatcher)

    return object : Cancellable {

        override fun cancel() {
            lastJob?.cancel()
            removeTextChangedListener(textWatcher)
        }
    }
}

fun EditText.onEnterAction(block: suspend CoroutineScope.(String?) -> Unit) {
    setOnEditorActionListener { _, actionId, event ->
        if (actionId == EditorInfo.IME_ACTION_DONE || event?.keyCode == KeyEvent.KEYCODE_ENTER) {
            runOnAndroidUI { block(text?.toString()) }
            return@setOnEditorActionListener true
        }

        false
    }
}

fun ImageView.loadImageAsync(accessor: () -> Drawable) = runInBackground {
    val result = async { accessor() }.await()
    runOnAndroidUI { setImageDrawable(result) }
}

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
