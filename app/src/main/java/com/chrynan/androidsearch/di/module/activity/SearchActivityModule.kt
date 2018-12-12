package com.chrynan.androidsearch.di.module.activity

import com.chrynan.androidsearch.di.component.layout.SearchLayoutComponent
import com.chrynan.androidsearch.di.scope.ActivityScope
import com.chrynan.androidsearch.navigator.SearchNavigator
import com.chrynan.androidsearch.navigator.source.SearchNavigatorSource
import com.chrynan.androidsearch.resource.source.SearchLayoutResourcesSource
import com.chrynan.androidsearch.ui.layout.SearchLayout
import com.chrynan.androidsearch.util.AppContext
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module(subcomponents = [SearchLayoutComponent::class])
abstract class SearchActivityModule {

    @Module
    companion object {

        @JvmStatic
        @Provides
        @ActivityScope
        fun provideSearchLayout(appContext: AppContext, res: SearchLayoutResourcesSource) = SearchLayout(appContext, res)
    }

    @Binds
    @ActivityScope
    abstract fun bindSearchNavigator(source: SearchNavigatorSource): SearchNavigator
}