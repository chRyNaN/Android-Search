package com.chrynan.androidsearch.ui.layout

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.chrynan.androidsearch.R
import com.chrynan.androidsearch.ui.adapter.AutoCompleteResultViewModelAdapter
import com.chrynan.androidsearch.util.AppContext
import com.chrynan.androidsearch.util.GlideApp
import com.chrynan.androidsearch.viewmodel.AutoCompleteResultViewModel
import com.chrynan.androidviews.builder.*
import javax.inject.Inject

class AdapterAutoCompleteResultLayout @Inject constructor(
        appContext: AppContext,
        private val listener: AutoCompleteResultViewModelAdapter.AutoCompleteResultSelectedListener
) : BaseRenderLayout<AutoCompleteResultViewModel>(appContext) {

    companion object {

        private const val ID_ICON_IMAGE_VIEW = 1
        private const val ID_TITLE_TEXT_VIEW = 2
        private const val ID_DESCRIPTION_TEXT_VIEW = 3
        private const val ID_ACTION_IMAGE_VIEW = 4
    }

    private val horizontalParentPadding by lazy { appContext.resources.getDimensionPixelOffset(R.dimen.default_screen_margin) }
    private val verticalParentPadding by lazy { appContext.resources.getDimensionPixelOffset(R.dimen.spacing_small) }
    private val titleTextStartMargin by lazy { appContext.resources.getDimensionPixelOffset(R.dimen.spacing_small) }
    private val parentBackground by lazy { appContext.resources.getDrawable(android.R.drawable.list_selector_background, null) }
    private val iconSize by lazy { appContext.resources.getDimensionPixelSize(R.dimen.app_list_item_icon_size) }

    private lateinit var layoutBuilder: LayoutBuilder<*, *>
    private lateinit var iconImageView: ImageView
    private lateinit var titleTextView: TextView
    private lateinit var descriptionTextView: TextView
    private lateinit var actionImageView: ImageView

    override fun onCreateLayout(context: Context): LayoutBuilder<*, *> {
        layoutBuilder = constraintLayout(context) {
            init {
                setPadding(horizontalParentPadding, verticalParentPadding, horizontalParentPadding, verticalParentPadding)
                background = parentBackground
            }

            iconImageView = imageView {
                id = ID_ICON_IMAGE_VIEW
                constraints(this@constraintLayout) {
                    width = ConstraintSize.ExactPixel(iconSize)
                    height = ConstraintSize.ExactPixel(iconSize)
                    startToStartOfParent()
                    topToBottomOfParent()
                    bottomToTopOfParent()
                }
            }

            titleTextView = textView {
                id = ID_TITLE_TEXT_VIEW
                constraints(this@constraintLayout) {
                    width = ConstraintSize.MatchConstraint
                    height = ConstraintSize.WrapContent
                    marginStart = titleTextStartMargin
                    bottomToTopOf(ID_DESCRIPTION_TEXT_VIEW)
                    endToStartOf(ID_ACTION_IMAGE_VIEW)
                    startToEndOf(ID_ICON_IMAGE_VIEW)
                    topToTopOfParent()
                }
            }

            descriptionTextView = textView {
                id = ID_DESCRIPTION_TEXT_VIEW
                constraints(this@constraintLayout) {
                    width = ConstraintSize.MatchConstraint
                    height = ConstraintSize.WrapContent
                    bottomToBottomOfParent()
                    endToEndOf(ID_TITLE_TEXT_VIEW)
                    startToStartOf(ID_TITLE_TEXT_VIEW)
                    topToBottomOf(ID_TITLE_TEXT_VIEW)
                }
            }

            actionImageView = imageView {
                id = ID_ACTION_IMAGE_VIEW
                constraints(this@constraintLayout) {
                    width = ConstraintSize.WrapContent
                    height = ConstraintSize.WrapContent
                    bottomToBottomOfParent()
                    topToTopOfParent()
                    endToEndOfParent()
                }
            }
        }

        return layoutBuilder
    }

    override fun onRenderLayout(context: Context, item: AutoCompleteResultViewModel): LayoutBuilder<*, *> {
        layoutBuilder.viewGroup.setOnClickListener { listener.onAutoCompleteResultSelected(item) }
        titleTextView.text = item.title
        descriptionTextView.text = item.description
        descriptionTextView.visibility = if (item.description == null) View.GONE else View.VISIBLE
        GlideApp.with(context)
                .load(item.iconFetcher)
                .placeholder(item.defaultIconResId)
                .fallback(item.defaultIconResId)
                .into(iconImageView)
        actionImageView.setImageDrawable(item.actionIcon)
        actionImageView.visibility = if (item.actionIcon == null) View.GONE else View.VISIBLE

        return layoutBuilder
    }
}