package com.chrynan.androidsearch.preference.source

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import com.chrynan.androidsearch.preference.SearchPreferences
import javax.inject.Inject

class SearchPreferencesSource @Inject constructor(private val context: Context) : SearchPreferences {

    companion object {

        private const val SHARED_PREFERENCES_NAME = "com.chrynan.androidsearch.SearchPreferences"

        private const val KEY_APPS = "APPS"
        private const val KEY_AUDIO = "AUDIO"
        private const val KEY_IMAGE = "IMAGE"
        private const val KEY_VIDEO = "VIDEO"
        private const val KEY_CONTACTS = "CONTACTS"
        private const val KEY_EMAIL = "EMAIL"
        private const val KEY_INSTANT_ANSWERS = "INSTANT_ANSWERS"
        private const val KEY_PHONE_NUMBER = "PHONE_NUMBER"
        private const val KEY_TYPE_AHEAD = "TYPE_AHEAD"
        private const val KEY_HISTORY = "HISTORY"
        private const val KEY_MESSAGES = "MESSAGES"
        private const val KEY_CALENDAR = "CALENDAR"
        private const val KEY_WEB_ADDRESS = "KEY_WEB_ADDRESS"
        private const val KEY_SEARCH_APP = "SEARCH_APP"
        private const val KEY_WEB_VIEW = "WEB_VIEW"
        private const val KEY_CHROME_CUSTOM_TABS = "CHROME_CUSTOM_TABS"
        private const val KEY_BROWSER = "BROWSER"
        private const val KEY_WEB_URL = "WEB_URL"

        private const val DEFAULT_APPS = true
        private const val DEFAULT_AUDIO_FILES = false
        private const val DEFAULT_IMAGE_FILES = false
        private const val DEFAULT_VIDEO_FILES = false
        private const val DEFAULT_CONTACTS = false
        private const val DEFAULT_EMAIL_LINK = true
        private const val DEFAULT_INSTANT_ANSWERS = true
        private const val DEFAULT_PHONE_NUMBER_LINK = true
        private const val DEFAULT_HISTORY = false
        private const val DEFAULT_TYPE_AHEAD = true
        private const val DEFAULT_MESSAGES = false
        private const val DEFAULT_CALENDAR = false
        private const val DEFAULT_WEB_ADDRESS_LINK = true
        private const val DEFAULT_SEARCH_APP = false
        private const val DEFAULT_WEB_VIEW = false
        private const val DEFAULT_CHROME_CUSTOM_TABS = false
        private const val DEFAULT_BROWSER = true
        private const val DEFAULT_WEB_URL = "" // TODO update this value
    }

    private val sharedPreferences by lazy { context.getSharedPreferences(SHARED_PREFERENCES_NAME, MODE_PRIVATE) }

    private val listeners = mutableMapOf<SearchPreferences.SearchPreferenceChangedListener, SharedPreferences.OnSharedPreferenceChangeListener>()

    override var apps: Boolean
        get() = sharedPreferences.getBoolean(KEY_APPS, DEFAULT_APPS)
        set(value) {
            sharedPreferences.edit().putBoolean(KEY_APPS, value).apply()
        }

    override var audioFiles: Boolean
        get() = sharedPreferences.getBoolean(KEY_AUDIO, DEFAULT_AUDIO_FILES)
        set(value) {
            sharedPreferences.edit().putBoolean(KEY_AUDIO, value).apply()
        }

    override var imageFiles: Boolean
        get() = sharedPreferences.getBoolean(KEY_IMAGE, DEFAULT_IMAGE_FILES)
        set(value) {
            sharedPreferences.edit().putBoolean(KEY_IMAGE, value).apply()
        }

    override var videoFiles: Boolean
        get() = sharedPreferences.getBoolean(KEY_VIDEO, DEFAULT_VIDEO_FILES)
        set(value) {
            sharedPreferences.edit().putBoolean(KEY_VIDEO, value).apply()
        }

    override var contacts: Boolean
        get() = sharedPreferences.getBoolean(KEY_CONTACTS, DEFAULT_CONTACTS)
        set(value) {
            sharedPreferences.edit().putBoolean(KEY_CONTACTS, value).apply()
        }

    override var emailLink: Boolean
        get() = sharedPreferences.getBoolean(KEY_EMAIL, DEFAULT_EMAIL_LINK)
        set(value) {
            sharedPreferences.edit().putBoolean(KEY_EMAIL, value).apply()
        }

