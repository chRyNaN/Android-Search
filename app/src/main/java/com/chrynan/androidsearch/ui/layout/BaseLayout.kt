package com.chrynan.androidsearch.ui.layout

import android.content.Context
import com.chrynan.androidviews.layout.AndroidLayout
import com.chrynan.inlinepixel.ContextScreenDimensionUnitConverter
import com.chrynan.inlinepixel.ScreenDimensionUnitConverter

abstract class BaseLayout(context: Context) : AndroidLayout,
        ScreenDimensionUnitConverter by ContextScreenDimensionUnitConverter(context) {

    override fun onBeforeCreateLayout() {
        setupDependencies()
    }

    abstract fun setupDependencies()
}