@file:Suppress("unused")

package com.chrynan.androidsearch.di.module

import com.chrynan.androidsearch.repository.*
import com.chrynan.androidsearch.repository.source.*
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
internal abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindApplicationRepository(source: ApplicationInfoSource): ApplicationInfoRepository

    @Binds
    @Singleton
    abstract fun bindContactRepository(source: ContactSource): ContactRepository

    @Binds
    @Singleton
    abstract fun bindImageMediaRepository(source: ImageMediaSource): ImageMediaRepository

    @Binds
    @Singleton
    abstract fun bindVideoMediaRepository(source: VideoMediaSource): VideoMediaRepository

    @Binds
    @Singleton
    abstract fun bindAudioMediaRepository(source: AudioMediaSource): AudioMediaRepository

    @Binds
    @Singleton
    abstract fun bindTypeAheadRepository(source: TypeAheadContextualWebSource): TypeAheadRepository

    @Binds
    @Singleton
    abstract fun bindSearchHistoryRepository(source: SearchHistorySource): SearchHistoryRepository
}