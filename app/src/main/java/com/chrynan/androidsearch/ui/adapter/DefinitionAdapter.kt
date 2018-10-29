package com.chrynan.androidsearch.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chrynan.aaaah.*
import com.chrynan.androidsearch.R
import com.chrynan.androidsearch.viewmodel.InstantAnswerViewModel
import kotlinx.android.synthetic.main.adapter_instant_answer_detailed.view.*

@Adapter
class DefinitionAdapter : AnotherAdapter<InstantAnswerViewModel.Definition>() {

    override val viewType = AdapterViewType.from(this::class.java)

    override fun onHandlesItem(item: Any) = item is InstantAnswerViewModel.Definition

    override fun onCreateView(parent: ViewGroup, viewType: ViewType): View =
            LayoutInflater.from(parent.context).inflate(R.layout.adapter_instant_answer_detailed, parent, false)

    override fun onBindItem(view: View, item: InstantAnswerViewModel.Definition) {
        view.apply {
            titleTextView?.text = item.title
            descriptionTextView?.text = item.description
        }
    }
}