@file:Suppress("unused")

package com.chrynan.androidsearch.di.component.activity

import com.chrynan.androidsearch.di.component.layout.SearchQuerySettingsLayoutComponent
import com.chrynan.androidsearch.di.component.layout.SearchSettingsLayoutComponent
import com.chrynan.androidsearch.di.module.activity.SettingsActivityModule
import com.chrynan.androidsearch.di.scope.ActivityScope
import com.chrynan.androidsearch.ui.activity.SettingsActivity
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [SettingsActivityModule::class])
interface SettingsActivityComponent {

    fun searchSettingsLayoutBuilder(): SearchSettingsLayoutComponent.Builder

    fun searchQuerySettingsLayoutBuilder(): SearchQuerySettingsLayoutComponent.Builder

    fun inject(activity: SettingsActivity)

    @Subcomponent.Builder
    interface Builder {

        fun build(): SettingsActivityComponent
    }
}