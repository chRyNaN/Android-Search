package com.chrynan.androidsearch.mapper

import com.chrynan.androidsearch.model.answer.Topic
import com.chrynan.androidsearch.viewmodel.TopicViewModel
import com.chrynan.mapper.UniDirectionalMapper

class TopicMapper : UniDirectionalMapper<Topic, TopicViewModel> {

    override fun map(value: Topic) =
            TopicViewModel(
                    text = value.htmlFormattedText ?: value.text ?: "",
                    imageUrl = value.webIcon?.url,
                    url = value.url)
}