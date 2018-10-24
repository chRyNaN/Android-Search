package com.chrynan.androidsearch.repository

import com.chrynan.androidsearch.model.answer.InstantAnswer

interface InstantAnswerRepository {

    suspend fun getBy(query: String): InstantAnswer
}