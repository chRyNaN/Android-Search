package com.chrynan.androidsearch.ui.layout

import android.content.Context
import android.view.ViewGroup
import android.widget.LinearLayout
import com.chrynan.androidsearch.di.Injector
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
                            this.title = toolbarTitle
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

                        label(searchSettingsLabel)

                        appsToggleCell = toggleCell(title = appsTitleText) {
                            presenter.toggleSearchItem(SearchSettingsPresenter.SearchToggleItem.APPS, it)
                        }

                        audioFilesToggleCell = toggleCell(title = audioFilesTitleText) {
                            presenter.toggleSearchItem(SearchSettingsPresenter.SearchToggleItem.AUDIO, it)
                        }

                        imageFilesToggleCell = toggleCell(title = imageFilesTitleText) {
                            presenter.toggleSearchItem(SearchSettingsPresenter.SearchToggleItem.IMAGE, it)
                        }

                        videoFilesToggleCell = toggleCell(title = videoFilesTitleText) {
                            presenter.toggleSearchItem(SearchSettingsPresenter.SearchToggleItem.VIDEO, it)
                        }

                        contactsToggleCell = toggleCell(title = contactsTitleText) {
                            presenter.toggleSearchItem(SearchSettingsPresenter.SearchToggleItem.CONTACTS, it)
                        }

                        emailAddressToggleCell = toggleCell(title = emailAddressTitleText) {
                            presenter.toggleSearchItem(SearchSettingsPresenter.SearchToggleItem.EMAIL, it)
                        }

                        webAddressToggleCell = toggleCell(title = webAddressTitleText) {
                            presenter.toggleSearchItem(SearchSettingsPresenter.SearchToggleItem.URL, it)
                        }

                        phoneNumberToggleCell = toggleCell(title = phoneNumberTitleText) {
                            presenter.toggleSearchItem(SearchSettingsPresenter.SearchToggleItem.PHONE_NUMBER, it)
                        }

                        suggestionsToggleCell = toggleCell(title = suggestionsTitleText) {
                            presenter.toggleSearchItem(SearchSettingsPresenter.SearchToggleItem.SUGGESTION, it)
                        }

                        searchHistoryToggleCell = toggleCell(title = searchHistory) {
                            presenter.toggleSearchItem(SearchSettingsPresenter.SearchToggleItem.HISTORY, it)
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

    private fun <V : LinearLayout, P : LinearLayout.LayoutParams> LayoutBuilder<V, P>.label(labelText: String) =
            textView {
                text = labelText
                setTextColor(labelColor)
                layoutParams {
                    width = LinearLayout.LayoutParams.MATCH_PARENT
                    height = LinearLayout.LayoutParams.WRAP_CONTENT
                    setMargins(labelStartMargin, labelTopMargin, labelEndMargin, labelBottomMargin)
                }
            }

    private fun <V : LinearLayout, P : LinearLayout.LayoutParams> LayoutBuilder<V, P>.toggleCell(title: String, toggleAction: (Boolean) -> Unit) =
            toggleCell {
                titleText = title
                setOnClickListener { toggleOn = !toggleOn }
                toggleListener = { toggleAction(it) }
                layoutParams {
                    width = LinearLayout.LayoutParams.MATCH_PARENT
                    height = LinearLayout.LayoutParams.WRAP_CONTENT
                }
            }
}