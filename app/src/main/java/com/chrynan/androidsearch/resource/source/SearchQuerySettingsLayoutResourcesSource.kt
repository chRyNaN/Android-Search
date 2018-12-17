package com.chrynan.androidsearch.resource.source

import com.chrynan.androidsearch.R
import com.chrynan.androidsearch.di.scope.ActivityScope
import com.chrynan.androidsearch.resource.ResourceProvider
import com.chrynan.androidsearch.resource.SearchQuerySettingsLayoutResources
import com.chrynan.androidsearch.util.AppContext
import com.chrynan.inlinepixel.px
import javax.inject.Inject

@ActivityScope
class SearchQuerySettingsLayoutResourcesSource @Inject constructor(appContext: AppContext) : ResourceProvider(appContext),
        SearchQuerySettingsLayoutResources {

    override val toolbarTitle by string(R.string.search_approach_toolbar_title)
    override val toolbarNavigationIcon by drawable(R.drawable.ic_back)
    override val searchMethodLabel by string(R.string.search_approach_label_method)
    override val searchAddressLabel by string(R.string.search_approach_label_address)
    override val webTitleText by string(R.string.settings_radio_button_title_web_view)
    override val chromeCustomTabsTitleText by string(R.string.settings_radio_button_title_chrome_custom_tabs)
    override val browserTitleText by string(R.string.settings_radio_button_title_browser_app)
    override val bingTitleText by string(R.string.settings_radio_button_title_bing)
    override val contextualWebSearchTitleText by string(R.string.settings_radio_button_title_contextual_web_search)
    override val duckDuckGoTitleText by string(R.string.settings_radio_button_title_duck_duck_go)
    override val googleTitleText by string(R.string.settings_radio_button_title_google)
    override val customTitleText by string(R.string.settings_radio_button_title_custom)
    override val customUrlHint by string(R.string.settings_custom_url_hint)
    override val customUrlHorizontalPadding by dimenPixelOffset(R.dimen.custom_url_horizontal_margin)
    override val customUrlVerticalPadding by dimenPixelOffset(R.dimen.custom_url_vertical_margin)
    override val customUrlTextColor by color(R.color.custom_url_text_color)
    override val customUrlTextSize by lazy { px(dimen(R.dimen.custom_url_text_size).value).toSp().value.toFloat() }
}