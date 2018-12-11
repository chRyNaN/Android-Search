@file:Suppress("unused")

package com.chrynan.androidsearch.ui.widget

import android.content.Context
import android.graphics.drawable.Drawable
import android.support.constraint.ConstraintLayout
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.ViewGroup
import com.chrynan.androidsearch.R
import com.chrynan.androidviews.builder.LayoutBuilder
import com.chrynan.androidviews.builder.addViewBuilderFor
import com.chrynan.androidviews.builder.viewBuilderFor
import com.chrynan.androidviewutils.setVisibleOrGone
import kotlinx.android.synthetic.main.widget_default_cell.view.*

class DefaultCell : ConstraintLayout {

    var icon: Drawable? = null
        set(value) {
            field = value

            iconImageView?.setImageDrawable(value)
            iconImageView?.setVisibleOrGone(value != null)
        }
    var titleText: String? = null
        set(value) {
            field = value

            titleTextView?.text = value
        }
    var descriptionText: String? = null
        set(value) {
            field = value

            descriptionTextView?.text = value
            descriptionTextView?.setVisibleOrGone(!value.isNullOrBlank())
        }
    var endText: String? = null
        set(value) {
            field = value

            endTextView?.text = value
            endTextView?.setVisibleOrGone(!value.isNullOrBlank())
        }

    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        LayoutInflater.from(context).inflate(R.layout.widget_default_cell, this)

        with(context.obtainStyledAttributes(attrs, R.styleable.DefaultCell)) {
            icon = getDrawable(R.styleable.DefaultCell_icon)
            titleText = getString(R.styleable.DefaultCell_titleText)
            descriptionText = getString(R.styleable.DefaultCell_descriptionText)
            endText = getString(R.styleable.DefaultCell_endText)
        }
    }
}

fun defaultCell(context: Context, block: (DefaultCell.() -> Unit)? = null) =
        viewBuilderFor(DefaultCell(context), block)

fun <V : ViewGroup, P : ViewGroup.LayoutParams> LayoutBuilder<V, P>.defaultCell(block: (DefaultCell.() -> Unit)? = null) =
        addViewBuilderFor(DefaultCell(viewGroup.context), block)