package com.chrynan.androidsearch.ui.layout

import android.animation.LayoutTransition
import android.content.Context
import android.support.design.widget.TextInputEditText
import android.support.design.widget.TextInputLayout
import android.widget.LinearLayout
import android.widget.ScrollView
import com.chrynan.accore.runOnAndroidUI
import com.chrynan.acview.onTextChanged
import com.chrynan.androidsearch.di.Injector
import com.chrynan.androidsearch.model.QueryUrls
import com.chrynan.androidsearch.model.toggle.SearchCheckedItem
import com.chrynan.androidsearch.model.toggle.SearchUrlCheckedItem
import com.chrynan.androidsearch.model.wrapper.Url
import com.chrynan.androidsearch.presenter.SearchQuerySettingsPresenter
import com.chrynan.androidsearch.resource.SearchQuerySettingsLayoutResources
import com.chrynan.androidsearch.resource.source.SearchQuerySettingsLayoutResourcesSource
import com.chrynan.androidsearch.ui.view.SearchQuerySettingsView
import com.chrynan.androidsearch.ui.widget.RadioButtonCell
import com.chrynan.androidsearch.ui.widget.divider
import com.chrynan.androidsearch.ui.widget.label
import com.chrynan.androidsearch.ui.widget.radioButtonCellGroup
import com.chrynan.androidsearch.util.AppContext
import com.chrynan.androidviews.builder.*
import com.chrynan.androidviewutils.ViewVisibilityState
import com.chrynan.androidviewutils.setVisibleOrGone
import com.chrynan.androidviewutils.visibilityState
import com.chrynan.kotlinutils.perform
import javax.inject.Inject
import kotlin.properties.Delegates

