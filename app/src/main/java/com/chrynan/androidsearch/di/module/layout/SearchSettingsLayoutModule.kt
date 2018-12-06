@file:Suppress("unused")

package com.chrynan.androidsearch.di.module.layout

import com.chrynan.androidsearch.di.scope.LayoutScope
import com.chrynan.androidsearch.ui.layout.SearchSettingsLayout
import com.chrynan.androidsearch.ui.view.SearchSettingsView
import dagger.Module
import dagger.Provides

@Module
class SearchSettingsLayoutModule {

    @Module
    companion object {

        @JvmStatic
        @LayoutScope
        @Provides
        fun provideView(layout: SearchSettingsLayout): SearchSettingsView = layout
    }
}