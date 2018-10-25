package com.chrynan.androidsearch.presenter

import com.chrynan.androidsearch.preference.SearchPreferences
import com.chrynan.androidsearch.ui.view.SettingsView

class SearchSettingsPresenter(
        private val view: SettingsView,
        private val preferences: SearchPreferences
) : Presenter {

    override fun detachView() {}

    fun getSettings() {
        view.apply {
            updateApplicationsToggle(preferences.apps)
            updateAudioFilesToggle(preferences.audioFiles)
            updateImageFilesToggle(preferences.imageFiles)
            updateVideoFilesToggle(preferences.videoFiles)
            updateContactsToggle(preferences.contacts)
            updateCalendarToggle(preferences.calendar)
            updateTextMessagesToggle(preferences.messages)
            updateEmailToggle(preferences.emailLink)
            updateWebAddressToggle(preferences.webAddressLink)
            updatePhoneNumberToggle(preferences.phoneNumberLink)
            updateInstantAnswerToggle(preferences.instantAnswers)
            updateSuggestionToggle(preferences.typeAhead)
            updateHistoryToggle(preferences.history)
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
                SearchToggleItem.CALENDAR -> preferences.calendar = toggledOn
                SearchToggleItem.MESSAGES -> preferences.messages = toggledOn
                SearchToggleItem.EMAIL -> preferences.emailLink = toggledOn
                SearchToggleItem.URL -> preferences.webAddressLink = toggledOn
                SearchToggleItem.PHONE_NUMBER -> preferences.phoneNumberLink = toggledOn
                SearchToggleItem.INSTANT_ANSWER -> preferences.instantAnswers = toggledOn
                SearchToggleItem.SUGGESTION -> preferences.typeAhead = toggledOn
                SearchToggleItem.HISTORY -> preferences.history = toggledOn
            }

    fun toggleSearchApproach(item: SearchCheckedItem, toggledOn: Boolean) =
            when (item) {
                SearchCheckedItem.APP -> preferences.searchApp = toggledOn
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
        CALENDAR,
        MESSAGES,
        EMAIL,
        URL,
        PHONE_NUMBER,
        INSTANT_ANSWER,
        SUGGESTION,
        HISTORY
    }

    enum class SearchCheckedItem {

        APP,
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