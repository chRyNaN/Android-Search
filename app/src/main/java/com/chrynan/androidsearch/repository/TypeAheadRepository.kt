package com.chrynan.androidsearch.repository

import com.chrynan.androidsearch.model.TypeAhead

interface TypeAheadRepository {

    suspend fun getBy(query: String): List<TypeAhead>
}