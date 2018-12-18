package com.chrynan.androidsearch.resource.source

import com.chrynan.androidsearch.R
import com.chrynan.androidsearch.resource.AdapterAutoCompleteResources
import com.chrynan.androidsearch.resource.ResourceProvider
import com.chrynan.androidsearch.util.AppContext
import com.chrynan.androidsearch.util.selectableBackgroundDrawableResId
import com.chrynan.inlinepixel.px
import javax.inject.Inject

class AdapterAutoCompleteResourcesSource @Inject constructor(appContext: AppContext) : ResourceProvider(appContext),
        AdapterAutoCompleteResources {

    override val horizontalParentPadding by dimenPixelOffset(R.dimen.default_screen_margin)
    override val verticalParentPadding by dimenPixelOffset(R.dimen.spacing_small)
    override val titleTextHorizontalMargin by dimenPixelOffset(R.dimen.spacing_small)
    override val titleTextSize by lazy { px(dimen(R.dimen.auto_complete_adapter_title_text_size).value).toSp().value.toFloat() }
    override val titleTextColor by color(R.color.auto_complete_adapter_title_text_color)
    override val descriptionTextSize by lazy { px(dimen(R.dimen.auto_complete_adapter_description_text_size).value).toSp().value.toFloat() }
    override val descriptionTextColor by color(R.color.auto_complete_adapter_description_text_color)
    override val iconSize by dimenPixelOffset(R.dimen.app_list_item_icon_size)
    override val parentBackgroundId by lazy { appContext.selectableBackgroundDrawableResId }
    override val cellMinHeight by dimenPixelOffset(R.dimen.cell_min_height)
}