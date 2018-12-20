package com.chrynan.androidsearch.navigator.source

import com.chrynan.androidsearch.model.wrapper.Query
import com.chrynan.androidsearch.navigator.SearchNavigator
import com.chrynan.androidsearch.ui.activity.SearchActivity
import com.chrynan.androidsearch.ui.activity.SettingsActivity
import com.chrynan.androidsearch.ui.activity.WebActivity
import javax.inject.Inject

class SearchNavigatorSource @Inject constructor(parentActivity: SearchActivity) : BaseNavigatorSource(parentActivity),
        SearchNavigator {

    override fun goToSettings() = goToActivity { SettingsActivity.newIntent(it) }

    override fun goToWebSite(query: Query) = goToActivity { WebActivity.newIntent(it, query) }
}