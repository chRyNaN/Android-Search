package com.chrynan.androidsearch.ui.widget

import android.view.ViewGroup
import com.chrynan.androidsearch.R
import com.chrynan.androidviews.builder.LayoutBuilder
import com.chrynan.androidviews.builder.view

fun <V : ViewGroup, P : ViewGroup.LayoutParams> LayoutBuilder<V, P>.divider() =
        view {
            setBackgroundColor(context.resources.getColor(R.color.divider_color, context.theme))
            layoutParams {
                width = ViewGroup.LayoutParams.MATCH_PARENT
                height = 2
            }
        }