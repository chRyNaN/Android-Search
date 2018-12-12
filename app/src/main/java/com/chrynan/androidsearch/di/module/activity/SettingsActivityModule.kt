@file:Suppress("unused")

package com.chrynan.androidsearch.di.module.activity

import com.chrynan.androidsearch.di.scope.ActivityScope
import com.chrynan.androidsearch.navigator.SearchSettingsNavigator
import com.chrynan.androidsearch.navigator.source.SearchSettingsNavigatorSource
import com.chrynan.androidsearch.resource.source.SearchQuerySettingsLayoutResourcesSource
import com.chrynan.androidsearch.resource.source.SearchSettingsLayoutResourcesSource
import com.chrynan.androidsearch.ui.layout.SearchQuerySettingsLayout
import com.chrynan.androidsearch.ui.layout.SearchSettingsLayout
import com.chrynan.androidsearch.util.AppContext
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
internal abstract class SettingsActivityModule {

    @Module
    companion object {

        @JvmStatic
        @ActivityScope
        @Provides
        fun provideSearchSettingsLayout(appContext: AppContext, res: SearchSettingsLayoutResourcesSource) = SearchSettingsLayout(appContext, res)

        @JvmStatic
        @ActivityScope
        @Provides
        fun provideSearchQuerySettingsLayout(appContext: AppContext, res: SearchQuerySettingsLayoutResourcesSource) = SearchQuerySettingsLayout(appContext, res)
    }

    @ActivityScope
    @Binds
    abstract fun bindSearchSettingsNavigator(source: SearchSettingsNavigatorSource): SearchSettingsNavigator
}