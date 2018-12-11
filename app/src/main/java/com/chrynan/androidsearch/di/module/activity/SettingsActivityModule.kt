@file:Suppress("unused")

package com.chrynan.androidsearch.di.module.activity

import com.chrynan.androidsearch.di.scope.ActivityScope
import com.chrynan.androidsearch.ui.layout.SearchQuerySettingsLayout
import com.chrynan.androidsearch.ui.layout.SearchSettingsLayout
import com.chrynan.androidsearch.util.AppContext
import dagger.Module
import dagger.Provides

@Module
internal abstract class SettingsActivityModule {

    @Module
    companion object {

        @JvmStatic
        @ActivityScope
        @Provides
        fun provideSearchSettingsLayout(appContext: AppContext) = SearchSettingsLayout(appContext)

        @JvmStatic
        @ActivityScope
        @Provides
        fun provideSearchQuerySettingsLayout(appContext: AppContext) = SearchQuerySettingsLayout(appContext)
    }
}