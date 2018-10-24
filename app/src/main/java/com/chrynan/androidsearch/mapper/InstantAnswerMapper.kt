package com.chrynan.androidsearch.mapper

import com.chrynan.androidsearch.model.answer.InstantAnswer
import com.chrynan.androidsearch.viewmodel.InstantAnswerViewModel
import com.chrynan.mapper.UniDirectionalMapper

class InstantAnswerMapper(private val topicMapper: TopicMapper) : UniDirectionalMapper<InstantAnswer, InstantAnswerViewModel?> {

    override fun map(value: InstantAnswer) =
            when {
                value.isAnswer -> InstantAnswerViewModel.Answer(
                        title = value.answerType,
                        description = value.answer,
                        url = value.answerUrl,
                        imageUrl = value.abstractImageUrl)
                value.isDefinition -> InstantAnswerViewModel.Definition(
                        title = value.definitionSource,
                        description = value.definition,
                        url = value.definitionUrl,
                        imageUrl = value.abstractImageUrl)
                value.isRelatedTopics -> InstantAnswerViewModel.TopicList(
                        title = value.topicTitle,
                        topics = value.relatedTopics.map(topicMapper::map)
                )
                value.isResults -> InstantAnswerViewModel.TopicList(
                        title = value.topicTitle,
                        topics = value.results.map(topicMapper::map)
                )
                else -> null
            }
}