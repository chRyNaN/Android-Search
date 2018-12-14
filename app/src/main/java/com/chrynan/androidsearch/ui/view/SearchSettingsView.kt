package com.chrynan.androidsearch.ui.view

interface SearchSettingsView {

    fun updateApplicationsToggle(toggledOn: Boolean)

    fun updateAudioFilesToggle(toggledOn: Boolean)

    fun updateImageFilesToggle(toggledOn: Boolean)

    fun updateVideoFilesToggle(toggledOn: Boolean)

    fun updateContactsToggle(toggledOn: Boolean)

    fun updateEmailToggle(toggledOn: Boolean)

    fun updateWebAddressToggle(toggledOn: Boolean)

    fun updatePhoneNumberToggle(toggledOn: Boolean)

    fun updateSuggestionToggle(toggledOn: Boolean)

    fun updateHistoryToggle(toggledOn: Boolean)

    fun showSearchApproach(searchApproach: String?)
}