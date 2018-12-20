@file:Suppress("unused")

package com.chrynan.androidsearch.di.component

import android.content.pm.PackageManager
import com.chrynan.androidsearch.SearchApplication
import com.chrynan.androidsearch.di.component.activity.SearchActivityComponent
import com.chrynan.androidsearch.di.component.activity.SettingsActivityComponent
import com.chrynan.androidsearch.di.component.activity.WebActivityComponent
import com.chrynan.androidsearch.di.module.AppModule
import com.chrynan.androidsearch.di.module.PreferenceModule
import com.chrynan.androidsearch.di.module.RepositoryModule
import com.chrynan.androidsearch.di.module.WebModule
import com.chrynan.androidsearch.preference.SearchPreferences
import com.chrynan.androidsearch.repository.*
import com.chrynan.androidsearch.util.AppContext
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    WebModule::class,
    PreferenceModule::class,
    RepositoryModule::class
])
interface AppComponent {

    fun searchActivityBuilder(): SearchActivityComponent.Builder

    fun settingsActivityBuilder(): SettingsActivityComponent.Builder

    fun webActivityBuilder(): WebActivityComponent.Builder

    fun appContext(): AppContext

    fun packageManager(): PackageManager

    fun applicationInfoRepository(): ApplicationInfoRepository

    fun contactRepository(): ContactRepository

    fun imageMediaRepository(): ImageMediaRepository

    fun videoMediaRepository(): VideoMediaRepository

    fun audioMediaRepository(): AudioMediaRepository

    fun typeAheadRepository(): TypeAheadRepository

    fun searchHistoryRepository(): SearchHistoryRepository

    fun searchPreferences(): SearchPreferences

    fun inject(application: SearchApplication)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: SearchApplication): AppComponent.Builder

        fun build(): AppComponent
    }
}