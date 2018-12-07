package com.chrynan.androidsearch.ui.layout

import android.content.ComponentCallbacks
import android.content.Context
import android.content.res.Configuration
import android.support.v7.widget.LinearLayoutManager
import android.text.InputType
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
import com.chrynan.androidsearch.viewmodel.AutoCompleteResultViewModel
import com.chrynan.androidviews.builder.*
import com.chrynan.androidviewutils.doOnLayout
import com.chrynan.inlinepixel.dip
import com.chrynan.inlinepixel.sp
import javax.inject.Inject

class SearchLayout(private val appContext: Context) : BaseLayout(appContext),
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
    private val transparentColor by lazy { appContext.getColor(android.R.color.transparent) }
    private val settingsDrawable by lazy { appContext.resources.getDrawable(R.drawable.ic_settings) }

    override fun setupDependencies() = Injector.inject(this)

    override fun onCreateLayout(context: Context) =
            constraintLayout(context) {
                init {
                    setBackgroundColor(backgroundColor)
                }

                val searchWidget = searchWidget {
                    id = 1
                    inputType = InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS
                    elevation = dip(8).toPx().value.toFloat()
                    hint = hintText
                    maxLines = 1
                    setSingleLine(true)
                    textSize = 16 * context.resources.displayMetrics.density //sp(16f).toPx().value.toFloat()

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

                imageButton {
                    id = 3
                    setBackgroundColor(transparentColor)
                    setImageDrawable(settingsDrawable)
                    elevation = searchWidget.elevation + 1
                    bringToFront()
                    setOnClickListener { context.startActivity(SettingsActivity.newIntent(context)) }

                    constraints(this@constraintLayout) {
                        width = ConstraintSize.WrapContent
                        height = ConstraintSize.WrapContent

                        endToEndOf(searchWidget)
                        topToTopOf(searchWidget)
                        bottomToBottomOf(searchWidget)
                        marginEnd = searchBoxPadding
                        marginStart = searchBoxPadding
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