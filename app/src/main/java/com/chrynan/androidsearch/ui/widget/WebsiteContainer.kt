@file:Suppress("unused")

package com.chrynan.androidsearch.ui.widget

import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup
import android.widget.FrameLayout
import com.chrynan.androidviews.builder.LayoutBuilder
import com.chrynan.androidviews.builder.addViewBuilderFor
import mozilla.components.concept.engine.Engine
import mozilla.components.concept.engine.EngineView

class WebsiteContainer : FrameLayout {

    lateinit var engineView: EngineView

    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    fun setEngine(engine: Engine) {
        engineView = engine.createView(context)
        addView(engineView.asView())
    }
}

fun <V : ViewGroup, P : ViewGroup.LayoutParams> LayoutBuilder<V, P>.websiteContainer(block: (WebsiteContainer.() -> Unit)? = null) =
        addViewBuilderFor(WebsiteContainer(viewGroup.context), block)