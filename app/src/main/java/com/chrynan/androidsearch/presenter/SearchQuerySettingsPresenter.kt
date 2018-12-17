package com.chrynan.androidsearch.presenter

import com.chrynan.androidsearch.model.toggle.SearchCheckedItem
import com.chrynan.androidsearch.model.toggle.SearchUrlCheckedItem
import com.chrynan.androidsearch.preference.SearchPreferences
import javax.inject.Inject

class SearchQuerySettingsPresenter @Inject constructor(private val preferences: SearchPreferences) : CoroutinePresenter() {

    fun toggleSearchApproach(item: SearchCheckedItem, toggledOn: Boolean) =
            when (item) {
                SearchCheckedItem.WEB_VIEW -> preferences.webView = toggledOn
                SearchCheckedItem.CHROME_CUSTOM_TAB -> preferences.chromeCustomTab = toggledOn
                SearchCheckedItem.BROWSER -> preferences.browser = toggledOn
            }

    fun selectSearchUrl(item: SearchUrlCheckedItem, toggledOn: Boolean) {
        // TODO
    }
}