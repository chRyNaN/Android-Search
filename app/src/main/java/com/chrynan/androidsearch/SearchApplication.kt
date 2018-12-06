package com.chrynan.androidsearch

import android.app.Application
import com.chrynan.androidsearch.di.Injector

class SearchApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        Injector.inject(this)
    }
}