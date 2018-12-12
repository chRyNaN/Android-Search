package com.chrynan.androidsearch.resource.source

import com.chrynan.androidsearch.R
import com.chrynan.androidsearch.di.scope.ActivityScope
import com.chrynan.androidsearch.resource.ResourceProvider
import com.chrynan.androidsearch.resource.SearchLayoutResources
import com.chrynan.androidsearch.util.AppContext
import javax.inject.Inject

@ActivityScope
class SearchLayoutResourcesSource @Inject constructor(appContext: AppContext) : ResourceProvider(appContext),
        SearchLayoutResources {

    override val backgroundColor by color(R.color.search_background_color)
    override val hintText by string(R.string.search_hint)
    override val searchBoxMargin by dimenPixelOffset(R.dimen.spacing_xsmall)
    override val searchBoxPadding by dimenPixelOffset(R.dimen.spacing_small)
    override val transparentColor by color(android.R.color.transparent)
    override val settingsDrawable by drawable(R.drawable.ic_settings)
}