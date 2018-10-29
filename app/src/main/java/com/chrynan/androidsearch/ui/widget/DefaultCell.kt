package com.chrynan.androidsearch.ui.widget

import android.content.Context
import android.graphics.drawable.Drawable
import android.support.constraint.ConstraintLayout
import android.util.AttributeSet
import android.view.LayoutInflater
import com.chrynan.androidsearch.R
import com.chrynan.androidsearch.util.isVisible
import kotlinx.android.synthetic.main.widget_default_cell.view.*

class DefaultCell : ConstraintLayout {

    var icon: Drawable? = null
        set(value) {
            field = value

            iconImageView?.setImageDrawable(value)
            iconImageView?.isVisible = value != null
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
            descriptionTextView?.isVisible = !value.isNullOrBlank()
        }
    var endText: String? = null
        set(value) {
            field = value

            endTextView?.text = value
            endTextView?.isVisible = !value.isNullOrBlank()
        }

    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, android.R.attr.editTextStyle)

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