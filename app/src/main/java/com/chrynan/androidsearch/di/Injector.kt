package com.chrynan.androidsearch.di

import com.chrynan.androidsearch.SearchApplication
import com.chrynan.androidsearch.di.component.AppComponent
import com.chrynan.androidsearch.di.component.DaggerAppComponent
import com.chrynan.androidsearch.di.component.activity.SearchActivityComponent
import com.chrynan.androidsearch.di.component.activity.SettingsActivityComponent
import com.chrynan.androidsearch.ui.activity.SearchActivity
import com.chrynan.androidsearch.ui.activity.SettingsActivity
import com.chrynan.androidsearch.ui.layout.SearchLayout
import com.chrynan.androidsearch.ui.layout.SearchQuerySettingsLayout
import com.chrynan.androidsearch.ui.layout.SearchSettingsLayout

object Injector {

    private lateinit var appComponent: AppComponent
    private lateinit var searchActivityComponent: SearchActivityComponent
    private lateinit var settingsActivityComponent: SettingsActivityComponent

    fun inject(application: SearchApplication) {
        appComponent = DaggerAppComponent
                .builder()
                .application(application)
                .build()

        appComponent.inject(application)
    }

    fun inject(activity: SearchActivity) {
        searchActivityComponent = appComponent.searchActivityBuilder()
                .activity(activity)
                .build()

        searchActivityComponent.inject(activity)
    }

    fun inject(activity: SettingsActivity) {
        settingsActivityComponent = appComponent.settingsActivityBuilder()
                .activity(activity)
                .build()

        settingsActivityComponent.inject(activity)
    }

    fun inject(layout: SearchLayout) {
        searchActivityComponent.searchLayoutBuilder()
                .build()
                .inject(layout)
    }

    fun inject(layout: SearchQuerySettingsLayout) {
        settingsActivityComponent.searchQuerySettingsLayoutBuilder()
                .build()
                .inject(layout)
    }

    fun inject(layout: SearchSettingsLayout) {
        settingsActivityComponent.searchSettingsLayoutBuilder()
                .build()
                .inject(layout)
    }
}