package com.chrynan.androidsearch.provider

import com.chrynan.androidsearch.mapper.MediaMapper
import com.chrynan.androidsearch.repository.ImageMediaRepository
import com.chrynan.androidsearch.viewmodel.AutoCompleteResultViewModel
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.coroutineScope

class ImageProvider(
        private val repository: ImageMediaRepository,
        private val mapper: MediaMapper
) : ResultProvider<AutoCompleteResultViewModel.Media> {

    override suspend fun query(query: String) = coroutineScope {
        async {
            repository.getBy(query)
                    .map(mapper::map)
        }
    }
}