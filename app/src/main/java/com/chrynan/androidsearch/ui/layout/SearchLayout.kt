package com.chrynan.androidsearch.ui.layout

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.text.InputType
import com.chrynan.aaaah.ManagerRecyclerViewAdapter
import com.chrynan.aaaah.UniqueAdapterItem
import com.chrynan.accore.runOnAndroidUI
import com.chrynan.acview.onEnterAction
import com.chrynan.acview.onTextChanged
import com.chrynan.androidsearch.di.Injector
import com.chrynan.androidsearch.navigator.SearchNavigator
import com.chrynan.androidsearch.presenter.SearchPresenter
import com.chrynan.androidsearch.resource.SearchLayoutResources
import com.chrynan.androidsearch.resource.source.SearchLayoutResourcesSource
import com.chrynan.androidsearch.ui.adapter.AutoCompleteResultViewModelAdapter
import com.chrynan.androidsearch.ui.widget.searchWidget
import com.chrynan.androidsearch.util.AppContext
import com.chrynan.androidsearch.viewmodel.AutoCompleteResultViewModel
import com.chrynan.androidviews.builder.*
import com.chrynan.androidviewutils.doOnLayout
import com.chrynan.inlinepixel.dip
import javax.inject.Inject

class SearchLayout(
        private val appContext: AppContext,
        res: SearchLayoutResourcesSource
) : BaseLayout(appContext),
        AutoCompleteResultViewModelAdapter.AutoCompleteResultSelectedListener,
        SearchLayoutResources by res {

    companion object {

        private const val ID_SEARCH_WIDGET = 1
        private const val ID_RECYCLER_VIEW = 2
        private const val ID_IMAGE_BUTTON = 3
    }

    @Inject
    lateinit var managerAdapter: ManagerRecyclerViewAdapter<UniqueAdapterItem>
    @Inject
    lateinit var presenter: SearchPresenter
    @Inject
    lateinit var navigator: SearchNavigator

    override fun setupDependencies() = Injector.inject(this)

    override fun onCreateLayout(context: Context) =
            constraintLayout(context) {
                init {
                    setBackgroundColor(backgroundColor)
                }

                val searchWidget = searchWidget {
                    id = ID_SEARCH_WIDGET
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
                    id = ID_RECYCLER_VIEW
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
                    id = ID_IMAGE_BUTTON
                    setBackgroundColor(transparentColor)
                    setImageDrawable(settingsDrawable)
                    elevation = searchWidget.elevation + 1
                    bringToFront()
                    setOnClickListener { navigator.goToSettings() }

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


    override fun onAutoCompleteResultSelected(result: AutoCompleteResultViewModel) {
        presenter.handleSelection(appContext, result)
    }
}