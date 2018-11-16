package com.chrynan.androidsearch.provider

import com.chrynan.androidsearch.mapper.MediaMapper
import com.chrynan.androidsearch.repository.VideoMediaRepository
import com.chrynan.androidsearch.viewmodel.AutoCompleteResultViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope

class VideoProvider(
        private val repository: VideoMediaRepository,
        private val mapper: MediaMapper
) : ResultProvider<AutoCompleteResultViewModel.Media> {

    override suspend fun query(query: String) = coroutineScope {
        async {
            repository.getBy(query)
                    .map(mapper::map)
        }
    }
}