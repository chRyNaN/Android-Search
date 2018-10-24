package com.chrynan.androidsearch.provider

import com.chrynan.androidsearch.mapper.MediaMapper
import com.chrynan.androidsearch.repository.AudioMediaRepository
import com.chrynan.androidsearch.viewmodel.AutoCompleteResultViewModel
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.coroutineScope

class AudioProvider(
        private val repository: AudioMediaRepository,
        private val mapper: MediaMapper
) : ResultProvider<AutoCompleteResultViewModel.Media> {

    override suspend fun query(query: String) = coroutineScope {
        async {
            repository.getBy(query)
                    .map(mapper::map)
        }
    }
}