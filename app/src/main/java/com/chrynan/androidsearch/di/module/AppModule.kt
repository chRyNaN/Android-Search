@file:Suppress("unused")

package com.chrynan.androidsearch.di.module

import android.content.Context
import android.content.pm.PackageManager
import com.chrynan.androidsearch.SearchApplication
import com.chrynan.androidsearch.di.component.activity.SearchActivityComponent
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [SearchActivityComponent::class])
internal abstract class AppModule {

    @Module
    companion object {

        @JvmStatic
        @Provides
        @Singleton
        fun providePackageManager(appContext: Context): PackageManager = appContext.packageManager
    }

    @Binds
    @Singleton
    abstract fun bindApplicationContext(application: SearchApplication): Context
}