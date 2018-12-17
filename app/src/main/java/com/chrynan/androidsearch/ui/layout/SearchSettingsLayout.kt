package com.chrynan.androidsearch.ui.layout

import android.content.Context
import android.view.ViewGroup
import android.widget.LinearLayout
import com.chrynan.androidsearch.di.Injector
import com.chrynan.androidsearch.model.toggle.SearchToggleItem
import com.chrynan.androidsearch.navigator.SearchSettingsNavigator
import com.chrynan.androidsearch.presenter.SearchSettingsPresenter
import com.chrynan.androidsearch.resource.SearchSettingsLayoutResources
import com.chrynan.androidsearch.resource.source.SearchSettingsLayoutResourcesSource
import com.chrynan.androidsearch.ui.view.SearchSettingsView
import com.chrynan.androidsearch.ui.widget.DefaultCell
import com.chrynan.androidsearch.ui.widget.ToggleCell
import com.chrynan.androidsearch.ui.widget.defaultCell
import com.chrynan.androidsearch.ui.widget.toggleCell
import com.chrynan.androidsearch.util.AppContext
import com.chrynan.androidviews.builder.*
import com.chrynan.kotlinutils.perform
import javax.inject.Inject
import kotlin.properties.Delegates

class SearchSettingsLayout(
        appContext: AppContext,
        res: SearchSettingsLayoutResourcesSource
) : BaseLayout(appContext),
        SearchSettingsView,
        SearchSettingsLayoutResources by res {

    @Inject
    lateinit var presenter: SearchSettingsPresenter
    @Inject
    lateinit var navigator: SearchSettingsNavigator

    private var appsToggleCell by Delegates.notNull<ToggleCell>()
    private var audioFilesToggleCell by Delegates.notNull<ToggleCell>()
    private var imageFilesToggleCell by Delegates.notNull<ToggleCell>()
    private var videoFilesToggleCell by Delegates.notNull<ToggleCell>()
    private var contactsToggleCell by Delegates.notNull<ToggleCell>()
    private var emailAddressToggleCell by Delegates.notNull<ToggleCell>()
    private var webAddressToggleCell by Delegates.notNull<ToggleCell>()
    private var phoneNumberToggleCell by Delegates.notNull<ToggleCell>()
    private var suggestionsToggleCell by Delegates.notNull<ToggleCell>()
    private var searchHistoryToggleCell by Delegates.notNull<ToggleCell>()
    private var searchApproachToggleCell by Delegates.notNull<DefaultCell>()

    override fun setupDependencies() = Injector.inject(this)

    override fun onCreateLayout(context: Context) =
            verticalLayout(context) {

                appBarLayout {
                    toolbar {
                        init {
                            title = toolbarTitle
                            navigationIcon = toolbarNavigationIcon
                            setNavigationOnClickListener { navigator.goBack() }
                        }
                    }
                }

                scrollLayout {

                    verticalLayout {

                        init {
                            layoutParams(this@scrollLayout) {
                                width = ViewGroup.LayoutParams.MATCH_PARENT
                                height = ViewGroup.LayoutParams.MATCH_PARENT
                            }
                        }

                        appsToggleCell = toggleCell(title = appsTitleText, description = appsDescriptionText) {
                            presenter.toggleSearchItem(SearchToggleItem.APPS, it)
                        }

                        audioFilesToggleCell = toggleCell(title = audioFilesTitleText, description = audioFilesDescriptionText) {
                            presenter.toggleSearchItem(SearchToggleItem.AUDIO, it)
                        }

                        imageFilesToggleCell = toggleCell(title = imageFilesTitleText, description = imageFilesDescriptionText) {
                            presenter.toggleSearchItem(SearchToggleItem.IMAGE, it)
                        }

                        videoFilesToggleCell = toggleCell(title = videoFilesTitleText, description = videoFilesDescriptionText) {
                            presenter.toggleSearchItem(SearchToggleItem.VIDEO, it)
                        }

                        contactsToggleCell = toggleCell(title = contactsTitleText, description = contactsDescriptionText) {
                            presenter.toggleSearchItem(SearchToggleItem.CONTACTS, it)
                        }

                        emailAddressToggleCell = toggleCell(title = emailAddressTitleText, description = emailAddressDescriptionText) {
                            presenter.toggleSearchItem(SearchToggleItem.EMAIL, it)
                        }

                        webAddressToggleCell = toggleCell(title = webAddressTitleText, description = webAddressDescriptionText) {
                            presenter.toggleSearchItem(SearchToggleItem.URL, it)
                        }

                        phoneNumberToggleCell = toggleCell(title = phoneNumberTitleText, description = phoneNumberDescriptionText) {
                            presenter.toggleSearchItem(SearchToggleItem.PHONE_NUMBER, it)
                        }

                        suggestionsToggleCell = toggleCell(title = suggestionsTitleText, description = suggestionsDescriptionText) {
                            presenter.toggleSearchItem(SearchToggleItem.SUGGESTION, it)
                        }

                        searchHistoryToggleCell = toggleCell(title = searchHistoryTitleText, description = searchHistoryDescriptionText) {
                            presenter.toggleSearchItem(SearchToggleItem.HISTORY, it)
                        }

                        searchApproachToggleCell = defaultCell {
                            titleText = searchApproach
                            setOnClickListener { navigator.goToSearchQuerySettings() }
                            layoutParams {
                                width = LinearLayout.LayoutParams.MATCH_PARENT
                                height = LinearLayout.LayoutParams.WRAP_CONTENT
                            }
                        }
                    }
                }

                viewGroup.post {
                    presenter.getSettings()
                }
            }

    override fun updateApplicationsToggle(toggledOn: Boolean) = appsToggleCell.perform { toggleOn = toggledOn }

    override fun updateAudioFilesToggle(toggledOn: Boolean) = audioFilesToggleCell.perform { toggleOn = toggledOn }

    override fun updateImageFilesToggle(toggledOn: Boolean) = imageFilesToggleCell.perform { toggleOn = toggledOn }

    override fun updateVideoFilesToggle(toggledOn: Boolean) = videoFilesToggleCell.perform { toggleOn = toggledOn }

    override fun updateContactsToggle(toggledOn: Boolean) = contactsToggleCell.perform { toggleOn = toggledOn }

    override fun updateEmailToggle(toggledOn: Boolean) = emailAddressToggleCell.perform { toggleOn = toggledOn }

    override fun updateWebAddressToggle(toggledOn: Boolean) = webAddressToggleCell.perform { toggleOn = toggledOn }

    override fun updatePhoneNumberToggle(toggledOn: Boolean) = phoneNumberToggleCell.perform { toggleOn = toggledOn }

    override fun updateSuggestionToggle(toggledOn: Boolean) = suggestionsToggleCell.perform { toggleOn = toggledOn }

    override fun updateHistoryToggle(toggledOn: Boolean) = searchHistoryToggleCell.perform { toggleOn = toggledOn }

    override fun showSearchApproach(searchApproach: String?) = searchApproachToggleCell.perform { endText = searchApproach }

    private fun <V : LinearLayout, P : LinearLayout.LayoutParams> LayoutBuilder<V, P>.toggleCell(title: String, description: String? = null, toggleAction: (Boolean) -> Unit) =
            toggleCell {
                titleText = title
                descriptionText = description
                setOnClickListener { toggleOn = !toggleOn }
                toggleListener = { toggleAction(it) }
                layoutParams {
                    width = LinearLayout.LayoutParams.MATCH_PARENT
                    height = LinearLayout.LayoutParams.WRAP_CONTENT
                }
            }
}