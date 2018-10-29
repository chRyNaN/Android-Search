package com.chrynan.androidsearch.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chrynan.aaaah.AnotherAdapter
import com.chrynan.aaaah.ViewType
import com.chrynan.androidsearch.R
import com.chrynan.androidsearch.util.GlideApp
import com.chrynan.androidsearch.util.loadImageAsync
import com.chrynan.androidsearch.viewmodel.AutoCompleteResultViewModel
import kotlinx.android.synthetic.main.adapter_auto_complete_result_view_model.view.*

class AutoCompleteResultViewModelAdapter(private val listener: AutoCompleteResultSelectedListener) : AnotherAdapter<AutoCompleteResultViewModel>() {

    override val viewType = AdapterViewTypes2.AUTO_COMPLETE_RESULT

    override fun onHandlesItem(item: Any) = item is AutoCompleteResultViewModel

    override fun onCreateView(parent: ViewGroup, viewType: ViewType): View =
            LayoutInflater.from(parent.context).inflate(R.layout.adapter_auto_complete_result_view_model, parent, false)

    override fun onBindItem(view: View, item: AutoCompleteResultViewModel) {
        view.apply {
            setOnClickListener { listener.onAutoCompleteResultSelected(item) }
            titleTextView?.text = item.title
            descriptionTextView?.text = item.description
            descriptionTextView?.visibility = if (item.description == null) View.GONE else View.VISIBLE
            iconImageView?.apply {
                GlideApp.with(context)
                        .load(item.iconFetcher)
                        .placeholder(item.defaultIconResId)
                        .fallback(item.defaultIconResId)
                        .into(this)
            }
            item.iconFetcher?.let { iconImageView?.loadImageAsync(it) }
            actionImageView?.setImageDrawable(item.actionIcon)
            actionImageView?.visibility = if (item.actionIcon == null) View.GONE else View.VISIBLE
        }
    }

    interface AutoCompleteResultSelectedListener {

        fun onAutoCompleteResultSelected(result: AutoCompleteResultViewModel)
    }
}