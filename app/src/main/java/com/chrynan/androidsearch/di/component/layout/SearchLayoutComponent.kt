package com.chrynan.androidsearch.di.component.layout

import com.chrynan.androidsearch.di.module.layout.SearchLayoutModule
import com.chrynan.androidsearch.di.scope.LayoutScope
import com.chrynan.androidsearch.ui.layout.SearchLayout
import dagger.Subcomponent

@LayoutScope
@Subcomponent(modules = [SearchLayoutModule::class])
interface SearchLayoutComponent {

    fun inject(layout: SearchLayout)

    @Subcomponent.Builder
    interface Builder {

        fun build(): SearchLayoutComponent
    }
}