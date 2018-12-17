package com.chrynan.androidsearch.presenter

import com.chrynan.androidsearch.model.QueryUrls
import com.chrynan.androidsearch.model.toggle.SearchCheckedItem
import com.chrynan.androidsearch.model.toggle.SearchUrlCheckedItem
import com.chrynan.androidsearch.preference.SearchPreferences
import com.chrynan.androidsearch.ui.view.SearchQuerySettingsView
import com.chrynan.kotlinutils.perform
import javax.inject.Inject

class SearchQuerySettingsPresenter @Inject constructor(
        private val view: SearchQuerySettingsView,
        private val preferences: SearchPreferences
) : CoroutinePresenter() {

    fun getSettings() =
            view.perform {
                updateBrowserChecked(preferences.browser)
                updateChromeCustomTabsChecked(preferences.chromeCustomTab)
                updateWebViewChecked(preferences.webView)

                when (preferences.webUrl) {
                    QueryUrls.BING -> setUrlCheckedItem(SearchUrlCheckedItem.BING)
                    QueryUrls.CONTEXTUAL_WEB_SEARCH -> setUrlCheckedItem(SearchUrlCheckedItem.CONTEXTUAL_WEB_SEARCH)
                    QueryUrls.DUCK_DUCK_GO -> setUrlCheckedItem(SearchUrlCheckedItem.DUCK_DUCK_GO)
                    QueryUrls.GOOGLE -> setUrlCheckedItem(SearchUrlCheckedItem.GOOGLE)
                    else -> setUrlCheckedItem(SearchUrlCheckedItem.CUSTOM)
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
            SearchUrlCheckedItem.BING -> preferences.webUrl = QueryUrls.BING
            SearchUrlCheckedItem.CONTEXTUAL_WEB_SEARCH -> QueryUrls.CONTEXTUAL_WEB_SEARCH
            SearchUrlCheckedItem.DUCK_DUCK_GO -> preferences.webUrl = QueryUrls.DUCK_DUCK_GO
            SearchUrlCheckedItem.GOOGLE -> preferences.webUrl = QueryUrls.GOOGLE
            else -> preferences.webUrl = ""
        }
    }

    private fun setUrlCheckedItem(item: SearchUrlCheckedItem) = view.perform {
        updateBingChecked(item == SearchUrlCheckedItem.BING)
        updateContextualWebSearchChecked(item == SearchUrlCheckedItem.CONTEXTUAL_WEB_SEARCH)
        updateDuckDuckGoChecked(item == SearchUrlCheckedItem.DUCK_DUCK_GO)
        updateGoogleChecked(item == SearchUrlCheckedItem.GOOGLE)
        updateCustomChecked(item == SearchUrlCheckedItem.CUSTOM)
    }
}