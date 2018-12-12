package com.chrynan.androidsearch.ui.layout

import android.content.Context
import android.view.ViewGroup
import android.widget.LinearLayout
import com.chrynan.androidsearch.di.Injector
import com.chrynan.androidsearch.navigator.SearchSettingsNavigator
import com.chrynan.androidsearch.presenter.SearchSettingsPresenter
import com.chrynan.androidsearch.resource.SearchSettingsResources
import com.chrynan.androidsearch.ui.view.SearchSettingsView
import com.chrynan.androidsearch.ui.widget.DefaultCell
import com.chrynan.androidsearch.ui.widget.ToggleCell
import com.chrynan.androidsearch.ui.widget.defaultCell
import com.chrynan.androidsearch.ui.widget.toggleCell
import com.chrynan.androidsearch.util.AppContext
import com.chrynan.androidviews.builder.appBarLayout
import com.chrynan.androidviews.builder.scrollLayout
import com.chrynan.androidviews.builder.toolbar
import com.chrynan.androidviews.builder.verticalLayout
import com.chrynan.kotlinutils.perform
import javax.inject.Inject
import kotlin.properties.Delegates

class SearchSettingsLayout(appContext: AppContext) : BaseLayout(appContext),
        SearchSettingsView {

    @Inject
    lateinit var presenter: SearchSettingsPresenter
    @Inject
    lateinit var navigator: SearchSettingsNavigator
    @Inject
    lateinit var res: SearchSettingsResources

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

                        appsToggleCell = toggleCell {
                            titleText = res.appsTitleText
                            setOnClickListener { toggleOn = !toggleOn }
                            toggleListener = { presenter.toggleSearchItem(SearchSettingsPresenter.SearchToggleItem.APPS, it) }
                            layoutParams {
                                width = LinearLayout.LayoutParams.MATCH_PARENT
                                height = LinearLayout.LayoutParams.WRAP_CONTENT
                            }
                        }

                        audioFilesToggleCell = toggleCell {
                            titleText = res.audioFilesTitleText
                            setOnClickListener { toggleOn = !toggleOn }
                            toggleListener = { presenter.toggleSearchItem(SearchSettingsPresenter.SearchToggleItem.AUDIO, it) }
                            layoutParams {
                                width = LinearLayout.LayoutParams.MATCH_PARENT
                                height = LinearLayout.LayoutParams.WRAP_CONTENT
                            }
                        }

                        imageFilesToggleCell = toggleCell {
                            titleText = res.imageFilesTitleText
                            setOnClickListener { toggleOn = !toggleOn }
                            toggleListener = { presenter.toggleSearchItem(SearchSettingsPresenter.SearchToggleItem.IMAGE, it) }
                            layoutParams {
                                width = LinearLayout.LayoutParams.MATCH_PARENT
                                height = LinearLayout.LayoutParams.WRAP_CONTENT
                            }
                        }

                        videoFilesToggleCell = toggleCell {
                            titleText = res.videoFilesTitleText
                            setOnClickListener { toggleOn = !toggleOn }
                            toggleListener = { presenter.toggleSearchItem(SearchSettingsPresenter.SearchToggleItem.VIDEO, it) }
                            layoutParams {
                                width = LinearLayout.LayoutParams.MATCH_PARENT
                                height = LinearLayout.LayoutParams.WRAP_CONTENT
                            }
                        }

                        contactsToggleCell = toggleCell {
                            titleText = res.contactsTitleText
                            setOnClickListener { toggleOn = !toggleOn }
                            toggleListener = { presenter.toggleSearchItem(SearchSettingsPresenter.SearchToggleItem.CONTACTS, it) }
                            layoutParams {
                                width = LinearLayout.LayoutParams.MATCH_PARENT
                                height = LinearLayout.LayoutParams.WRAP_CONTENT
                            }
                        }

                        calendarToggleCell = toggleCell {
                            titleText = res.calendarEventsTitleText
                            setOnClickListener { toggleOn = !toggleOn }
                            toggleListener = { presenter.toggleSearchItem(SearchSettingsPresenter.SearchToggleItem.CALENDAR, it) }
                            layoutParams {
                                width = LinearLayout.LayoutParams.MATCH_PARENT
                                height = LinearLayout.LayoutParams.WRAP_CONTENT
                            }
                        }

                        textMessagesToggleCell = toggleCell {
                            titleText = res.textMessagesTitleText
                            setOnClickListener { toggleOn = !toggleOn }
                            toggleListener = { presenter.toggleSearchItem(SearchSettingsPresenter.SearchToggleItem.MESSAGES, it) }
                            layoutParams {
                                width = LinearLayout.LayoutParams.MATCH_PARENT
                                height = LinearLayout.LayoutParams.WRAP_CONTENT
                            }
                        }

                        emailAddressToggleCell = toggleCell {
                            titleText = res.emailAddressTitleText
                            setOnClickListener { toggleOn = !toggleOn }
                            toggleListener = { presenter.toggleSearchItem(SearchSettingsPresenter.SearchToggleItem.EMAIL, it) }
                            layoutParams {
                                width = LinearLayout.LayoutParams.MATCH_PARENT
                                height = LinearLayout.LayoutParams.WRAP_CONTENT
                            }
                        }

                        webAddressToggleCell = toggleCell {
                            titleText = res.webAddressTitleText
                            setOnClickListener { toggleOn = !toggleOn }
                            toggleListener = { presenter.toggleSearchItem(SearchSettingsPresenter.SearchToggleItem.URL, it) }
                            layoutParams {
                                width = LinearLayout.LayoutParams.MATCH_PARENT
                                height = LinearLayout.LayoutParams.WRAP_CONTENT
                            }
                        }

                        phoneNumberToggleCell = toggleCell {
                            titleText = res.phoneNumberTitleText
                            setOnClickListener { toggleOn = !toggleOn }
                            toggleListener = { presenter.toggleSearchItem(SearchSettingsPresenter.SearchToggleItem.PHONE_NUMBER, it) }
                            layoutParams {
                                width = LinearLayout.LayoutParams.MATCH_PARENT
                                height = LinearLayout.LayoutParams.WRAP_CONTENT
                            }
                        }

                        suggestionsToggleCell = toggleCell {
                            titleText = res.suggestionsTitleText
                            setOnClickListener { toggleOn = !toggleOn }
                            toggleListener = { presenter.toggleSearchItem(SearchSettingsPresenter.SearchToggleItem.SUGGESTION, it) }
                            layoutParams {
                                width = LinearLayout.LayoutParams.MATCH_PARENT
                                height = LinearLayout.LayoutParams.WRAP_CONTENT
                            }
                        }

                        searchHistoryToggleCell = toggleCell {
                            titleText = res.searchHistory
                            setOnClickListener { toggleOn = !toggleOn }
                            toggleListener = { presenter.toggleSearchItem(SearchSettingsPresenter.SearchToggleItem.HISTORY, it) }
                            layoutParams {
                                width = LinearLayout.LayoutParams.MATCH_PARENT
                                height = LinearLayout.LayoutParams.WRAP_CONTENT
                            }
                        }

                        searchApproachToggleCell = defaultCell {
                            titleText = res.searchApproach
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