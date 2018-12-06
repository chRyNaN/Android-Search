package com.chrynan.androidsearch.mapper

import com.chrynan.androidsearch.viewmodel.InstantAnswerViewModel
import com.chrynan.instantanswer.*
import com.chrynan.instantanswer.api.InstantAnswer
import com.chrynan.mapper.UniDirectionalMapper
import javax.inject.Inject

class InstantAnswerMapper @Inject constructor(private val topicMapper: TopicMapper) : UniDirectionalMapper<InstantAnswer, InstantAnswerViewModel?> {

    override fun map(value: InstantAnswer) =
            when {
                value.containsValidAnswer and value.containsValidAnswerType -> InstantAnswerViewModel.Answer(
                        title = value.answerType!!,
                        description = value.answer!!,
                        url = value.abstractUrl ?: value.definitionUrl ?: value.redirectUrl ?: "",
                        imageUrl = value.abstractImageUrl)
                value.containsValidDefinition and value.containsValidDefinitionSource and value.containsValidDefinitionUrl -> InstantAnswerViewModel.Definition(
                        title = value.definitionSource!!,
                        description = value.definition!!,
                        url = value.definitionUrl!!,
                        imageUrl = value.abstractImageUrl)
                value.containsRelatedTopics -> InstantAnswerViewModel.TopicList(
                        title = value.heading ?: "",
                        topics = value.relatedTopics.map(topicMapper::map)
                )
                value.containsResults -> InstantAnswerViewModel.TopicList(
                        title = value.heading ?: "",
                        topics = value.results.map(topicMapper::map)
                )
                else -> null
            }
}