package com.chrynan.androidsearch.ui.layout

import android.content.Context
import android.view.View
import android.widget.LinearLayout
import com.chrynan.androidsearch.di.Injector
import com.chrynan.androidsearch.model.toggle.SearchCheckedItem
import com.chrynan.androidsearch.model.toggle.SearchUrlCheckedItem
import com.chrynan.androidsearch.presenter.SearchQuerySettingsPresenter
import com.chrynan.androidsearch.resource.SearchQuerySettingsLayoutResources
import com.chrynan.androidsearch.resource.source.SearchQuerySettingsLayoutResourcesSource
import com.chrynan.androidsearch.ui.widget.divider
import com.chrynan.androidsearch.ui.widget.label
import com.chrynan.androidsearch.ui.widget.radioButtonCellGroup
import com.chrynan.androidsearch.util.AppContext
import com.chrynan.androidviews.builder.*
import javax.inject.Inject

class SearchQuerySettingsLayout(
        appContext: AppContext,
        res: SearchQuerySettingsLayoutResourcesSource
) : BaseLayout(appContext),
        SearchQuerySettingsLayoutResources by res {

    @Inject
    lateinit var presenter: SearchQuerySettingsPresenter

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

                scrollLayout {

                    verticalLayout {

                        label(searchMethodLabel)

                        val methodGroup = radioButtonCellGroup<SearchCheckedItem> {

                            radioButtonCell(SearchCheckedItem.BROWSER) {
                                titleText = browserTitleText
                                setOnClickListener { setCheckedTriggeringListener(!isChecked) }
                                layoutParams {
                                    width = LinearLayout.LayoutParams.MATCH_PARENT
                                    height = LinearLayout.LayoutParams.WRAP_CONTENT
                                }
                            }

                            radioButtonCell(SearchCheckedItem.CHROME_CUSTOM_TAB) {
                                titleText = chromeCustomTabsTitleText
                                setOnClickListener { setCheckedTriggeringListener(!isChecked) }
                                layoutParams {
                                    width = LinearLayout.LayoutParams.MATCH_PARENT
                                    height = LinearLayout.LayoutParams.WRAP_CONTENT
                                }
                            }

                            radioButtonCell(SearchCheckedItem.WEB_VIEW) {
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

                            radioButtonCell(SearchUrlCheckedItem.BING) {
                                titleText = bingTitleText
                                setOnClickListener { isChecked = !isChecked }
                                layoutParams {
                                    width = LinearLayout.LayoutParams.MATCH_PARENT
                                    height = LinearLayout.LayoutParams.WRAP_CONTENT
                                }
                            }

                            radioButtonCell(SearchUrlCheckedItem.CONTEXTUAL_WEB_SEARCH) {
                                titleText = contextualWebSearchTitleText
                                setOnClickListener { setCheckedTriggeringListener(!isChecked) }
                                layoutParams {
                                    width = LinearLayout.LayoutParams.MATCH_PARENT
                                    height = LinearLayout.LayoutParams.WRAP_CONTENT
                                }
                            }

                            radioButtonCell(SearchUrlCheckedItem.DUCK_DUCK_GO) {
                                titleText = duckDuckGoTitleText
                                setOnClickListener { setCheckedTriggeringListener(!isChecked) }
                                layoutParams {
                                    width = LinearLayout.LayoutParams.MATCH_PARENT
                                    height = LinearLayout.LayoutParams.WRAP_CONTENT
                                }
                            }

                            radioButtonCell(SearchUrlCheckedItem.GOOGLE) {
                                titleText = googleTitleText
                                setOnClickListener { setCheckedTriggeringListener(!isChecked) }
                                layoutParams {
                                    width = LinearLayout.LayoutParams.MATCH_PARENT
                                    height = LinearLayout.LayoutParams.WRAP_CONTENT
                                }
                            }

                            radioButtonCell(SearchUrlCheckedItem.CUSTOM) {
                                titleText = customTitleText
                                setOnClickListener { setCheckedTriggeringListener(!isChecked) }
                                layoutParams {
                                    width = LinearLayout.LayoutParams.MATCH_PARENT
                                    height = LinearLayout.LayoutParams.WRAP_CONTENT
                                }
                            }

                        }

                        textInputLayout {
                            init {
                                visibility = View.GONE
                            }

                            textInputEditText {
                                hint = customUrlHint
                                layoutParams {
                                    width = LinearLayout.LayoutParams.MATCH_PARENT
                                    height = LinearLayout.LayoutParams.WRAP_CONTENT
                                }
                            }
                        }

                        methodGroup.groupCheckedListener = { key: SearchCheckedItem, checked: Boolean ->
                            presenter.toggleSearchApproach(key, checked)
                        }

                        addressGroup.groupCheckedListener = { key: SearchUrlCheckedItem, checked: Boolean ->
                            presenter.selectSearchUrl(key, checked)
                        }
                    }

                }
            }
}