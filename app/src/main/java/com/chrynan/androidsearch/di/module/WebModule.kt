package com.chrynan.androidsearch.di.module

import com.chrynan.androidsearch.util.AppContext
import com.chrynan.androidsearch.web.ContextualWebSuggestionWebService
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import mozilla.components.browser.engine.gecko.GeckoEngine
import mozilla.components.browser.engine.system.SystemEngine
import mozilla.components.concept.engine.DefaultSettings
import mozilla.components.concept.engine.EngineSession
import org.mozilla.geckoview.GeckoRuntime
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
internal abstract class WebModule {

    @Module
    companion object {

        @JvmStatic
        @Provides
        @Singleton
        fun provideMoshi(): Moshi =
                Moshi.Builder()
                        .build()

        @JvmStatic
        @Provides
        @Singleton
        fun provideTypeAheadWebService(moshi: Moshi): ContextualWebSuggestionWebService =
                Retrofit.Builder()
                        .baseUrl("https://contextualwebsearch.com")
                        .addConverterFactory(MoshiConverterFactory.create(moshi))
                        .addCallAdapterFactory(CoroutineCallAdapterFactory())
                        .build()
                        .create(ContextualWebSuggestionWebService::class.java)

        @JvmStatic
        @Provides
        @Singleton
        fun provideDefaultSettings() = DefaultSettings().apply {
            trackingProtectionPolicy = EngineSession.TrackingProtectionPolicy.all()
        }

        @JvmStatic
        @Provides
        @Singleton
        fun provideGeckoRuntime(appContext: AppContext) = GeckoRuntime.getDefault(appContext)

        @JvmStatic
        @Provides
        @Singleton
        fun provideGeckoEngine(appContext: AppContext, defaultSettings: DefaultSettings, geckoRuntime: GeckoRuntime) =
                GeckoEngine(context = appContext, defaultSettings = defaultSettings, runtime = geckoRuntime)

        @JvmStatic
        @Provides
        @Singleton
        fun provideSystemEngine(appContext: AppContext, defaultSettings: DefaultSettings) =
                SystemEngine(context = appContext, defaultSettings = defaultSettings)
    }
}