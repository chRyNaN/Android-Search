package com.chrynan.androidsearch.ui.activity

import android.os.Bundle
import com.chrynan.androidsearch.R
import com.chrynan.androidsearch.presenter.SettingsPresenter
import kotlinx.android.synthetic.main.activity_settings.*
import org.koin.android.ext.android.inject

class SettingsActivity : BaseActivity() {

    private val presenter: SettingsPresenter by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        searchAppsToggleCell?.toggleListener = {}
    }
}