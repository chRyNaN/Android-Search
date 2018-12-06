@file:Suppress("unused")

package com.chrynan.androidsearch.di.module.activity

import android.content.Context
import com.chrynan.androidsearch.di.scope.ActivityScope
import com.chrynan.androidsearch.ui.layout.SearchQuerySettingsLayout
import com.chrynan.androidsearch.ui.layout.SearchSettingsLayout
import dagger.Module
import dagger.Provides

@Module
internal abstract class SettingsActivityModule {

    @Module
    companion object {

        @JvmStatic
        @ActivityScope
        @Provides
        fun provideSearchSettingsLayout(appContext: Context) = SearchSettingsLayout(appContext)

        @JvmStatic
        @ActivityScope
        @Provides
        fun provideSearchQuerySettingsLayout(appContext: Context) = SearchQuerySettingsLayout(appContext)
    }
}