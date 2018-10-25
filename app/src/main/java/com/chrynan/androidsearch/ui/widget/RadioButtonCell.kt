package com.chrynan.androidsearch.ui.widget

import android.content.Context
import android.graphics.drawable.Drawable
import android.support.constraint.ConstraintLayout
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.CompoundButton
import com.chrynan.androidsearch.R
import com.chrynan.androidsearch.util.isVisible
import kotlinx.android.synthetic.main.widget_radio_button_cell.view.*

class RadioButtonCell : ConstraintLayout {

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
    var isChecked = false
        set(value) {
            field = value

            radioButton?.apply {
                setOnCheckedChangeListener(null)
                isChecked = value
                setOnCheckedChangeListener(onCheckedChangeListener)
            }
        }
    var checkedListener: ((Boolean) -> Unit)? = null
        set(value) {
            field = value

            onCheckedChangeListener =
                    if (value == null) null
                    else CompoundButton.OnCheckedChangeListener { _, isChecked ->
                        value.invoke(isChecked)
                    }
            radioButton?.setOnCheckedChangeListener(onCheckedChangeListener)
        }

    private var onCheckedChangeListener: CompoundButton.OnCheckedChangeListener? = null

    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, android.R.attr.editTextStyle)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        LayoutInflater.from(context).inflate(R.layout.widget_radio_button_cell, this)

        with(context.obtainStyledAttributes(attrs, R.styleable.RadioButtonCell)) {
            icon = getDrawable(R.styleable.RadioButtonCell_icon)
            titleText = getString(R.styleable.RadioButtonCell_titleText)
            descriptionText = getString(R.styleable.RadioButtonCell_descriptionText)
            isChecked = getBoolean(R.styleable.RadioButtonCell_isChecked, false)
        }
    }

    override fun setEnabled(enabled: Boolean) {
        super.setEnabled(enabled)

        radioButton?.isEnabled = enabled
        titleTextView?.isEnabled = enabled
        descriptionTextView?.isEnabled = enabled
        iconImageView?.isEnabled = enabled
    }
}