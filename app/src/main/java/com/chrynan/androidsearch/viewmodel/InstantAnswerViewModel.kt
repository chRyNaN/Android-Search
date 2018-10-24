package com.chrynan.androidsearch.viewmodel

import com.chrynan.aaaah.AdapterId
import com.chrynan.aaaah.UniqueAdapterItem

sealed class InstantAnswerViewModel : UniqueAdapterItem {

    data class Answer(
            val title: String,
            override val uniqueAdapterId: AdapterId = title.hashCode().toLong(),
            val description: String,
            val imageUrl: String? = null,
            val url: String
    ) : InstantAnswerViewModel()

    data class Definition(
            val title: String,
            override val uniqueAdapterId: AdapterId = title.hashCode().toLong(),
            val description: String,
            val imageUrl: String? = null,
            val url: String
    ) : InstantAnswerViewModel()

    data class TopicList(
            val title: String,
            override val uniqueAdapterId: AdapterId = title.hashCode().toLong(),
            val topics: List<TopicViewModel>
    ) : InstantAnswerViewModel()
}