package com.chrynan.androidsearch.ui.adapter

import android.view.View
import android.view.ViewGroup
import com.chrynan.aaaah.AnotherAdapter
import com.chrynan.aaaah.ViewType
import com.chrynan.androidviews.layout.AndroidRenderLayout

abstract class BaseLayoutAdapter<M : Any> : AnotherAdapter<M>() {

    abstract val layout: AndroidRenderLayout<M>

    private lateinit var parentViewGroup: ViewGroup

    override fun onCreateView(parent: ViewGroup, viewType: ViewType): View {
        parentViewGroup = parent
        return layout.onCreateLayout(parent.context).viewGroup
    }

    override fun onBindItem(view: View, item: M) {
        val newView = layout.onRenderLayout(view.context, item).viewGroup
        parentViewGroup.removeAllViews()
        parentViewGroup.addView(newView)
    }
}