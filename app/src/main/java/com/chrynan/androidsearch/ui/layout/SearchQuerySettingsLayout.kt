package com.chrynan.androidsearch.ui.layout

import android.content.Context
import android.view.View
import android.widget.LinearLayout
import com.chrynan.androidsearch.di.Injector
import com.chrynan.androidsearch.presenter.SearchSettingsPresenter
import com.chrynan.androidsearch.resource.SearchQuerySettingsResources
import com.chrynan.androidsearch.ui.widget.radioButtonCellGroup
import com.chrynan.androidsearch.util.AppContext
import com.chrynan.androidviews.builder.scrollLayout
import com.chrynan.androidviews.builder.textInputEditText
import com.chrynan.androidviews.builder.textInputLayout
import com.chrynan.androidviews.builder.verticalLayout
import javax.inject.Inject

class SearchQuerySettingsLayout(appContext: AppContext) : BaseLayout(appContext) {

    @Inject
    lateinit var res: SearchQuerySettingsResources

    override fun setupDependencies() = Injector.inject(this)

    override fun onCreateLayout(context: Context) =
            scrollLayout(context) {

                verticalLayout {

                    radioButtonCellGroup<SearchSettingsPresenter.SearchCheckedItem> {

                        radioButtonCell(SearchSettingsPresenter.SearchCheckedItem.WEB_VIEW) {
                            titleText = res.webTitleText
                            setOnClickListener { setCheckedTriggeringListener(!isChecked) }
                            layoutParams {
                                width = LinearLayout.LayoutParams.MATCH_PARENT
                                height = LinearLayout.LayoutParams.WRAP_CONTENT
                            }
                        }

                        radioButtonCell(SearchSettingsPresenter.SearchCheckedItem.CHROME_CUSTOM_TAB) {
                            titleText = res.chromeCustomTabsTitleText
                            setOnClickListener { setCheckedTriggeringListener(!isChecked) }
                            layoutParams {
                                width = LinearLayout.LayoutParams.MATCH_PARENT
                                height = LinearLayout.LayoutParams.WRAP_CONTENT
                            }
                        }

                        radioButtonCell(SearchSettingsPresenter.SearchCheckedItem.BROWSER) {
                            titleText = res.browserTitleText
                            setOnClickListener { setCheckedTriggeringListener(!isChecked) }
                            layoutParams {
                                width = LinearLayout.LayoutParams.MATCH_PARENT
                                height = LinearLayout.LayoutParams.WRAP_CONTENT
                            }
                        }

                    }

                    radioButtonCellGroup<SearchSettingsPresenter.SearchUrlCheckedItem> {

                        radioButtonCell(SearchSettingsPresenter.SearchUrlCheckedItem.BING) {
                            titleText = res.bingTitleText
                            setOnClickListener { isChecked = !isChecked }
                            layoutParams {
                                width = LinearLayout.LayoutParams.MATCH_PARENT
                                height = LinearLayout.LayoutParams.WRAP_CONTENT
                            }
                        }

                        radioButtonCell(SearchSettingsPresenter.SearchUrlCheckedItem.CONTEXTUAL_WEB_SEARCH) {
                            titleText = res.contextualWebSearchTitleText
                            setOnClickListener { setCheckedTriggeringListener(!isChecked) }
                            layoutParams {
                                width = LinearLayout.LayoutParams.MATCH_PARENT
                                height = LinearLayout.LayoutParams.WRAP_CONTENT
                            }
                        }

                        radioButtonCell(SearchSettingsPresenter.SearchUrlCheckedItem.DUCK_DUCK_GO) {
                            titleText = res.duckDuckGoTitleText
                            setOnClickListener { setCheckedTriggeringListener(!isChecked) }
                            layoutParams {
                                width = LinearLayout.LayoutParams.MATCH_PARENT
                                height = LinearLayout.LayoutParams.WRAP_CONTENT
                            }
                        }

                        radioButtonCell(SearchSettingsPresenter.SearchUrlCheckedItem.GOOGLE) {
                            titleText = res.googleTitleText
                            setOnClickListener { setCheckedTriggeringListener(!isChecked) }
                            layoutParams {
                                width = LinearLayout.LayoutParams.MATCH_PARENT
                                height = LinearLayout.LayoutParams.WRAP_CONTENT
                            }
                        }

                        radioButtonCell(SearchSettingsPresenter.SearchUrlCheckedItem.CUSTOM) {
                            titleText = res.customTitleText
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
                            hint = res.customUrlHint
                            layoutParams {
                                width = LinearLayout.LayoutParams.MATCH_PARENT
                                height = LinearLayout.LayoutParams.WRAP_CONTENT
                            }
                        }
                    }

                }

            }
}