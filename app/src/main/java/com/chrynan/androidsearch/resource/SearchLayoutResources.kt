package com.chrynan.androidsearch.resource

import com.chrynan.androidsearch.R
import com.chrynan.androidsearch.di.scope.LayoutScope
import com.chrynan.androidsearch.util.AppContext
import javax.inject.Inject

@LayoutScope
class SearchLayoutResources @Inject constructor(appContext: AppContext) : ResourceProvider(appContext) {

    val backgroundColor by color(R.color.search_background_color)
    val hintText by string(R.string.search_hint)
    val searchBoxMargin by dimenPixelOffset(R.dimen.spacing_xsmall)
    val searchBoxPadding by dimenPixelOffset(R.dimen.spacing_small)
    val transparentColor by color(android.R.color.transparent)
    val settingsDrawable by drawable(R.drawable.ic_settings)
}