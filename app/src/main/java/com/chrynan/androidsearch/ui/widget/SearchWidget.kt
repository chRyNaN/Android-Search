@file:Suppress("unused")

package com.chrynan.androidsearch.ui.widget

import android.content.Context
import android.graphics.Outline
import android.support.v7.widget.AppCompatEditText
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.view.ViewOutlineProvider
import com.chrynan.androidsearch.R
import com.chrynan.androidviews.builder.LayoutBuilder
import com.chrynan.androidviews.builder.addViewBuilderFor
import com.chrynan.androidviews.builder.viewBuilderFor

class SearchWidget : AppCompatEditText {

    var style = Style.ROUND
        set(value) {
            field = value
            requestLayout()
            invalidate()
        }
    var roundedRectangleCornerRadius = 0
        set(value) {
            field = value
            requestLayout()
            invalidate()
        }

    private val customOutlineProvider: ViewOutlineProvider by lazy {
        object : ViewOutlineProvider() {
            override fun getOutline(view: View, outline: Outline) {
                when (style) {
                    Style.ROUND -> {
                        outline.setRoundRect(0, 0, view.width, view.height, (view.height / 2).toFloat())
                    }
                    Style.ROUNDED_RECTANGLE -> {
                        outline.setRoundRect(0, 0, view.width, view.height, roundedRectangleCornerRadius.toFloat())
                    }
                    Style.RECTANGLE -> {
                        outline.setRect(0, 0, view.width, view.height)
                    }
                }
            }
        }
    }

    private val defaultBackgroundColor by lazy { context.getColor(R.color.white) }

    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, android.R.attr.editTextStyle)

    @Suppress("VARIABLE_WITH_REDUNDANT_INITIALIZER")
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        var backgroundColor = defaultBackgroundColor

        with(context.obtainStyledAttributes(attrs, R.styleable.SearchWidget)) {
            style = Style.fromIntegerValue(getInt(R.styleable.SearchWidget_style, 0))
            backgroundColor = getColor(R.styleable.SearchWidget_backgroundColor, defaultBackgroundColor)
            roundedRectangleCornerRadius = getDimensionPixelSize(R.styleable.SearchWidget_roundedRectangleCornerRadius, 0)
        }

        clipToOutline = true
        outlineProvider = customOutlineProvider
        setBackgroundColor(backgroundColor)
    }

    enum class Style {

        ROUND,
        RECTANGLE,
        ROUNDED_RECTANGLE;

        companion object {

            fun fromIntegerValue(value: Int) = when (value) {
                0 -> ROUND
                1 -> RECTANGLE
                2 -> ROUNDED_RECTANGLE
                else -> ROUND
            }
        }
    }
}

fun searchWidget(context: Context, block: (SearchWidget.() -> Unit)? = null) =
        viewBuilderFor(SearchWidget(context), block)

fun <V : ViewGroup, P : ViewGroup.LayoutParams> LayoutBuilder<V, P>.searchWidget(block: (SearchWidget.() -> Unit)? = null) =
        addViewBuilderFor(SearchWidget(viewGroup.context), block)