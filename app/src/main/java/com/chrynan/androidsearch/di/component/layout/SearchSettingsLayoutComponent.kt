@file:Suppress("unused")

package com.chrynan.androidsearch.di.component.layout

import com.chrynan.androidsearch.di.module.layout.SearchSettingsLayoutModule
import com.chrynan.androidsearch.di.scope.LayoutScope
import com.chrynan.androidsearch.ui.layout.SearchSettingsLayout
import dagger.Subcomponent

@LayoutScope
@Subcomponent(modules = [SearchSettingsLayoutModule::class])
interface SearchSettingsLayoutComponent {

    fun inject(layout: SearchSettingsLayout)

    @Subcomponent.Builder
    interface Builder {

        fun build(): SearchSettingsLayoutComponent
    }
}