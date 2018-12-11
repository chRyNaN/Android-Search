package com.chrynan.androidsearch.preference

interface SearchPreferences {

    var apps: Boolean

    var audioFiles: Boolean

    var imageFiles: Boolean

    var videoFiles: Boolean

    var contacts: Boolean

    var emailLink: Boolean

    var phoneNumberLink: Boolean

    var history: Boolean

    var typeAhead: Boolean

    var messages: Boolean

    var calendar: Boolean

    var webAddressLink: Boolean

    var webView: Boolean

    var chromeCustomTab: Boolean

    var browser: Boolean

    var webUrl: String

    fun addSearchPreferenceChangedListener(listener: SearchPreferenceChangedListener)

    fun removeSearchPreferenceChangedListener(listener: SearchPreferenceChangedListener)

    interface SearchPreferenceChangedListener {

        fun onPreferenceChanged()
    }
}