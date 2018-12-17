package com.chrynan.androidsearch.ui.view

interface SearchQuerySettingsView {

    fun updateWebViewChecked(checked: Boolean)

    fun updateChromeCustomTabsChecked(checked: Boolean)

    fun updateBrowserChecked(checked: Boolean)

    fun updateBingChecked(checked: Boolean)

    fun updateContextualWebSearchChecked(checked: Boolean)

    fun updateDuckDuckGoChecked(checked: Boolean)

    fun updateGoogleChecked(checked: Boolean)

    fun updateCustomChecked(checked: Boolean)
}