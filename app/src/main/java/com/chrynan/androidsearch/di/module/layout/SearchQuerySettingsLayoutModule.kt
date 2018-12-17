package com.chrynan.androidsearch.di.module.layout

import com.chrynan.androidsearch.di.scope.LayoutScope
import com.chrynan.androidsearch.ui.layout.SearchQuerySettingsLayout
import com.chrynan.androidsearch.ui.view.SearchQuerySettingsView
import dagger.Module
import dagger.Provides

@Module
class SearchQuerySettingsLayoutModule {

    @Module
    companion object {

        @JvmStatic
        @LayoutScope
        @Provides
        fun provideView(layout: SearchQuerySettingsLayout): SearchQuerySettingsView = layout
    }
}