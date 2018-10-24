package com.chrynan.androidsearch.model

data class Media(
        val id: Long,
        val title: String,
        val mimeType: String? = null,
        val type: Type = Type.OTHER,
        val data: String,
        val thumbnailId: Long? = null
) {

    enum class Type {

        IMAGE,
        VIDEO,
        AUDIO,
        OTHER
    }
}