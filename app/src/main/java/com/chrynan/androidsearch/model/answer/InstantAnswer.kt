package com.chrynan.androidsearch.model.answer

import com.squareup.moshi.Json

data class InstantAnswer(
        @field:Json(name = "RelatedTopics") val relatedTopics: List<Topic>,
        @field:Json(name = "Results") val results: List<Topic>,
        @field:Json(name = "Redirect") val redirectUrl: String,
        @field:Json(name = "Type") val type: String,
        @field:Json(name = "Abstract") val abstract: String,
        @field:Json(name = "AbstractText") val abstractText: String,
        @field:Json(name = "AbstractSource") val abstractSource: String,
        @field:Json(name = "AbstractURL") val abstractUrl: String,
        @field:Json(name = "Image") val abstractImageUrl: String,
        @field:Json(name = "Heading") val abstractTopic: String,
        @field:Json(name = "Answer") val answer: String,
        @field:Json(name = "AnswerType") val answerType: String,
        @field:Json(name = "Definition") val definition: String,
        @field:Json(name = "DefinitionSource") val definitionSource: String,
        @field:Json(name = "DefinitionURL") val definitionUrl: String
) {

    val isAnswer: Boolean
        get() = !answer.isBlank() and !answerType.isBlank()

    val isDefinition: Boolean
        get() = !definition.isBlank() and !definitionSource.isBlank() and !definitionUrl.isBlank()

    val isRelatedTopics: Boolean
        get() = relatedTopics.isNotEmpty()

    val isResults: Boolean
        get() = results.isNotEmpty()

    val answerUrl: String
        get() = if (abstract.isBlank()) redirectUrl else abstractUrl

    val topicTitle: String
        get() = abstract
}