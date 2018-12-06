@file:Suppress("unused")

package com.chrynan.androidsearch.di.component.layout

import com.chrynan.androidsearch.di.module.layout.SearchQuerySettingsLayoutModule
import com.chrynan.androidsearch.di.scope.LayoutScope
import com.chrynan.androidsearch.ui.layout.SearchQuerySettingsLayout
import dagger.Subcomponent

@LayoutScope
@Subcomponent(modules = [SearchQuerySettingsLayoutModule::class])
interface SearchQuerySettingsLayoutComponent {

    fun inject(layout: SearchQuerySettingsLayout)

    @Subcomponent.Builder
    interface Builder {

        fun build(): SearchQuerySettingsLayoutComponent
    }
}