@file:Suppress("unused")

package com.chrynan.androidsearch.di.module

import com.chrynan.androidsearch.preference.SearchPreferences
import com.chrynan.androidsearch.preference.source.SearchPreferencesSource
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
internal abstract class PreferenceModule {

    @Binds
    @Singleton
    abstract fun bindSearchPreferences(source: SearchPreferencesSource): SearchPreferences
}