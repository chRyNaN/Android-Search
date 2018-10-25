package com.chrynan.androidsearch.di.module

import com.chrynan.androidsearch.presenter.SearchSettingsPresenter
import com.chrynan.androidsearch.ui.activity.SearchSettingsActivity
import com.chrynan.androidsearch.ui.view.SettingsView
import org.koin.dsl.module.module

private val SETTINGS_SCOPE_NAME = SearchSettingsActivity::class.java.name

val SETTINGS_MODULE = module {
    // VIew
    scope(SETTINGS_SCOPE_NAME) { (activity: SearchSettingsActivity) -> activity as SettingsView }

    // Presenter
    scope(SETTINGS_SCOPE_NAME) { SearchSettingsPresenter(view = get(parameters = { it }), preferences = get()) }
}