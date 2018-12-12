package com.chrynan.androidsearch.navigator.source

import com.chrynan.androidsearch.navigator.SearchSettingsNavigator
import com.chrynan.androidsearch.ui.activity.SettingsActivity
import com.chrynan.androidsearch.ui.layout.SearchQuerySettingsLayout
import javax.inject.Inject

class SearchSettingsNavigatorSource @Inject constructor(
        parentActivity: SettingsActivity,
        private val searchQuerySettingsLayout: SearchQuerySettingsLayout
) : BaseNavigatorSource(parentActivity),
        SearchSettingsNavigator {

    override fun goToSearchQuerySettings() = goToLayout(searchQuerySettingsLayout)
}