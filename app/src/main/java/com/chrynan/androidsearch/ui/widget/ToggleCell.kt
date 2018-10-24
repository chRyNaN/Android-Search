package com.chrynan.androidsearch.ui.widget

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.CompoundButton
import com.chrynan.androidsearch.R
import com.chrynan.androidsearch.util.isVisible
import kotlinx.android.synthetic.main.widget_toggle_cell.view.*

class ToggleCell : ConstraintLayout {

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
    var toggleOn = false
        set(value) {
            field = value

            toggleSwitch?.apply {
                setOnCheckedChangeListener(null)
                isChecked = value
                setOnCheckedChangeListener(onCheckedChangeListener)
            }
        }
    var toggleListener: ((Boolean) -> Unit)? = null
        set(value) {
            field = value

            onCheckedChangeListener =
                    if (value == null) null
                    else CompoundButton.OnCheckedChangeListener { _, isChecked ->
                        value.invoke(isChecked)
                    }
            toggleSwitch?.setOnCheckedChangeListener(onCheckedChangeListener)
        }
    private var onCheckedChangeListener: CompoundButton.OnCheckedChangeListener? = null

    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, android.R.attr.editTextStyle)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        LayoutInflater.from(context).inflate(R.layout.widget_toggle_cell, this)

        with(context.obtainStyledAttributes(attrs, R.styleable.ToggleCell)) {
            titleText = getString(R.styleable.ToggleCell_titleText)
            descriptionText = getString(R.styleable.ToggleCell_descriptionText)
            toggleOn = getBoolean(R.styleable.ToggleCell_toggleOn, false)
        }
    }
}