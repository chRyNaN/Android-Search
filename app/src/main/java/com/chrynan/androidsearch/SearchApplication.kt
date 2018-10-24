package com.chrynan.androidsearch

import android.app.Application
import com.chrynan.androidsearch.di.module.*
import org.koin.android.ext.android.startKoin

class SearchApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin(
                context = this,
                modules = listOf(
                        APP_MODULE,
                        WEB_MODULE,
                        REPOSITORY_MODULE,
                        PREFERENCE_MODULE,
                        PROVIDER_MODULE,
                        MAPPER_MODULE,
                        ACTION_MODULE,
                        SEARCH_MODULE,
                        SETTINGS_MODULE))
    }
}