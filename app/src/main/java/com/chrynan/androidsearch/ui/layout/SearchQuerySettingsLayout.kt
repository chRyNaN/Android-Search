package com.chrynan.androidsearch.ui.layout

import android.content.Context
import android.view.View
import android.widget.LinearLayout
import com.chrynan.androidsearch.di.Injector
import com.chrynan.androidsearch.presenter.SearchSettingsPresenter
import com.chrynan.androidsearch.resource.SearchQuerySettingsLayoutResources
import com.chrynan.androidsearch.resource.source.SearchQuerySettingsLayoutResourcesSource
import com.chrynan.androidsearch.ui.widget.radioButtonCellGroup
import com.chrynan.androidsearch.util.AppContext
import com.chrynan.androidviews.builder.*

class SearchQuerySettingsLayout(
        appContext: AppContext,
        res: SearchQuerySettingsLayoutResourcesSource
) : BaseLayout(appContext),
        SearchQuerySettingsLayoutResources by res {

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

    private fun <V : LinearLayout, P : LinearLayout.LayoutParams> LayoutBuilder<V, P>.label(labelText: String) =
            textView {
                text = labelText
                //setTextColor(labelColor)
                layoutParams {
                    width = LinearLayout.LayoutParams.MATCH_PARENT
                    height = LinearLayout.LayoutParams.WRAP_CONTENT
                    //setMargins(labelStartMargin, labelTopMargin, labelEndMargin, labelBottomMargin)
                }
            }
}