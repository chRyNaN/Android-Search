package com.chrynan.androidsearch.di.module

import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module.module

val APP_MODULE = module {
    single { androidContext().packageManager }
}