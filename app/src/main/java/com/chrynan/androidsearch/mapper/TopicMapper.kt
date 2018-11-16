package com.chrynan.androidsearch.mapper

import com.chrynan.androidsearch.viewmodel.TopicViewModel
import com.chrynan.instantanswer.api.Result
import com.chrynan.instantanswer.api.TopicResult
import com.chrynan.mapper.UniDirectionalMapper

class TopicMapper : UniDirectionalMapper<Result, TopicViewModel> {

    override fun map(value: Result) =
            when (value) {
                is TopicResult -> TopicViewModel(
                        text = value.htmlFormattedText ?: value.text ?: "",
                        imageUrl = value.webIcon?.url,
                        url = value.url)
                else -> TopicViewModel(
                        text = "",
                        imageUrl = "",
                        url = ""
                )// TODO update this to be a different model
            }
}