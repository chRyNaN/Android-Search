package com.chrynan.androidsearch.di.module

import com.chrynan.androidsearch.repository.*
import com.chrynan.androidsearch.repository.source.*
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module.module

val REPOSITORY_MODULE = module {
    single { ApplicationInfoSource(packageManager = get()) as ApplicationInfoRepository }
    single { ContactSource(context = androidContext()) as ContactRepository }
    single { ImageMediaSource(context = androidContext()) as ImageMediaRepository }
    single { VideoMediaSource(context = androidContext()) as VideoMediaRepository }
    single { AudioMediaSource(context = androidContext()) as AudioMediaRepository }
    single { TypeAheadContextualWebSource(webService = get()) as TypeAheadRepository }
    single { DuckDuckGoInstantAnswerSource(webService = get()) as InstantAnswerRepository }
    single { SearchHistorySource() as SearchHistoryRepository }
}