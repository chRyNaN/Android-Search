package com.chrynan.androidsearch.presenter

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
                updateGeckoViewChecked(preferences.geckoView)
                updateWebViewChecked(preferences.webView)

                val checkedItem = SearchUrlCheckedItem.fromUrl(url = Url(preferences.webUrl))
                setUrlCheckedItem(item = checkedItem)
                if (checkedItem is SearchUrlCheckedItem.Custom) {
                    updateCustomUrl(url = checkedItem.url.value)
                }
            }

    fun toggleSearchApproach(item: SearchCheckedItem) {
        // SearchPreferencesSource already handles toggling off the other items
        when (item) {
            SearchCheckedItem.BROWSER -> preferences.browser = true
            SearchCheckedItem.CHROME_CUSTOM_TAB -> preferences.chromeCustomTab = true
            SearchCheckedItem.GECKO_VIEW -> preferences.geckoView = true
            SearchCheckedItem.WEB_VIEW -> preferences.webView = true
        }
    }

    fun selectSearchUrl(item: SearchUrlCheckedItem) = preferences.perform { webUrl = item.url.value }

    private fun setUrlCheckedItem(item: SearchUrlCheckedItem) = view.perform {
        updateBingChecked(item == SearchUrlCheckedItem.Bing)
        updateContextualWebSearchChecked(item == SearchUrlCheckedItem.ContextualWebSearch)
        updateDuckDuckGoChecked(item == SearchUrlCheckedItem.DuckDuckGo)
        updateGoogleChecked(item == SearchUrlCheckedItem.Google)
        updateCustomChecked(item is SearchUrlCheckedItem.Custom)
    }
}