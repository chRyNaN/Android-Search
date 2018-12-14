package com.chrynan.androidsearch.resource.source

import com.chrynan.androidsearch.R
import com.chrynan.androidsearch.resource.AdapterAutoCompleteResources
import com.chrynan.androidsearch.resource.ResourceProvider
import com.chrynan.androidsearch.util.AppContext
import javax.inject.Inject

class AdapterAutoCompleteResourcesSource @Inject constructor(appContext: AppContext) : ResourceProvider(appContext),
        AdapterAutoCompleteResources {

    override val horizontalParentPadding by dimenPixelOffset(R.dimen.default_screen_margin)
    override val verticalParentPadding by dimenPixelOffset(R.dimen.spacing_small)
    override val titleTextStartMargin by dimenPixelOffset(R.dimen.spacing_small)
    override val iconSize by dimenPixelOffset(R.dimen.app_list_item_icon_size)
    override val parentBackground by drawable(android.R.drawable.list_selector_background)
}