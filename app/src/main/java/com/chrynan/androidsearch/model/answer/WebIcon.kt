package com.chrynan.androidsearch.model.answer

import com.squareup.moshi.Json

data class WebIcon(
        @field:Json(name = "URL") val url: String,
        @field:Json(name = "Height") val heightString: String? = null,
        @field:Json(name = "Width") val widthString: String? = null
) {

    val suggestedHeight: Int
        get() = heightString?.toIntOrNull() ?: 0

    val suggestedWidth: Int
        get() = widthString?.toIntOrNull() ?: 0
}