package com.chrynan.androidsearch.provider

import com.chrynan.androidsearch.mapper.InstantAnswerMapper
import com.chrynan.androidsearch.repository.InstantAnswerRepository
import com.chrynan.androidsearch.viewmodel.InstantAnswerViewModel
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.coroutineScope

class InstantAnswerProvider(
        private val repository: InstantAnswerRepository,
        private val mapper: InstantAnswerMapper
) : ResultProvider<InstantAnswerViewModel> {

    override suspend fun query(query: String) = coroutineScope {
        async {
            try {
                sequenceOf(repository.getBy(query))
                        .map(mapper::map)
                        .filterNotNull()
            } catch (e: Exception) {
                emptySequence<InstantAnswerViewModel>()
            }
        }
    }
}