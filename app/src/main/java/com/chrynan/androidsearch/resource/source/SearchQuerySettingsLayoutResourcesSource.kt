package com.chrynan.androidsearch.resource.source

import com.chrynan.androidsearch.R
import com.chrynan.androidsearch.di.scope.LayoutScope
import com.chrynan.androidsearch.resource.ResourceProvider
import com.chrynan.androidsearch.resource.SearchQuerySettingsLayoutResources
import com.chrynan.androidsearch.util.AppContext
import javax.inject.Inject

@LayoutScope
class SearchQuerySettingsLayoutResourcesSource @Inject constructor(appContext: AppContext) : ResourceProvider(appContext),
        SearchQuerySettingsLayoutResources {

    override val webTitleText by string(R.string.settings_radio_button_title_web_view)
    override val chromeCustomTabsTitleText by string(R.string.settings_radio_button_title_chrome_custom_tabs)
    override val browserTitleText by string(R.string.settings_radio_button_title_browser_app)
    override val bingTitleText by string(R.string.settings_radio_button_title_bing)
    override val contextualWebSearchTitleText by string(R.string.settings_radio_button_title_contextual_web_search)
    override val duckDuckGoTitleText by string(R.string.settings_radio_button_title_duck_duck_go)
    override val googleTitleText by string(R.string.settings_radio_button_title_google)
    override val customTitleText by string(R.string.settings_radio_button_title_custom)
    override val customUrlHint by string(R.string.settings_custom_url_hint)
}