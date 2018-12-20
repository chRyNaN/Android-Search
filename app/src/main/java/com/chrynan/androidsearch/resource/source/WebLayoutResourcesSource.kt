package com.chrynan.androidsearch.resource.source

import com.chrynan.androidsearch.R
import com.chrynan.androidsearch.resource.ResourceProvider
import com.chrynan.androidsearch.resource.WebLayoutResources
import com.chrynan.androidsearch.util.AppContext
import javax.inject.Inject

class WebLayoutResourcesSource @Inject constructor(appContext: AppContext) : ResourceProvider(appContext),
        WebLayoutResources {

    override val toolbarNavigationIcon by drawable(R.drawable.ic_close)
    override val toolbarSubtitleTextColor by color(R.color.toolbar_subtitle_color)
    override val progressBarHeight by dimenPixelSize(R.dimen.horizontal_progress_bar_height)
    override val progressBarMax by lazy { 100 }
}