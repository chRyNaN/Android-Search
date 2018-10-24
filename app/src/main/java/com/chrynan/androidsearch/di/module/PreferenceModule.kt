package com.chrynan.androidsearch.di.module

import com.chrynan.androidsearch.preference.SearchPreferences
import com.chrynan.androidsearch.preference.source.SearchPreferencesSource
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module.module

val PREFERENCE_MODULE = module {
    single { SearchPreferencesSource(context = androidContext()) as SearchPreferences }
}