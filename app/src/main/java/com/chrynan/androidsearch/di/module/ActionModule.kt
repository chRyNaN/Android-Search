package com.chrynan.androidsearch.di.module

import com.chrynan.androidsearch.action.*
import org.koin.dsl.module.module

val ACTION_MODULE = module {
    single { OpenAppAction() }
    single { OpenContactAction() }
    single { OpenDialerAction() }
    single { OpenEmailAction() }
    single { OpenFileAction() }
    single { OpenSearchAppAction() }
    single { OpenSearchUrlInBrowserAction() }
    single { OpenSmsAction() }
    single { OpenUrlAction() }
    single { SearchAction(openSearchAppAction = get(), openSearchUrlInBrowserAction = get()) }
    single {
        AutoCompleteAction(
                openAppAction = get(),
                openContactAction = get(),
                openDialerAction = get(),
                openEmailAction = get(),
                openFileAction = get(),
                openSmsAppAction = get(),
                openUrlAction = get(),
                searchAction = get())
    }
}