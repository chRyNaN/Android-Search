package com.chrynan.androidsearch.ui.activity

import android.os.Bundle
import com.chrynan.androidsearch.R
import com.chrynan.androidsearch.presenter.SearchSettingsPresenter
import com.chrynan.androidsearch.presenter.SearchSettingsPresenter.SearchCheckedItem
import com.chrynan.androidsearch.presenter.SearchSettingsPresenter.SearchToggleItem
import com.chrynan.androidsearch.ui.view.SettingsView
import com.chrynan.androidsearch.ui.widget.RadioButtonCellGroup
import com.chrynan.androidsearch.util.isVisible
import kotlinx.android.synthetic.main.activity_search_settings.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class SearchSettingsActivity : BaseActivity(),
        SettingsView {

    private val presenter: SearchSettingsPresenter by inject { parametersOf(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_settings)

        presenter.getSettings()

        searchAppsToggleCell?.toggleListener = { presenter.toggleSearchItem(SearchToggleItem.APPS, it) }
        searchAudioFilesToggleCell?.toggleListener = { presenter.toggleSearchItem(SearchToggleItem.AUDIO, it) }
        searchImageFilesToggleCell?.toggleListener = { presenter.toggleSearchItem(SearchToggleItem.IMAGE, it) }
        searchVideoFilesToggleCell?.toggleListener = { presenter.toggleSearchItem(SearchToggleItem.VIDEO, it) }
        searchContactsToggleCell?.toggleListener = { presenter.toggleSearchItem(SearchToggleItem.CONTACTS, it) }
        searchCalendarEventsToggleCell?.toggleListener = { presenter.toggleSearchItem(SearchToggleItem.CALENDAR, it) }
        searchTextMessagesToggleCell?.toggleListener = { presenter.toggleSearchItem(SearchToggleItem.MESSAGES, it) }
        searchEmailLinksToggleCell?.toggleListener = { presenter.toggleSearchItem(SearchToggleItem.EMAIL, it) }
        searchUrlLinksToggleCell?.toggleListener = { presenter.toggleSearchItem(SearchToggleItem.URL, it) }
        searchPhoneNumbersToggleCell?.toggleListener = { presenter.toggleSearchItem(SearchToggleItem.PHONE_NUMBER, it) }
        searchInstantAnswersToggleCell?.toggleListener = { presenter.toggleSearchItem(SearchToggleItem.INSTANT_ANSWER, it) }
        searchSuggestionsToggleCell?.toggleListener = { presenter.toggleSearchItem(SearchToggleItem.SUGGESTION, it) }
        searchHistoryToggleCell?.toggleListener = { presenter.toggleSearchItem(SearchToggleItem.HISTORY, it) }

        val searchGroup = RadioButtonCellGroup(mapOf(
                SearchCheckedItem.APP to openSearchAppRadioButton,
                SearchCheckedItem.WEB_VIEW to openSearchWebViewRadioButton,
                SearchCheckedItem.CHROME_CUSTOM_TAB to openSearchChromeCustomTabRadioButton,
                SearchCheckedItem.BROWSER to openSearchBrowserAppRadioButton))

        val urlGroup = RadioButtonCellGroup(mapOf(
                SearchSettingsPresenter.SearchUrlCheckedItem.BING to bingUrlRadioButton,
                SearchSettingsPresenter.SearchUrlCheckedItem.CONTEXTUAL_WEB_SEARCH to contextualWebSearchUrlRadioButton,
                SearchSettingsPresenter.SearchUrlCheckedItem.DUCK_DUCK_GO to duckDuckGoUrlRadioButton,
                SearchSettingsPresenter.SearchUrlCheckedItem.GOOGLE to googleUrlRadioButton,
                SearchSettingsPresenter.SearchUrlCheckedItem.CUSTOM to customUrlRadioButton))
                .apply { isVisible = false }


        searchGroup.groupCheckedListener = { key, isChecked ->
            urlGroup.isVisible = (key != SearchCheckedItem.APP) and isChecked
            customUrlTextInputLayout?.isVisible = (key != SearchCheckedItem.APP) and
                    isChecked and
                    (customUrlRadioButton?.isChecked ?: false)

            presenter.toggleSearchApproach(key, isChecked)
        }

        urlGroup.groupCheckedListener = { key, isChecked ->
            customUrlTextInputLayout?.isVisible = (key == SearchSettingsPresenter.SearchUrlCheckedItem.CUSTOM) and isChecked
        }
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
}