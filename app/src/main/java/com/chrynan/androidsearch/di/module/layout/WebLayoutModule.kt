@file:Suppress("unused")

package com.chrynan.androidsearch.di.module.layout

import com.chrynan.androidsearch.di.scope.LayoutScope
import com.chrynan.androidsearch.ui.layout.WebLayout
import com.chrynan.androidsearch.ui.view.WebBrowserView
import dagger.Module
import dagger.Provides

@Module
abstract class WebLayoutModule {

    @Module
    companion object {

        @JvmStatic
        @LayoutScope
        @Provides
        fun provideView(layout: WebLayout): WebBrowserView = layout
    }
}