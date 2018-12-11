package com.chrynan.androidsearch.di.component.activity

import com.chrynan.androidsearch.di.component.layout.SearchLayoutComponent
import com.chrynan.androidsearch.di.module.activity.SearchActivityModule
import com.chrynan.androidsearch.di.scope.ActivityScope
import com.chrynan.androidsearch.ui.activity.SearchActivity
import dagger.BindsInstance
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [SearchActivityModule::class])
interface SearchActivityComponent {

    fun activity(): SearchActivity

    fun searchLayoutBuilder(): SearchLayoutComponent.Builder

    fun inject(activity: SearchActivity)

    @Subcomponent.Builder
    interface Builder {

        @BindsInstance
        fun activity(application: SearchActivity): Builder

        fun build(): SearchActivityComponent
    }
}