package com.chrynan.androidsearch.navigator

import com.chrynan.androidsearch.model.wrapper.Query

interface SearchNavigator : Navigator {

    fun goToSettings()

    fun goToWebSite(query: Query)
}