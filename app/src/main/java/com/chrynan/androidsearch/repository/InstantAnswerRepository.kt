package com.chrynan.androidsearch.repository

import com.chrynan.instantanswer.api.InstantAnswer

interface InstantAnswerRepository {

    suspend fun getBy(query: String): InstantAnswer
}