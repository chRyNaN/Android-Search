package com.chrynan.androidsearch.ui.layout

import android.content.ComponentCallbacks
import android.content.Context
import android.content.res.Configuration
import android.support.v7.widget.LinearLayoutManager
import com.chrynan.aaaah.ManagerRecyclerViewAdapter
import com.chrynan.aaaah.UniqueAdapterItem
import com.chrynan.accore.runOnAndroidUI
import com.chrynan.acview.onEnterAction
import com.chrynan.acview.onTextChanged
import com.chrynan.androidsearch.R
import com.chrynan.androidsearch.di.Injector
import com.chrynan.androidsearch.presenter.SearchPresenter
import com.chrynan.androidsearch.ui.activity.SettingsActivity
import com.chrynan.androidsearch.ui.adapter.AutoCompleteResultViewModelAdapter
import com.chrynan.androidsearch.ui.widget.searchWidget
import com.chrynan.androidsearch.util.doOnLayout
import com.chrynan.androidsearch.viewmodel.AutoCompleteResultViewModel
import com.chrynan.androidviews.builder.*
import com.chrynan.inlinepixel.dip
import javax.inject.Inject

class SearchLayout(private val appContext: Context) : BaseLayout(),
        ComponentCallbacks,
        AutoCompleteResultViewModelAdapter.AutoCompleteResultSelectedListener {

    @Inject
    lateinit var managerAdapter: ManagerRecyclerViewAdapter<UniqueAdapterItem>
    @Inject
    lateinit var presenter: SearchPresenter

    private val backgroundColor by lazy { appContext.resources.getColor(R.color.search_background_color, null) }
    private val hintText by lazy { appContext.getString(R.string.search_hint) }
    private val searchBoxMargin by lazy { appContext.resources.getDimensionPixelOffset(R.dimen.spacing_xsmall) }
    private val searchBoxPadding by lazy { appContext.resources.getDimensionPixelOffset(R.dimen.spacing_small) }
    private val settingsButtonText by lazy { "Settings" }

    override fun setupDependencies() = Injector.inject(this)

    override fun layout(context: Context) =
            constraintLayout(context) {
                init {
                    setBackgroundColor(backgroundColor)
                }

                val searchWidget = searchWidget {
                    id = 1
                    elevation = dip(8).toPx().value.toFloat()
                    hint = hintText
                    maxLines = 1
                    setSingleLine(true)
                    textSize = dip(18f).toPx().value.toFloat()

                    runOnAndroidUI {
                        onTextChanged { presenter.performQuery(it.charSequence.toString()) }
                        onEnterAction { presenter.performSearch(context, text.toString()) }
                    }

                    constraints(this@constraintLayout) {
                        width = ConstraintSize.MatchConstraint
                        height = ConstraintSize.WrapContent

                        margin(ConstraintSide.START, searchBoxMargin)
                        margin(ConstraintSide.END, searchBoxMargin)
                        margin(ConstraintSide.TOP, searchBoxMargin)
                        setPadding(searchBoxPadding, 0, searchBoxPadding, 0)

                        startToStartOfParent()
                        endToEndOfParent()
                        topToTopOfParent()
                    }
                }

                recyclerView {
                    id = 2
                    clipToPadding = false
                    setHasFixedSize(true)
                    layoutManager = LinearLayoutManager(context)
                    adapter = managerAdapter

                    constraints(this@constraintLayout) {
                        width = ConstraintSize.MatchConstraint
                        height = ConstraintSize.MatchConstraint

                        startToStartOfParent()
                        endToEndOfParent()
                        topToBottomOf(searchWidget.id)
                        bottomToBottomOfParent()

                        doOnLayout {
                            setPadding(paddingLeft,
                                    paddingTop + searchWidget.measuredHeight,
                                    paddingRight,
                                    paddingBottom)
                        }
                    }
                }

                button {
                    id = 3
                    text = settingsButtonText
                    setOnClickListener { context.startActivity(SettingsActivity.newIntent(context)) }

                    constraints(this@constraintLayout) {
                        width = ConstraintSize.WrapContent
                        height = ConstraintSize.WrapContent

                        startToStartOfParent()
                        endToEndOfParent()
                        bottomToBottomOfParent()
                    }
                }
            }

    override fun onLowMemory() {
    }

    override fun onConfigurationChanged(newConfig: Configuration?) {
    }

    override fun onAutoCompleteResultSelected(result: AutoCompleteResultViewModel) {
        presenter.handleSelection(appContext, result)
    }
}