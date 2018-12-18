package com.chrynan.androidsearch.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.chrynan.androidsearch.di.Injector
import com.chrynan.androidsearch.ui.layout.SearchQuerySettingsLayout
import com.chrynan.androidsearch.ui.layout.SearchSettingsLayout
import com.chrynan.androidsearch.util.Permissions
import com.chrynan.androidviews.layout.AndroidLayoutProvider
import javax.inject.Inject

class SettingsActivity : BaseActivity() {

    companion object {

        fun newIntent(context: Context) = Intent(context, SettingsActivity::class.java)
    }

    @Inject
    lateinit var searchQuerySettingsLayout: SearchQuerySettingsLayout

    @Inject
    lateinit var searchSettingsLayout: SearchSettingsLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        AndroidLayoutProvider.layout(this, searchSettingsLayout)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        Permissions.handle(requestCode = requestCode, permissions = permissions, grantResults = grantResults, callback = searchSettingsLayout::onPermissionResults)
    }

    override fun setupDependencies() = Injector.inject(this)
}