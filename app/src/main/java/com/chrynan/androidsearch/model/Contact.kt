package com.chrynan.androidsearch.model

data class Contact(
        val name: String,
        val id: String,
        val lookupKey: String,
        val photoUri: String? = null
)