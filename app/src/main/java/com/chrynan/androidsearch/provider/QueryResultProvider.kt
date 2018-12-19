package com.chrynan.androidsearch.provider

interface QueryResultProvider<out T> {

    fun handlesQuery(query: String) = query.isNotBlank()

    suspend fun query(query: String): Sequence<T>
}