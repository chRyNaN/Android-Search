package com.chrynan.androidsearch.ui.adapter

import android.view.View
import android.view.ViewGroup
import com.chrynan.aaaah.AnotherAdapter
import com.chrynan.aaaah.ViewType
import com.chrynan.androidsearch.util.AppContext
import com.chrynan.androidviews.layout.AndroidLayout

abstract class BaseLayoutAdapter<L : AndroidLayout, M : Any>(protected val appContext: AppContext) : AnotherAdapter<M>() {

    abstract fun onProvideLayout(): L

    abstract fun onBindItem(layout: L, item: M)

    override fun onCreateView(parent: ViewGroup, viewType: ViewType): View {
        val layout = onProvideLayout()
        return layout.onCreateLayout(parent.context).viewGroup.apply {
            tag = layout
        }
    }

    @Suppress("UNCHECKED_CAST")
    override fun onBindItem(view: View, item: M) {
        val layout = view.tag as L
        onBindItem(layout, item)
    }
}