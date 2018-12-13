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
    private var calendarToggleCell by Delegates.notNull<ToggleCell>()
    private var textMessagesToggleCell by Delegates.notNull<ToggleCell>()
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
                            this.title = "Settings"
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

                        textView {
                            text = searchSettingsLabel
                            setTextColor(labelColor)
                            layoutParams {
                                width = LinearLayout.LayoutParams.MATCH_PARENT
                                height = LinearLayout.LayoutParams.WRAP_CONTENT
                                setMargins(labelStartMargin, labelTopMargin, labelEndMargin, labelBottomMargin)
                            }
                        }

                        appsToggleCell = toggleCell {
                            titleText = appsTitleText
                            setOnClickListener { toggleOn = !toggleOn }
                            toggleListener = { presenter.toggleSearchItem(SearchSettingsPresenter.SearchToggleItem.APPS, it) }
                            layoutParams {
                                width = LinearLayout.LayoutParams.MATCH_PARENT
                                height = LinearLayout.LayoutParams.WRAP_CONTENT
                            }
                        }

                        audioFilesToggleCell = toggleCell {
                            titleText = audioFilesTitleText
                            setOnClickListener { toggleOn = !toggleOn }
                            toggleListener = { presenter.toggleSearchItem(SearchSettingsPresenter.SearchToggleItem.AUDIO, it) }
                            layoutParams {
                                width = LinearLayout.LayoutParams.MATCH_PARENT
                                height = LinearLayout.LayoutParams.WRAP_CONTENT
                            }
                        }

                        imageFilesToggleCell = toggleCell {
                            titleText = imageFilesTitleText
                            setOnClickListener { toggleOn = !toggleOn }
                            toggleListener = { presenter.toggleSearchItem(SearchSettingsPresenter.SearchToggleItem.IMAGE, it) }
                            layoutParams {
                                width = LinearLayout.LayoutParams.MATCH_PARENT
                                height = LinearLayout.LayoutParams.WRAP_CONTENT
                            }
                        }

                        videoFilesToggleCell = toggleCell {
                            titleText = videoFilesTitleText
                            setOnClickListener { toggleOn = !toggleOn }
                            toggleListener = { presenter.toggleSearchItem(SearchSettingsPresenter.SearchToggleItem.VIDEO, it) }
                            layoutParams {
                                width = LinearLayout.LayoutParams.MATCH_PARENT
                                height = LinearLayout.LayoutParams.WRAP_CONTENT
                            }
                        }

                        contactsToggleCell = toggleCell {
                            titleText = contactsTitleText
                            setOnClickListener { toggleOn = !toggleOn }
                            toggleListener = { presenter.toggleSearchItem(SearchSettingsPresenter.SearchToggleItem.CONTACTS, it) }
                            layoutParams {
                                width = LinearLayout.LayoutParams.MATCH_PARENT
                                height = LinearLayout.LayoutParams.WRAP_CONTENT
                            }
                        }

                        calendarToggleCell = toggleCell {
                            titleText = calendarEventsTitleText
                            setOnClickListener { toggleOn = !toggleOn }
                            toggleListener = { presenter.toggleSearchItem(SearchSettingsPresenter.SearchToggleItem.CALENDAR, it) }
                            layoutParams {
                                width = LinearLayout.LayoutParams.MATCH_PARENT
                                height = LinearLayout.LayoutParams.WRAP_CONTENT
                            }
                        }

                        textMessagesToggleCell = toggleCell {
                            titleText = textMessagesTitleText
                            setOnClickListener { toggleOn = !toggleOn }
                            toggleListener = { presenter.toggleSearchItem(SearchSettingsPresenter.SearchToggleItem.MESSAGES, it) }
                            layoutParams {
                                width = LinearLayout.LayoutParams.MATCH_PARENT
                                height = LinearLayout.LayoutParams.WRAP_CONTENT
                            }
                        }

                        emailAddressToggleCell = toggleCell {
                            titleText = emailAddressTitleText
                            setOnClickListener { toggleOn = !toggleOn }
                            toggleListener = { presenter.toggleSearchItem(SearchSettingsPresenter.SearchToggleItem.EMAIL, it) }
                            layoutParams {
                                width = LinearLayout.LayoutParams.MATCH_PARENT
                                height = LinearLayout.LayoutParams.WRAP_CONTENT
                            }
                        }

                        webAddressToggleCell = toggleCell {
                            titleText = webAddressTitleText
                            setOnClickListener { toggleOn = !toggleOn }
                            toggleListener = { presenter.toggleSearchItem(SearchSettingsPresenter.SearchToggleItem.URL, it) }
                            layoutParams {
                                width = LinearLayout.LayoutParams.MATCH_PARENT
                                height = LinearLayout.LayoutParams.WRAP_CONTENT
                            }
                        }

                        phoneNumberToggleCell = toggleCell {
                            titleText = phoneNumberTitleText
                            setOnClickListener { toggleOn = !toggleOn }
                            toggleListener = { presenter.toggleSearchItem(SearchSettingsPresenter.SearchToggleItem.PHONE_NUMBER, it) }
                            layoutParams {
                                width = LinearLayout.LayoutParams.MATCH_PARENT
                                height = LinearLayout.LayoutParams.WRAP_CONTENT
                            }
                        }

                        suggestionsToggleCell = toggleCell {
                            titleText = suggestionsTitleText
                            setOnClickListener { toggleOn = !toggleOn }
                            toggleListener = { presenter.toggleSearchItem(SearchSettingsPresenter.SearchToggleItem.SUGGESTION, it) }
                            layoutParams {
                                width = LinearLayout.LayoutParams.MATCH_PARENT
                                height = LinearLayout.LayoutParams.WRAP_CONTENT
                            }
                        }

                        searchHistoryToggleCell = toggleCell {
                            titleText = searchHistory
                            setOnClickListener { toggleOn = !toggleOn }
                            toggleListener = { presenter.toggleSearchItem(SearchSettingsPresenter.SearchToggleItem.HISTORY, it) }
                            layoutParams {
                                width = LinearLayout.LayoutParams.MATCH_PARENT
                                height = LinearLayout.LayoutParams.WRAP_CONTENT
                            }
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

    override fun updateCalendarToggle(toggledOn: Boolean) = calendarToggleCell.perform { toggleOn = toggledOn }

    override fun updateTextMessagesToggle(toggledOn: Boolean) = textMessagesToggleCell.perform { toggleOn = toggledOn }

    override fun updateEmailToggle(toggledOn: Boolean) = emailAddressToggleCell.perform { toggleOn = toggledOn }

    override fun updateWebAddressToggle(toggledOn: Boolean) = webAddressToggleCell.perform { toggleOn = toggledOn }

    override fun updatePhoneNumberToggle(toggledOn: Boolean) = phoneNumberToggleCell.perform { toggleOn = toggledOn }

    override fun updateSuggestionToggle(toggledOn: Boolean) = suggestionsToggleCell.perform { toggleOn = toggledOn }

    override fun updateHistoryToggle(toggledOn: Boolean) = searchHistoryToggleCell.perform { toggleOn = toggledOn }

    override fun showSearchApproach(searchApproach: String?) = searchApproachToggleCell.perform { endText = searchApproach }
}