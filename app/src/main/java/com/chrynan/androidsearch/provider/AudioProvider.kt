package com.chrynan.androidsearch.provider

import com.chrynan.androidsearch.mapper.MediaMapper
import com.chrynan.androidsearch.repository.AudioMediaRepository
import com.chrynan.androidsearch.viewmodel.AutoCompleteResultViewModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AudioProvider @Inject constructor(
        private val repository: AudioMediaRepository,
        private val mapper: MediaMapper
) : QueryResultProvider<AutoCompleteResultViewModel.Media> {

    override suspend fun query(query: String) =
            repository.getBy(query)
                    .map(mapper::map)
}