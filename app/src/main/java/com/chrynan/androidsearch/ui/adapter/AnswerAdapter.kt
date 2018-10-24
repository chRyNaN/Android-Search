package com.chrynan.androidsearch.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chrynan.aaaah.AnotherAdapter
import com.chrynan.aaaah.ViewType
import com.chrynan.androidsearch.R
import com.chrynan.androidsearch.viewmodel.InstantAnswerViewModel
import kotlinx.android.synthetic.main.adapter_instant_answer_detailed.view.*

class AnswerAdapter : AnotherAdapter<InstantAnswerViewModel.Answer>() {

    override val viewType = AdapterViewTypes.ANSWER

    override fun onHandlesItem(item: Any) = item is InstantAnswerViewModel.Answer

    override fun onCreateView(parent: ViewGroup, viewType: ViewType): View =
            LayoutInflater.from(parent.context).inflate(R.layout.adapter_instant_answer_detailed, parent, false)

    override fun onBindItem(view: View, item: InstantAnswerViewModel.Answer) {
        view.apply {
            titleTextView?.text = item.title
            descriptionTextView?.text = item.description
        }
    }
}