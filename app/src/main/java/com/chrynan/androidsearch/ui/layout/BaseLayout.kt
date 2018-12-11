package com.chrynan.androidsearch.ui.layout

import com.chrynan.androidsearch.util.AppContext
import com.chrynan.androidviews.layout.AndroidLayout
import com.chrynan.inlinepixel.ContextScreenDimensionUnitConverter
import com.chrynan.inlinepixel.ScreenDimensionUnitConverter

abstract class BaseLayout(context: AppContext) : AndroidLayout,
        ScreenDimensionUnitConverter by ContextScreenDimensionUnitConverter(context) {

    override fun onBeforeCreateLayout() {
        setupDependencies()
    }

    protected open fun setupDependencies() {}
}