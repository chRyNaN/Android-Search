package com.chrynan.androidsearch.di.component.layout

import com.chrynan.androidsearch.di.module.layout.WebLayoutModule
import com.chrynan.androidsearch.di.scope.LayoutScope
import com.chrynan.androidsearch.ui.layout.WebLayout
import dagger.Subcomponent

@LayoutScope
@Subcomponent(modules = [WebLayoutModule::class])
interface WebLayoutComponent {

    fun inject(layout: WebLayout)

    @Subcomponent.Builder
    interface Builder {

        fun build(): WebLayoutComponent
    }
}