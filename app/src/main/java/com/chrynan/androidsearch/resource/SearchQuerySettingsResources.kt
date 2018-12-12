package com.chrynan.androidsearch.resource

import com.chrynan.androidsearch.R
import com.chrynan.androidsearch.di.scope.LayoutScope
import com.chrynan.androidsearch.util.AppContext
import javax.inject.Inject

@LayoutScope
class SearchQuerySettingsResources @Inject constructor(appContext: AppContext) : ResourceProvider(appContext) {

    val webTitleText by string(R.string.settings_radio_button_title_web_view)
    val chromeCustomTabsTitleText by string(R.string.settings_radio_button_title_chrome_custom_tabs)
    val browserTitleText by string(R.string.settings_radio_button_title_browser_app)
    val bingTitleText by string(R.string.settings_radio_button_title_bing)
    val contextualWebSearchTitleText by string(R.string.settings_radio_button_title_contextual_web_search)
    val duckDuckGoTitleText by string(R.string.settings_radio_button_title_duck_duck_go)
    val googleTitleText by string(R.string.settings_radio_button_title_google)
    val customTitleText by string(R.string.settings_radio_button_title_custom)
    val customUrlHint by string(R.string.settings_custom_url_hint)
}