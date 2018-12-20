package com.chrynan.androidsearch.di.component.activity

import com.chrynan.androidsearch.di.component.layout.WebLayoutComponent
import com.chrynan.androidsearch.di.module.activity.WebActivityModule
import com.chrynan.androidsearch.di.scope.ActivityScope
import com.chrynan.androidsearch.ui.activity.WebActivity
import dagger.BindsInstance
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [WebActivityModule::class])
interface WebActivityComponent {

    fun activity(): WebActivity

    fun webLayoutBuilder(): WebLayoutComponent.Builder

    fun inject(activity: WebActivity)

    @Subcomponent.Builder
    interface Builder {

        @BindsInstance
        fun activity(activity: WebActivity): Builder

        fun build(): WebActivityComponent
    }
}