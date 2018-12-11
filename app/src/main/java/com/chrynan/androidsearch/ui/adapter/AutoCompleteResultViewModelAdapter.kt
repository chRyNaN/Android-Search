package com.chrynan.androidsearch.ui.adapter

import android.view.ViewGroup
import com.chrynan.aaaah.Adapter
import com.chrynan.aaaah.AdapterViewType
import com.chrynan.aaaah.from
import com.chrynan.androidsearch.ui.layout.AdapterAutoCompleteResultLayout
import com.chrynan.androidsearch.util.AppContext
import com.chrynan.androidsearch.util.GlideApp
import com.chrynan.androidsearch.viewmodel.AutoCompleteResultViewModel
import com.chrynan.androidviewutils.setVisibleOrGone
import javax.inject.Inject

@Adapter
class AutoCompleteResultViewModelAdapter @Inject constructor(
        appContext: AppContext,
        private val listener: AutoCompleteResultSelectedListener
) : BaseLayoutAdapter<AdapterAutoCompleteResultLayout, AutoCompleteResultViewModel>(appContext) {

    override val viewType = AdapterViewType.from(this::class.java)

    override fun onHandlesItem(item: Any) = item is AutoCompleteResultViewModel

    override fun onProvideLayout(): AdapterAutoCompleteResultLayout = AdapterAutoCompleteResultLayout(appContext)

    override fun onBindItem(layout: AdapterAutoCompleteResultLayout, item: AutoCompleteResultViewModel) {
        layout.apply {
            layoutBuilder.viewGroup.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            layoutBuilder.viewGroup.setOnClickListener { listener.onAutoCompleteResultSelected(item) }
            titleTextView.text = item.title
            descriptionTextView.text = item.description
            descriptionTextView.setVisibleOrGone(item.description != null)
            GlideApp.with(appContext)
                    .load(item.iconFetcher)
                    .placeholder(item.defaultIconResId)
                    .fallback(item.defaultIconResId)
                    .into(iconImageView)
            actionImageView.setImageDrawable(item.actionIcon)
            actionImageView.setVisibleOrGone(item.actionIcon == null)
        }
    }

    interface AutoCompleteResultSelectedListener {

        fun onAutoCompleteResultSelected(result: AutoCompleteResultViewModel)
    }
}