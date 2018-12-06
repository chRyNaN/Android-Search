package com.chrynan.androidsearch.ui.layout

import android.content.Context
import com.chrynan.androidviews.builder.LayoutBuilder
import com.chrynan.androidviews.layout.AndroidLayout

abstract class BaseLayout : AndroidLayout {

    override fun onCreateLayout(context: Context): LayoutBuilder<*, *> {
        setupDependencies()
        return layout(context)
    }

    abstract fun layout(context: Context): LayoutBuilder<*, *>

    abstract fun setupDependencies()
}