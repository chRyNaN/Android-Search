package com.chrynan.androidsearch.ui.adapter

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.text.Spannable
import android.text.SpannableString
import android.text.method.LinkMovementMethod
import android.text.style.URLSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chrynan.aaaah.AnotherAdapter
import com.chrynan.aaaah.ManagerRecyclerViewAdapter
import com.chrynan.aaaah.ViewType
import com.chrynan.androidsearch.R
import com.chrynan.androidsearch.viewmodel.InstantAnswerViewModel
import com.chrynan.androidsearch.viewmodel.TopicViewModel
import kotlinx.android.synthetic.main.adapter_topic_list.view.*

class TopicListAdapter(
        private val context: Context,
        private val topicAdapter: TopicAdapter
) : AnotherAdapter<InstantAnswerViewModel.TopicList>() {

    // This sucks but the Service Locator Library, Koin, doesn't handle generics, so initializing this here
    // because this conflicts with the main adapter
    private val managerAdapter by lazy { ManagerRecyclerViewAdapter<TopicViewModel>(setOf(topicAdapter)) }

    private val duckDuckGoText by lazy { context.getString(R.string.duck_duck_go) }
    private val duckDuckGoLink by lazy { context.getString(R.string.duck_duck_go_link) }
    private val attributionTextFormatter: (String) -> String = { context.getString(R.string.instant_answer_attribution, it) }
    private val duckDuckGoAttributionText by lazy {
        val text = attributionTextFormatter(duckDuckGoText)
        val index = text.indexOf(duckDuckGoText)
        SpannableString(text).apply {
            setSpan(URLSpan(duckDuckGoLink), index, index + duckDuckGoText.length, Spannable.SPAN_INCLUSIVE_EXCLUSIVE)
        }
    }

    private val linkMovementMethod by lazy { LinkMovementMethod.getInstance() }

    override val viewType = AdapterViewTypes2.TOPIC_LIST

    override fun onHandlesItem(item: Any) = item is InstantAnswerViewModel.TopicList

    override fun onCreateView(parent: ViewGroup, viewType: ViewType): View =
            LayoutInflater.from(parent.context).inflate(R.layout.adapter_topic_list, parent, false)

    override fun onBindItem(view: View, item: InstantAnswerViewModel.TopicList) {
        view.apply {
            topicListRecyclerView?.apply {
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                adapter = managerAdapter
            }
            attributionTextView?.apply {
                text = duckDuckGoAttributionText
                movementMethod = linkMovementMethod
            }

            managerAdapter.items = item.topics
        }
    }
}