class SearchQuerySettingsLayout(
        appContext: AppContext,
        res: SearchQuerySettingsLayoutResourcesSource
) : BaseLayout(appContext),
        SearchQuerySettingsView,
        SearchQuerySettingsLayoutResources by res {

    @Inject
    lateinit var presenter: SearchQuerySettingsPresenter

    private var scrollLayout by Delegates.notNull<ScrollView>()
    private var browserToggleCell by Delegates.notNull<RadioButtonCell>()
    private var chromeCustomTabsToggleCell by Delegates.notNull<RadioButtonCell>()
    private var webViewToggleCell by Delegates.notNull<RadioButtonCell>()
    private var bingToggleCell by Delegates.notNull<RadioButtonCell>()
    private var contextualWebSearchToggleCell by Delegates.notNull<RadioButtonCell>()
    private var duckDuckGoToggleCell by Delegates.notNull<RadioButtonCell>()
    private var googleToggleCell by Delegates.notNull<RadioButtonCell>()
    private var customUrlToggleCell by Delegates.notNull<RadioButtonCell>()
    private var customUrlTextInputLayout by Delegates.notNull<TextInputLayout>()
    private var customUrlEditText by Delegates.notNull<TextInputEditText>()

    override fun setupDependencies() = Injector.inject(this)

    override fun onCreateLayout(context: Context) =
            verticalLayout(context) {

                appBarLayout {
                    toolbar {
                        init {
                            title = toolbarTitle
                            navigationIcon = toolbarNavigationIcon
                            setNavigationOnClickListener { }
                        }
                    }
                }

                scrollLayout = scrollLayout {

                    verticalLayout {

                        init {
                            layoutTransition = LayoutTransition()
                        }

                        label(searchMethodLabel)

                        val methodGroup = radioButtonCellGroup<SearchCheckedItem> {

                            browserToggleCell = radioButtonCell(SearchCheckedItem.BROWSER) {
                                titleText = browserTitleText
                                setOnClickListener { setCheckedTriggeringListener(!isChecked) }
                                layoutParams {
                                    width = LinearLayout.LayoutParams.MATCH_PARENT
                                    height = LinearLayout.LayoutParams.WRAP_CONTENT
                                }
                            }

                            chromeCustomTabsToggleCell = radioButtonCell(SearchCheckedItem.CHROME_CUSTOM_TAB) {
                                titleText = chromeCustomTabsTitleText
                                setOnClickListener { setCheckedTriggeringListener(!isChecked) }
                                layoutParams {
                                    width = LinearLayout.LayoutParams.MATCH_PARENT
                                    height = LinearLayout.LayoutParams.WRAP_CONTENT
                                }
                            }

                            webViewToggleCell = radioButtonCell(SearchCheckedItem.WEB_VIEW) {
                                titleText = webTitleText
                                setOnClickListener { setCheckedTriggeringListener(!isChecked) }
                                layoutParams {
                                    width = LinearLayout.LayoutParams.MATCH_PARENT
                                    height = LinearLayout.LayoutParams.WRAP_CONTENT
                                }
                            }

                        }

                        divider()

                        label(searchAddressLabel)

                        val addressGroup = radioButtonCellGroup<SearchUrlCheckedItem> {

                            bingToggleCell = radioButtonCell(SearchUrlCheckedItem.Bing) {
                                titleText = bingTitleText
                                setOnClickListener { setCheckedTriggeringListener(!isChecked) }
                                layoutParams {
                                    width = LinearLayout.LayoutParams.MATCH_PARENT
                                    height = LinearLayout.LayoutParams.WRAP_CONTENT
                                }
                            }

                            contextualWebSearchToggleCell = radioButtonCell(SearchUrlCheckedItem.ContextualWebSearch) {
                                titleText = contextualWebSearchTitleText
                                setOnClickListener { setCheckedTriggeringListener(!isChecked) }
                                layoutParams {
                                    width = LinearLayout.LayoutParams.MATCH_PARENT
                                    height = LinearLayout.LayoutParams.WRAP_CONTENT
                                }
                            }

                            duckDuckGoToggleCell = radioButtonCell(SearchUrlCheckedItem.DuckDuckGo) {
                                titleText = duckDuckGoTitleText
                                setOnClickListener { setCheckedTriggeringListener(!isChecked) }
                                layoutParams {
                                    width = LinearLayout.LayoutParams.MATCH_PARENT
                                    height = LinearLayout.LayoutParams.WRAP_CONTENT
                                }
                            }

                            googleToggleCell = radioButtonCell(SearchUrlCheckedItem.Google) {
                                titleText = googleTitleText
                                setOnClickListener { setCheckedTriggeringListener(!isChecked) }
                                layoutParams {
                                    width = LinearLayout.LayoutParams.MATCH_PARENT
                                    height = LinearLayout.LayoutParams.WRAP_CONTENT
                                }
                            }

                            customUrlToggleCell = radioButtonCell(SearchUrlCheckedItem.Custom(Url(QueryUrls.DUCK_DUCK_GO))) {
                                titleText = customTitleText
                                setOnClickListener { setCheckedTriggeringListener(!isChecked) }
                                layoutParams {
                                    width = LinearLayout.LayoutParams.MATCH_PARENT
                                    height = LinearLayout.LayoutParams.WRAP_CONTENT
                                }
                            }

                        }

                        customUrlTextInputLayout = textInputLayout {
                            init {
                                visibilityState = ViewVisibilityState.GONE
                            }

                            customUrlEditText = textInputEditText {
                                hint = customUrlHint
                                layoutParams {
                                    width = LinearLayout.LayoutParams.MATCH_PARENT
                                    height = LinearLayout.LayoutParams.WRAP_CONTENT
                                }
                                runOnAndroidUI {
                                    onTextChanged {
                                        presenter.selectSearchUrl(SearchUrlCheckedItem.Custom(Url(it.charSequence.toString())))
                                    }
                                }
                            }
                        }

                        methodGroup.groupCheckedListener = { key: SearchCheckedItem ->
                            presenter.toggleSearchApproach(key)
                        }

                        addressGroup.groupCheckedListener = { key: SearchUrlCheckedItem ->
                            presenter.selectSearchUrl(key)
                            customUrlTextInputLayout.setVisibleOrGone(key is SearchUrlCheckedItem.Custom)

                            if (key is SearchUrlCheckedItem.Custom) {
                                customUrlEditText.requestFocus()
                            }
                        }
                    }
                }

                presenter.getSettings()
            }

    override fun updateWebViewChecked(checked: Boolean) = webViewToggleCell.perform { isChecked = checked }

    override fun updateChromeCustomTabsChecked(checked: Boolean) = chromeCustomTabsToggleCell.perform { isChecked = checked }

    override fun updateBrowserChecked(checked: Boolean) = browserToggleCell.perform { isChecked = checked }

    override fun updateBingChecked(checked: Boolean) = bingToggleCell.perform { isChecked = checked }

    override fun updateContextualWebSearchChecked(checked: Boolean) = contextualWebSearchToggleCell.perform { isChecked = checked }

    override fun updateDuckDuckGoChecked(checked: Boolean) = duckDuckGoToggleCell.perform { isChecked = checked }

    override fun updateGoogleChecked(checked: Boolean) = googleToggleCell.perform { isChecked = checked }

    override fun updateCustomChecked(checked: Boolean) = customUrlToggleCell.perform { isChecked = checked }
}