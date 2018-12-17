package com.chrynan.androidsearch.ui.widget

import android.util.TypedValue
import android.widget.LinearLayout
import com.chrynan.androidsearch.R
import com.chrynan.androidviews.builder.LayoutBuilder
import com.chrynan.androidviews.builder.textView

fun <V : LinearLayout, P : LinearLayout.LayoutParams> LayoutBuilder<V, P>.label(labelText: String) =
        textView {
            text = labelText
            setTextColor(context.resources.getColor(R.color.label_text_color, context.theme))
            setTextSize(TypedValue.COMPLEX_UNIT_PX, context.resources.getDimension(R.dimen.label_text_size))
            layoutParams {
                width = LinearLayout.LayoutParams.MATCH_PARENT
                height = LinearLayout.LayoutParams.WRAP_CONTENT
                val horizontalMargin = context.resources.getDimensionPixelOffset(R.dimen.label_margin_horizontal)
                val verticalMargin = context.resources.getDimensionPixelOffset(R.dimen.label_margin_vertical)
                setMargins(horizontalMargin, verticalMargin, horizontalMargin, verticalMargin)
            }
        }