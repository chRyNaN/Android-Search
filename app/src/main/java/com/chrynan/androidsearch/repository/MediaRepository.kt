package com.chrynan.androidsearch.repository

import com.chrynan.androidsearch.model.Media

interface MediaRepository {

    suspend fun getBy(query: String): List<Media>
}