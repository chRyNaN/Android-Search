package com.chrynan.androidsearch.ui.view

interface SearchQuerySettingsView {

    fun updateBrowserChecked(checked: Boolean)

    fun updateGeckoViewChecked(checked: Boolean)

    fun updateWebViewChecked(checked: Boolean)

    fun updateBingChecked(checked: Boolean)

    fun updateContextualWebSearchChecked(checked: Boolean)

    fun updateDuckDuckGoChecked(checked: Boolean)

    fun updateGoogleChecked(checked: Boolean)

    fun updateCustomChecked(checked: Boolean)

    fun updateCustomUrl(url: String?)
}