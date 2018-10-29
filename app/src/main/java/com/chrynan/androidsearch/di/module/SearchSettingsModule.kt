package com.chrynan.androidsearch.di.module

import com.chrynan.androidsearch.presenter.SearchSettingsPresenter
import com.chrynan.androidsearch.ui.fragment.SearchSettingsFragment
import com.chrynan.androidsearch.ui.view.SearchSettingsView
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module.module

private val SETTINGS_SCOPE_NAME = SearchSettingsFragment::class.java.name

val SETTINGS_MODULE = module {
    // VIew
    scope(SETTINGS_SCOPE_NAME) { (fragment: SearchSettingsFragment) -> fragment as SearchSettingsView }

    // Presenter
    scope(SETTINGS_SCOPE_NAME) { SearchSettingsPresenter(context = androidContext(), view = get(parameters = { it }), preferences = get()) }
}