    override var instantAnswers: Boolean
        get() = sharedPreferences.getBoolean(KEY_INSTANT_ANSWERS, DEFAULT_INSTANT_ANSWERS)
        set(value) {
            sharedPreferences.edit().putBoolean(KEY_INSTANT_ANSWERS, value).apply()
        }

    override var phoneNumberLink: Boolean
        get() = sharedPreferences.getBoolean(KEY_PHONE_NUMBER, DEFAULT_PHONE_NUMBER_LINK)
        set(value) {
            sharedPreferences.edit().putBoolean(KEY_PHONE_NUMBER, value).apply()
        }

    override var history: Boolean
        get() = sharedPreferences.getBoolean(KEY_HISTORY, DEFAULT_HISTORY)
        set(value) {
            sharedPreferences.edit().putBoolean(KEY_HISTORY, value).apply()
        }

    override var typeAhead: Boolean
        get() = sharedPreferences.getBoolean(KEY_TYPE_AHEAD, DEFAULT_TYPE_AHEAD)
        set(value) {
            sharedPreferences.edit().putBoolean(KEY_TYPE_AHEAD, value).apply()
        }

    override var messages: Boolean
        get() = sharedPreferences.getBoolean(KEY_MESSAGES, DEFAULT_MESSAGES)
        set(value) {
            sharedPreferences.edit().putBoolean(KEY_MESSAGES, value).apply()
        }

    override var calendar: Boolean
        get() = sharedPreferences.getBoolean(KEY_CALENDAR, DEFAULT_CALENDAR)
        set(value) {
            sharedPreferences.edit().putBoolean(KEY_CALENDAR, value).apply()
        }

    override var webAddressLink: Boolean
        get() = sharedPreferences.getBoolean(KEY_WEB_ADDRESS, DEFAULT_WEB_ADDRESS_LINK)
        set(value) {
            sharedPreferences.edit().putBoolean(KEY_WEB_ADDRESS, value).apply()
        }

    override var searchApp: Boolean
        get() = sharedPreferences.getBoolean(KEY_SEARCH_APP, DEFAULT_SEARCH_APP)
        set(value) {
            sharedPreferences.edit().putBoolean(KEY_SEARCH_APP, value).apply()
        }

    override var webView: Boolean
        get() = sharedPreferences.getBoolean(KEY_WEB_VIEW, DEFAULT_WEB_VIEW)
        set(value) {
            sharedPreferences.edit()
                    .putBoolean(KEY_WEB_VIEW, value)
                    .putBoolean(KEY_CHROME_CUSTOM_TABS, !value)
                    .putBoolean(KEY_BROWSER, !value)
                    .apply()
        }

    override var chromeCustomTab: Boolean
        get() = sharedPreferences.getBoolean(KEY_CHROME_CUSTOM_TABS, DEFAULT_CHROME_CUSTOM_TABS)
        set(value) {
            sharedPreferences.edit()
                    .putBoolean(KEY_CHROME_CUSTOM_TABS, value)
                    .putBoolean(KEY_WEB_VIEW, !value)
                    .putBoolean(KEY_BROWSER, !value)
                    .apply()
        }

    override var browser: Boolean
        get() = sharedPreferences.getBoolean(KEY_BROWSER, DEFAULT_BROWSER)
        set(value) {
            sharedPreferences.edit()
                    .putBoolean(KEY_BROWSER, value)
                    .putBoolean(KEY_WEB_VIEW, !value)
                    .putBoolean(KEY_CHROME_CUSTOM_TABS, !value)
                    .apply()
        }

    override var webUrl: String
        get() = sharedPreferences.getString(KEY_WEB_URL, DEFAULT_WEB_URL)
        set(value) {
            sharedPreferences.edit().putString(KEY_WEB_URL, value).apply()
        }

    override fun addSearchPreferenceChangedListener(listener: SearchPreferences.SearchPreferenceChangedListener) {
        val sharedPreferencesListener = SharedPreferences.OnSharedPreferenceChangeListener { _, _ -> listener.onPreferenceChanged() }
        listeners[listener] = sharedPreferencesListener
        sharedPreferences.registerOnSharedPreferenceChangeListener(sharedPreferencesListener)
    }

    override fun removeSearchPreferenceChangedListener(listener: SearchPreferences.SearchPreferenceChangedListener) {
        listeners[listener]?.let {
            sharedPreferences.unregisterOnSharedPreferenceChangeListener(it)
            listeners.remove(listener)
        }
    }
}