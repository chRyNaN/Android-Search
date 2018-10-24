package com.chrynan.androidsearch.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chrynan.aaaah.AnotherAdapter
import com.chrynan.aaaah.ViewType
import com.chrynan.androidsearch.R
import com.chrynan.androidsearch.viewmodel.TopicViewModel
import kotlinx.android.synthetic.main.adapter_topic.view.*

class TopicAdapter : AnotherAdapter<TopicViewModel>() {

    override val viewType = AdapterViewTypes.TOPIC

    override fun onHandlesItem(item: Any) = item is TopicViewModel

    override fun onCreateView(parent: ViewGroup, viewType: ViewType): View =
            LayoutInflater.from(parent.context).inflate(R.layout.adapter_topic, parent, false)

    override fun onBindItem(view: View, item: TopicViewModel) {
        view.apply {
            topicTextView?.text = item.text
            // TODO I fucked up and accidently deleted this shit when I wasn't using version control, so fix it
        }
    }
}