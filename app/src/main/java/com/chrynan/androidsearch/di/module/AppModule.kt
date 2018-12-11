@file:Suppress("unused")

package com.chrynan.androidsearch.di.module

import android.content.pm.PackageManager
import com.chrynan.androidsearch.SearchApplication
import com.chrynan.androidsearch.di.component.activity.SearchActivityComponent
import com.chrynan.androidsearch.util.AppContext
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
        fun providePackageManager(appContext: AppContext): PackageManager = appContext.packageManager
    }

    @Binds
    @Singleton
    abstract fun bindApplicationContext(application: SearchApplication): AppContext
}