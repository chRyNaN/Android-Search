package com.chrynan.androidsearch.di.module.activity

import com.chrynan.androidsearch.di.component.layout.WebLayoutComponent
import com.chrynan.androidsearch.di.scope.ActivityScope
import com.chrynan.androidsearch.ui.layout.WebLayout
import com.chrynan.androidsearch.util.AppContext
import dagger.Module
import dagger.Provides

@Module(subcomponents = [WebLayoutComponent::class])
internal abstract class WebActivityModule {

    @Module
    companion object {

        @JvmStatic
        @ActivityScope
        @Provides
        fun provideWebLayout(appContext: AppContext) = WebLayout(appContext)
    }
}