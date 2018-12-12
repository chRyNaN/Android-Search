@file:Suppress("unused")

package com.chrynan.androidsearch.ui.widget

import android.content.Context
import android.graphics.drawable.Drawable
import android.support.constraint.ConstraintLayout
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.CompoundButton
import com.chrynan.androidsearch.R
import com.chrynan.androidviews.builder.LayoutBuilder
import com.chrynan.androidviews.builder.addViewBuilderFor
import com.chrynan.androidviews.builder.viewBuilderFor
import com.chrynan.androidviewutils.setVisibleOrGone
import kotlinx.android.synthetic.main.widget_radio_button_cell.view.*

class RadioButtonCell : ConstraintLayout {

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

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

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

    fun setCheckedTriggeringListener(value: Boolean) {
        radioButton?.isChecked = value
    }
}

fun radioButtonCell(context: Context, block: (RadioButtonCell.() -> Unit)? = null) =
        viewBuilderFor(RadioButtonCell(context), block)

fun <V : ViewGroup, P : ViewGroup.LayoutParams> LayoutBuilder<V, P>.radioButtonCell(block: (RadioButtonCell.() -> Unit)? = null) =
        addViewBuilderFor(RadioButtonCell(viewGroup.context), block)