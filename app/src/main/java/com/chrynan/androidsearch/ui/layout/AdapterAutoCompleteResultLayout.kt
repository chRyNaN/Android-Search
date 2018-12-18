package com.chrynan.androidsearch.ui.layout

import android.content.Context
import android.widget.ImageView
import android.widget.TextView
import com.chrynan.androidsearch.resource.AdapterAutoCompleteResources
import com.chrynan.androidsearch.resource.source.AdapterAutoCompleteResourcesSource
import com.chrynan.androidsearch.util.AppContext
import com.chrynan.androidviews.builder.*
import javax.inject.Inject

class AdapterAutoCompleteResultLayout @Inject constructor(
        appContext: AppContext,
        res: AdapterAutoCompleteResourcesSource
) : BaseLayout(appContext),
        AdapterAutoCompleteResources by res {

    companion object {

        private const val ID_ICON_IMAGE_VIEW = 1
        private const val ID_TITLE_TEXT_VIEW = 2
        private const val ID_DESCRIPTION_TEXT_VIEW = 3
        private const val ID_ACTION_IMAGE_VIEW = 4
    }

    lateinit var layoutBuilder: LayoutBuilder<*, *>
    lateinit var iconImageView: ImageView
    lateinit var titleTextView: TextView
    lateinit var descriptionTextView: TextView
    lateinit var actionImageView: ImageView

    override fun onCreateLayout(context: Context): LayoutBuilder<*, *> {
        layoutBuilder = constraintLayout(context) {
            init {
                setPadding(horizontalParentPadding, verticalParentPadding, horizontalParentPadding, verticalParentPadding)
                setBackgroundResource(parentBackgroundId)
                minHeight = cellMinHeight
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
                textSize = titleTextSize
                setTextColor(titleTextColor)

                constraints(this@constraintLayout) {
                    width = ConstraintSize.MatchConstraint
                    height = ConstraintSize.WrapContent
                    marginStart = titleTextHorizontalMargin
                    marginEnd = titleTextHorizontalMargin
                    bottomToTopOf(ID_DESCRIPTION_TEXT_VIEW)
                    endToStartOf(ID_ACTION_IMAGE_VIEW)
                    startToEndOf(ID_ICON_IMAGE_VIEW)
                    topToTopOfParent()
                }
            }

            descriptionTextView = textView {
                id = ID_DESCRIPTION_TEXT_VIEW
                textSize = descriptionTextSize
                setTextColor(descriptionTextColor)

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
}