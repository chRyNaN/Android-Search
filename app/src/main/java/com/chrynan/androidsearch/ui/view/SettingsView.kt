package com.chrynan.androidsearch.ui.view

interface SettingsView {

    fun updateApplicationsToggle(toggledOn: Boolean)

    fun updateAudioFilesToggle(toggledOn: Boolean)

    fun updateImageFilesToggle(toggledOn: Boolean)

    fun updateVideoFilesToggle(toggledOn: Boolean)

    fun updateContactsToggle(toggledOn: Boolean)

    fun updateCalendarToggle(toggledOn: Boolean)

    fun updateTextMessagesToggle(toggledOn: Boolean)

    fun updateEmailToggle(toggledOn: Boolean)

    fun updateWebAddressToggle(toggledOn: Boolean)

    fun updatePhoneNumberToggle(toggledOn: Boolean)

    fun updateInstantAnswerToggle(toggledOn: Boolean)

    fun updateSuggestionToggle(toggledOn: Boolean)

    fun updateHistoryToggle(toggledOn: Boolean)
}