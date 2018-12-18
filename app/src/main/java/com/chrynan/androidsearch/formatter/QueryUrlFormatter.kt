package com.chrynan.androidsearch.formatter

import javax.inject.Inject

class QueryUrlFormatter @Inject constructor() {

    companion object {

        private const val PREFIX_HTTP = "http://"
        private const val PREFIX_HTTPS = "https://"
    }

    fun format(url: String): String {
        if (url.startsWith(PREFIX_HTTP) or url.startsWith(PREFIX_HTTPS)) return url

        return PREFIX_HTTPS + url
    }
}