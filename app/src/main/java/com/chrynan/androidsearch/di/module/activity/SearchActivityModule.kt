package com.chrynan.androidsearch.di.module.activity

import com.chrynan.androidsearch.di.component.layout.SearchLayoutComponent
import com.chrynan.androidsearch.di.scope.ActivityScope
import com.chrynan.androidsearch.ui.layout.SearchLayout
import com.chrynan.androidsearch.util.AppContext
import dagger.Module
import dagger.Provides

@Module(subcomponents = [SearchLayoutComponent::class])
abstract class SearchActivityModule {

    @Module
    companion object {

        @JvmStatic
        @Provides
        @ActivityScope
        fun provideSearchLayout(appContext: AppContext) = SearchLayout(appContext)
    }
}