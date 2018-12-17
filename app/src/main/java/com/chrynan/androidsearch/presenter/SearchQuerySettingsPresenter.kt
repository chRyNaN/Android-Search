package com.chrynan.androidsearch.presenter

import com.chrynan.androidsearch.model.QueryUrls
import com.chrynan.androidsearch.model.toggle.SearchCheckedItem
import com.chrynan.androidsearch.model.toggle.SearchUrlCheckedItem
import com.chrynan.androidsearch.model.wrapper.Url
import com.chrynan.androidsearch.preference.SearchPreferences
import com.chrynan.androidsearch.ui.view.SearchQuerySettingsView
import com.chrynan.kotlinutils.perform
import javax.inject.Inject

class SearchQuerySettingsPresenter @Inject constructor(
        private val view: SearchQuerySettingsView,
        private val preferences: SearchPreferences
) : CoroutinePresenter() {

    val currentUrl: Url
        get() = Url(preferences.webUrl)

    fun getSettings() =
            view.perform {
                updateBrowserChecked(preferences.browser)
                updateChromeCustomTabsChecked(preferences.chromeCustomTab)
                updateWebViewChecked(preferences.webView)

                when (preferences.webUrl) {
                    QueryUrls.BING -> setUrlCheckedItem(SearchUrlCheckedItem.Bing)
                    QueryUrls.CONTEXTUAL_WEB_SEARCH -> setUrlCheckedItem(SearchUrlCheckedItem.ContextualWebSearch)
                    QueryUrls.DUCK_DUCK_GO -> setUrlCheckedItem(SearchUrlCheckedItem.DuckDuckGo)
                    QueryUrls.GOOGLE -> setUrlCheckedItem(SearchUrlCheckedItem.Google)
                    else -> {
                        setUrlCheckedItem(SearchUrlCheckedItem.Custom(Url(preferences.webUrl)))
                        updateCustomUrl(preferences.webUrl)
                    }
                }
            }

    fun toggleSearchApproach(item: SearchCheckedItem) {
        // SearchPreferencesSource already handles toggling off the other items
        when (item) {
            SearchCheckedItem.WEB_VIEW -> preferences.webView = true
            SearchCheckedItem.CHROME_CUSTOM_TAB -> preferences.chromeCustomTab = true
            SearchCheckedItem.BROWSER -> preferences.browser = true
        }
    }

    fun selectSearchUrl(item: SearchUrlCheckedItem) {
        when (item) {
            SearchUrlCheckedItem.Bing -> preferences.webUrl = QueryUrls.BING
            SearchUrlCheckedItem.ContextualWebSearch -> QueryUrls.CONTEXTUAL_WEB_SEARCH
            SearchUrlCheckedItem.DuckDuckGo -> preferences.webUrl = QueryUrls.DUCK_DUCK_GO
            SearchUrlCheckedItem.Google -> preferences.webUrl = QueryUrls.GOOGLE
            is SearchUrlCheckedItem.Custom -> preferences.webUrl = item.url.value
        }
    }

    private fun setUrlCheckedItem(item: SearchUrlCheckedItem) = view.perform {
        updateBingChecked(item == SearchUrlCheckedItem.Bing)
        updateContextualWebSearchChecked(item == SearchUrlCheckedItem.ContextualWebSearch)
        updateDuckDuckGoChecked(item == SearchUrlCheckedItem.DuckDuckGo)
        updateGoogleChecked(item == SearchUrlCheckedItem.Google)
        updateCustomChecked(item is SearchUrlCheckedItem.Custom)
    }
}