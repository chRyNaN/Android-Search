package com.chrynan.androidsearch.di.module

import com.chrynan.androidsearch.mapper.*
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module.module

val MAPPER_MODULE = module {
    single { AppMapper(context = androidContext()) }
    single { ContactMapper(context = androidContext()) }
    single { EmailMapper(context = androidContext()) }
    single { PhoneNumberMapper(context = androidContext()) }
    single { SearchHistoryMapper(context = androidContext()) }
    single { TypeAheadMapper(context = androidContext()) }
    single { WebAddressMapper(context = androidContext()) }
    single { MediaMapper(context = androidContext()) }
    single { TopicMapper() }
    single { InstantAnswerMapper(topicMapper = get()) }
}