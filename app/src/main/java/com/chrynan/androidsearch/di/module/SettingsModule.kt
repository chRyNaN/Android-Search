package com.chrynan.androidsearch.di.module

import com.chrynan.androidsearch.presenter.SettingsPresenter
import com.chrynan.androidsearch.ui.activity.SettingsActivity
import org.koin.dsl.module.module

private val SETTINGS_SCOPE_NAME = SettingsActivity::class.java.name

val SETTINGS_MODULE = module {
    // Presenter
    scope(SETTINGS_SCOPE_NAME) { SettingsPresenter() }
}