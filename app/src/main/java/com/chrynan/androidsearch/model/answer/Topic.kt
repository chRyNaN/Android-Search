package com.chrynan.androidsearch.model.answer

import com.squareup.moshi.Json

data class Topic(
        @field:Json(name = "Icon") val webIcon: WebIcon? = null,
        @field:Json(name = "FirstURL") val url: String? = null,
        @field:Json(name = "Text") val text: String? = null,
        @field:Json(name = "Result") val htmlFormattedText: String? = null
) {

    val isValid: Boolean
        get() = !url.isNullOrBlank() and !text.isNullOrBlank()
}