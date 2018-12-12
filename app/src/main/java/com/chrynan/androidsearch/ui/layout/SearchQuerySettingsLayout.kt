package com.chrynan.androidsearch.ui.layout

import android.content.Context
import android.view.View
import android.widget.LinearLayout
import com.chrynan.androidsearch.R
import com.chrynan.androidsearch.di.Injector
import com.chrynan.androidsearch.presenter.SearchSettingsPresenter
import com.chrynan.androidsearch.ui.widget.radioButtonCellGroup
import com.chrynan.androidsearch.util.AppContext
import com.chrynan.androidviews.builder.scrollLayout
import com.chrynan.androidviews.builder.textInputEditText
import com.chrynan.androidviews.builder.textInputLayout
import com.chrynan.androidviews.builder.verticalLayout

class SearchQuerySettingsLayout(private val appContext: AppContext) : BaseLayout(appContext) {

    private val webTitleText by lazy { appContext.getString(R.string.settings_radio_button_title_web_view) }
    private val chromeCustomTabsTitleText by lazy { appContext.getString(R.string.settings_radio_button_title_chrome_custom_tabs) }
    private val browserTitleText by lazy { appContext.getString(R.string.settings_radio_button_title_browser_app) }
    private val bingTitleText by lazy { appContext.getString(R.string.settings_radio_button_title_bing) }
    private val contextualWebSearchTitleText by lazy { appContext.getString(R.string.settings_radio_button_title_contextual_web_search) }
    private val duckDuckGoTitleText by lazy { appContext.getString(R.string.settings_radio_button_title_duck_duck_go) }
    private val googleTitleText by lazy { appContext.getString(R.string.settings_radio_button_title_google) }
    private val customTitleText by lazy { appContext.getString(R.string.settings_radio_button_title_custom) }
    private val customUrlHint by lazy { appContext.getString(R.string.settings_custom_url_hint) }

    override fun setupDependencies() = Injector.inject(this)

    override fun onCreateLayout(context: Context) =
            scrollLayout(context) {

                verticalLayout {

                    radioButtonCellGroup<SearchSettingsPresenter.SearchCheckedItem> {

                        radioButtonCell(SearchSettingsPresenter.SearchCheckedItem.WEB_VIEW) {
                            titleText = webTitleText
                            setOnClickListener { setCheckedTriggeringListener(!isChecked) }
                            layoutParams {
                                width = LinearLayout.LayoutParams.MATCH_PARENT
                                height = LinearLayout.LayoutParams.WRAP_CONTENT
                            }
                        }

                        radioButtonCell(SearchSettingsPresenter.SearchCheckedItem.CHROME_CUSTOM_TAB) {
                            titleText = chromeCustomTabsTitleText
                            setOnClickListener { setCheckedTriggeringListener(!isChecked) }
                            layoutParams {
                                width = LinearLayout.LayoutParams.MATCH_PARENT
                                height = LinearLayout.LayoutParams.WRAP_CONTENT
                            }
                        }

                        radioButtonCell(SearchSettingsPresenter.SearchCheckedItem.BROWSER) {
                            titleText = browserTitleText
                            setOnClickListener { setCheckedTriggeringListener(!isChecked) }
                            layoutParams {
                                width = LinearLayout.LayoutParams.MATCH_PARENT
                                height = LinearLayout.LayoutParams.WRAP_CONTENT
                            }
                        }

                    }

                    radioButtonCellGroup<SearchSettingsPresenter.SearchUrlCheckedItem> {

                        radioButtonCell(SearchSettingsPresenter.SearchUrlCheckedItem.BING) {
                            titleText = bingTitleText
                            setOnClickListener { isChecked = !isChecked }
                            layoutParams {
                                width = LinearLayout.LayoutParams.MATCH_PARENT
                                height = LinearLayout.LayoutParams.WRAP_CONTENT
                            }
                        }

                        radioButtonCell(SearchSettingsPresenter.SearchUrlCheckedItem.CONTEXTUAL_WEB_SEARCH) {
                            titleText = contextualWebSearchTitleText
                            setOnClickListener { setCheckedTriggeringListener(!isChecked) }
                            layoutParams {
                                width = LinearLayout.LayoutParams.MATCH_PARENT
                                height = LinearLayout.LayoutParams.WRAP_CONTENT
                            }
                        }

                        radioButtonCell(SearchSettingsPresenter.SearchUrlCheckedItem.DUCK_DUCK_GO) {
                            titleText = duckDuckGoTitleText
                            setOnClickListener { setCheckedTriggeringListener(!isChecked) }
                            layoutParams {
                                width = LinearLayout.LayoutParams.MATCH_PARENT
                                height = LinearLayout.LayoutParams.WRAP_CONTENT
                            }
                        }

                        radioButtonCell(SearchSettingsPresenter.SearchUrlCheckedItem.GOOGLE) {
                            titleText = googleTitleText
                            setOnClickListener { setCheckedTriggeringListener(!isChecked) }
                            layoutParams {
                                width = LinearLayout.LayoutParams.MATCH_PARENT
                                height = LinearLayout.LayoutParams.WRAP_CONTENT
                            }
                        }

                        radioButtonCell(SearchSettingsPresenter.SearchUrlCheckedItem.CUSTOM) {
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

                }

            }
}