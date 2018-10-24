package com.chrynan.androidsearch.di.module

import com.chrynan.androidsearch.provider.*
import org.koin.dsl.module.module

val PROVIDER_MODULE = module {
    single { AppProvider(repository = get(), mapper = get()) }
    single { EmailProvider(mapper = get()) }
    single { PhoneNumberProvider(mapper = get()) }
    single { WebAddressProvider(mapper = get()) }
    single { ContactProvider(mapper = get(), repository = get()) }
    single { ImageProvider(mapper = get(), repository = get()) }
    single { VideoProvider(mapper = get(), repository = get()) }
    single { AudioProvider(mapper = get(), repository = get()) }
    single { TypeAheadProvider(repository = get(), mapper = get()) }
    single { InstantAnswerProvider(repository = get(), mapper = get()) }
    single { SearchHistoryProvider(repository = get(), mapper = get()) }
    single {
        SearchProvider(
                appProvider = get(),
                audioProvider = get(),
                imageProvider = get(),
                videoProvider = get(),
                contactProvider = get(),
                emailProvider = get(),
                instantAnswerProvider = get(),
                phoneNumberProvider = get(),
                searchHistoryProvider = get(),
                typeAheadProvider = get(),
                webAddressProvider = get(),
                searchPreferences = get())
    }
}