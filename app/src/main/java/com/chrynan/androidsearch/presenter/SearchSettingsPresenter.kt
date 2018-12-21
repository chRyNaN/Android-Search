package com.chrynan.androidsearch.presenter

import android.content.Context
import com.chrynan.androidsearch.R
import com.chrynan.androidsearch.model.toggle.SearchToggleItem
import com.chrynan.androidsearch.preference.SearchPreferences
import com.chrynan.androidsearch.ui.view.SearchSettingsView
import com.chrynan.androidsearch.util.PermissionResult
import com.chrynan.androidsearch.util.RequestCode
import com.chrynan.androidsearch.util.RuntimePermission
import com.chrynan.androidsearch.util.isGranted
import com.chrynan.kotlinutils.perform
import com.chrynan.kotlinutils.truthy
import javax.inject.Inject

class SearchSettingsPresenter @Inject constructor(
        private val context: Context,
        private val view: SearchSettingsView,
        private val preferences: SearchPreferences
) : CoroutinePresenter() {

    companion object {

        const val PERMISSION_AUDIO_REQUEST_CODE = 0
        const val PERMISSION_IMAGE_REQUEST_CODE = 1
        const val PERMISSION_VIDEO_REQUEST_CODE = 2
        const val PERMISSION_CONTACT_REQUEST_CODE = 3
    }

    val filePermissions by lazy { listOf(RuntimePermission.READ_EXTERNAL_STORAGE) }
    val contactPermissions by lazy { listOf(RuntimePermission.READ_CONTACTS) }

    private val webView by lazy { context.getString(R.string.search_approach_web_view) }
    private val browser by lazy { context.getString(R.string.search_approach_browser) }

    fun getSettings() =
            view.perform {
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

    fun handlePermissionResults(requestCode: RequestCode, results: List<PermissionResult>) {
        val permissionMap = results.associate { it.permission to it.state }
        val filesAccessGranted = permissionMap[RuntimePermission.READ_EXTERNAL_STORAGE]?.isGranted.truthy
        val contactAccessGranted = permissionMap[RuntimePermission.READ_CONTACTS]?.isGranted.truthy

        when (requestCode) {
            PERMISSION_AUDIO_REQUEST_CODE -> toggleSearchItemAndUpdateView(item = SearchToggleItem.AUDIO, toggledOn = filesAccessGranted)
            PERMISSION_IMAGE_REQUEST_CODE -> toggleSearchItemAndUpdateView(item = SearchToggleItem.IMAGE, toggledOn = filesAccessGranted)
            PERMISSION_VIDEO_REQUEST_CODE -> toggleSearchItemAndUpdateView(item = SearchToggleItem.VIDEO, toggledOn = filesAccessGranted)
            PERMISSION_CONTACT_REQUEST_CODE -> toggleSearchItemAndUpdateView(item = SearchToggleItem.CONTACTS, toggledOn = contactAccessGranted)
        }
    }

    private fun getSearchApproach() =
            when {
                preferences.webView -> webView
                preferences.browser -> browser
                else -> browser
            }

    private fun toggleSearchItemAndUpdateView(item: SearchToggleItem, toggledOn: Boolean) = view.perform {
        when (item) {
            SearchToggleItem.APPS -> {
                preferences.apps = toggledOn
                updateApplicationsToggle(toggledOn)
            }
            SearchToggleItem.AUDIO -> {
                preferences.audioFiles = toggledOn
                updateAudioFilesToggle(toggledOn)
            }
            SearchToggleItem.IMAGE -> {
                preferences.imageFiles = toggledOn
                updateImageFilesToggle(toggledOn)
            }
            SearchToggleItem.VIDEO -> {
                preferences.videoFiles = toggledOn
                updateVideoFilesToggle(toggledOn)
            }
            SearchToggleItem.CONTACTS -> {
                preferences.contacts = toggledOn
                updateContactsToggle(toggledOn)
            }
            SearchToggleItem.EMAIL -> {
                preferences.emailLink = toggledOn
                updateEmailToggle(toggledOn)
            }
            SearchToggleItem.URL -> {
                preferences.webAddressLink = toggledOn
                updateWebAddressToggle(toggledOn)
            }
            SearchToggleItem.PHONE_NUMBER -> {
                preferences.phoneNumberLink = toggledOn
                updatePhoneNumberToggle(toggledOn)
            }
            SearchToggleItem.SUGGESTION -> {
                preferences.typeAhead = toggledOn
                updateSuggestionToggle(toggledOn)
            }
            SearchToggleItem.HISTORY -> {
                preferences.history = toggledOn
                updateHistoryToggle(toggledOn)
            }
        }
    }
}