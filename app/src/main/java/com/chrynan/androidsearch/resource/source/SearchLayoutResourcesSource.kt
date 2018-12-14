package com.chrynan.androidsearch.resource.source

import com.chrynan.androidsearch.R
import com.chrynan.androidsearch.di.scope.ActivityScope
import com.chrynan.androidsearch.resource.ResourceProvider
import com.chrynan.androidsearch.resource.SearchLayoutResources
import com.chrynan.androidsearch.util.AppContext
import com.chrynan.inlinepixel.px
import javax.inject.Inject

@ActivityScope
class SearchLayoutResourcesSource @Inject constructor(appContext: AppContext) : ResourceProvider(appContext),
        SearchLayoutResources {

    override val backgroundColor by color(R.color.search_layout_background_color)
    override val hintText by string(R.string.search_widget_hint)
    override val transparentColor by color(android.R.color.transparent)
    override val settingsDrawable by drawable(R.drawable.ic_settings)
    override val searchWidgetMargin by dimenPixelOffset(R.dimen.spacing_xsmall)
    override val searchWidgetHorizontalPadding by dimenPixelOffset(R.dimen.search_widget_horizontal_padding)
    override val searchWidgetVerticalPadding by dimenPixelOffset(R.dimen.search_widget_vertical_padding)
    override val searchWidgetElevation by dimen(R.dimen.search_widget_in_app_elevation)
    override val searchWidgetMaxLines = 1
    override val searchWidgetTextSize by lazy { px(dimen(R.dimen.search_widget_text_size).value).toSp().value.toFloat() }
    override val searchWidgetTextColor by color(R.color.search_widget_text_color)
    override val searchWidgetHintColor by color(R.color.search_widget_hint_color)
    override val searchWidgetTransitionName by string(R.string.search_widget_transition_name)
}