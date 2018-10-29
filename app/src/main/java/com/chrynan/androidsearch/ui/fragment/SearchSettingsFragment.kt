package com.chrynan.androidsearch.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chrynan.androidsearch.R
import com.chrynan.androidsearch.presenter.SearchSettingsPresenter
import com.chrynan.androidsearch.ui.view.SearchSettingsView
import kotlinx.android.synthetic.main.fragment_search_settings.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class SearchSettingsFragment : BaseFragment(),
        SearchSettingsView {

    companion object {

        fun newInstance() = SearchSettingsFragment()
    }

    private val presenter: SearchSettingsPresenter by inject { parametersOf(this) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_search_settings, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        presenter.getSettings()

        searchAppsToggleCell?.toggleListener = { presenter.toggleSearchItem(SearchSettingsPresenter.SearchToggleItem.APPS, it) }
        searchAudioFilesToggleCell?.toggleListener = { presenter.toggleSearchItem(SearchSettingsPresenter.SearchToggleItem.AUDIO, it) }
        searchImageFilesToggleCell?.toggleListener = { presenter.toggleSearchItem(SearchSettingsPresenter.SearchToggleItem.IMAGE, it) }
        searchVideoFilesToggleCell?.toggleListener = { presenter.toggleSearchItem(SearchSettingsPresenter.SearchToggleItem.VIDEO, it) }
        searchContactsToggleCell?.toggleListener = { presenter.toggleSearchItem(SearchSettingsPresenter.SearchToggleItem.CONTACTS, it) }
        searchCalendarEventsToggleCell?.toggleListener = { presenter.toggleSearchItem(SearchSettingsPresenter.SearchToggleItem.CALENDAR, it) }
        searchTextMessagesToggleCell?.toggleListener = { presenter.toggleSearchItem(SearchSettingsPresenter.SearchToggleItem.MESSAGES, it) }
        searchEmailLinksToggleCell?.toggleListener = { presenter.toggleSearchItem(SearchSettingsPresenter.SearchToggleItem.EMAIL, it) }
        searchUrlLinksToggleCell?.toggleListener = { presenter.toggleSearchItem(SearchSettingsPresenter.SearchToggleItem.URL, it) }
        searchPhoneNumbersToggleCell?.toggleListener = { presenter.toggleSearchItem(SearchSettingsPresenter.SearchToggleItem.PHONE_NUMBER, it) }
        searchInstantAnswersToggleCell?.toggleListener = { presenter.toggleSearchItem(SearchSettingsPresenter.SearchToggleItem.INSTANT_ANSWER, it) }
        searchSuggestionsToggleCell?.toggleListener = { presenter.toggleSearchItem(SearchSettingsPresenter.SearchToggleItem.SUGGESTION, it) }
        searchHistoryToggleCell?.toggleListener = { presenter.toggleSearchItem(SearchSettingsPresenter.SearchToggleItem.HISTORY, it) }
        searchApproachDefaultCell?.setOnClickListener { } // TODO add navigation
    }

    override fun updateApplicationsToggle(toggledOn: Boolean) {
        searchAppsToggleCell?.toggleOn = toggledOn
    }

    override fun updateAudioFilesToggle(toggledOn: Boolean) {
        searchAudioFilesToggleCell?.toggleOn = toggledOn
    }

    override fun updateImageFilesToggle(toggledOn: Boolean) {
        searchImageFilesToggleCell?.toggleOn = toggledOn
    }

    override fun updateVideoFilesToggle(toggledOn: Boolean) {
        searchVideoFilesToggleCell?.toggleOn = toggledOn
    }

    override fun updateContactsToggle(toggledOn: Boolean) {
        searchContactsToggleCell?.toggleOn = toggledOn
    }

    override fun updateCalendarToggle(toggledOn: Boolean) {
        searchCalendarEventsToggleCell?.toggleOn = toggledOn
    }

    override fun updateTextMessagesToggle(toggledOn: Boolean) {
        searchTextMessagesToggleCell?.toggleOn = toggledOn
    }

    override fun updateEmailToggle(toggledOn: Boolean) {
        searchEmailLinksToggleCell?.toggleOn = toggledOn
    }

    override fun updateWebAddressToggle(toggledOn: Boolean) {
        searchUrlLinksToggleCell?.toggleOn = toggledOn
    }

    override fun updatePhoneNumberToggle(toggledOn: Boolean) {
        searchPhoneNumbersToggleCell?.toggleOn = toggledOn
    }

    override fun updateInstantAnswerToggle(toggledOn: Boolean) {
        searchInstantAnswersToggleCell?.toggleOn = toggledOn
    }

    override fun updateSuggestionToggle(toggledOn: Boolean) {
        searchSuggestionsToggleCell?.toggleOn = toggledOn
    }

    override fun updateHistoryToggle(toggledOn: Boolean) {
        searchHistoryToggleCell?.toggleOn = toggledOn
    }

    override fun showSearchApproach(searchApproach: String?) {
        searchApproachDefaultCell?.endText = searchApproach
    }
}