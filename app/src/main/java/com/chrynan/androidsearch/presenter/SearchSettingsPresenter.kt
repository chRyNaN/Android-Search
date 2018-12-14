package com.chrynan.androidsearch.presenter

import android.content.Context
import com.chrynan.androidsearch.R
import com.chrynan.androidsearch.preference.SearchPreferences
import com.chrynan.androidsearch.ui.view.SearchSettingsView
import javax.inject.Inject

class SearchSettingsPresenter @Inject constructor(
        private val context: Context,
        private val view: SearchSettingsView,
        private val preferences: SearchPreferences
) : CoroutinePresenter() {

    private val searchApp by lazy { context.getString(R.string.search_approach_default_app) }
    private val webView by lazy { context.getString(R.string.search_approach_web_view) }
    private val chromeCustomTabs by lazy { context.getString(R.string.search_approach_chrome_custom_tabs) }
    private val browser by lazy { context.getString(R.string.search_approach_browser) }

    override fun detachView() {}

    fun getSettings() {
        view.apply {
            updateApplicationsToggle(preferences.apps)
            updateAudioFilesToggle(preferences.audioFiles)
            updateImageFilesToggle(preferences.imageFiles)
            updateVideoFilesToggle(preferences.videoFiles)
            updateContactsToggle(preferences.contacts)
            updateEmailToggle(preferences.emailLink)
            updateWebAddressToggle(preferences.webAddressLink)
            updatePhoneNumberToggle(preferences.phoneNumberLink)
            updateSuggestionToggle(preferences.typeAhead)
            updateHistoryToggle(preferences.history)
            showSearchApproach(getSearchApproach())
        }
    }

    // TODO need to update to ask for permissions for the fields that require them
    fun toggleSearchItem(item: SearchToggleItem, toggledOn: Boolean) =
            when (item) {
                SearchToggleItem.APPS -> preferences.apps = toggledOn
                SearchToggleItem.AUDIO -> preferences.audioFiles = toggledOn
                SearchToggleItem.IMAGE -> preferences.imageFiles = toggledOn
                SearchToggleItem.VIDEO -> preferences.videoFiles = toggledOn
                SearchToggleItem.CONTACTS -> preferences.contacts = toggledOn
                SearchToggleItem.EMAIL -> preferences.emailLink = toggledOn
                SearchToggleItem.URL -> preferences.webAddressLink = toggledOn
                SearchToggleItem.PHONE_NUMBER -> preferences.phoneNumberLink = toggledOn
                SearchToggleItem.SUGGESTION -> preferences.typeAhead = toggledOn
                SearchToggleItem.HISTORY -> preferences.history = toggledOn
            }

    private fun getSearchApproach(): String? =
            when {
                preferences.webView -> webView
                preferences.chromeCustomTab -> chromeCustomTabs
                preferences.browser -> browser
                else -> null
            }

    fun toggleSearchApproach(item: SearchCheckedItem, toggledOn: Boolean) =
            when (item) {
                SearchCheckedItem.WEB_VIEW -> preferences.webView = toggledOn
                SearchCheckedItem.CHROME_CUSTOM_TAB -> preferences.chromeCustomTab = toggledOn
                SearchCheckedItem.BROWSER -> preferences.browser = toggledOn
            }

    fun selectSearchUrl(item: SearchUrlCheckedItem, toggledOn: Boolean) {
        // TODO
    }

    enum class SearchToggleItem {

        APPS,
        AUDIO,
        IMAGE,
        VIDEO,
        CONTACTS,
        EMAIL,
        URL,
        PHONE_NUMBER,
        SUGGESTION,
        HISTORY
    }

    enum class SearchCheckedItem {

        WEB_VIEW,
        CHROME_CUSTOM_TAB,
        BROWSER
    }

    enum class SearchUrlCheckedItem {

        BING,
        CONTEXTUAL_WEB_SEARCH,
        DUCK_DUCK_GO,
        GOOGLE,
        CUSTOM
    }
}