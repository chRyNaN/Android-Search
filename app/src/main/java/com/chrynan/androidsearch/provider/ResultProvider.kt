package com.chrynan.androidsearch.provider

import kotlinx.coroutines.experimental.Deferred

interface ResultProvider<out T> {

    fun handlesQuery(query: String) = query.isNotBlank()

    suspend fun query(query: String): Deferred<Sequence<T>>
}