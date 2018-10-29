package com.chrynan.androidsearch.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.chrynan.androidsearch.R
import com.chrynan.androidsearch.ui.fragment.SearchSettingsFragment

class SettingsActivity : BaseActivity() {

    companion object {

        fun newIntent(context: Context) = Intent(context, SettingsActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        supportFragmentManager.beginTransaction().add(R.id.fragmentContainer, SearchSettingsFragment.newInstance()).commit()
    }
}