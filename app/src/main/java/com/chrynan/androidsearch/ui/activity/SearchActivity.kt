package com.chrynan.androidsearch.ui.activity

import android.os.Bundle
import com.chrynan.androidsearch.di.Injector
import com.chrynan.androidsearch.ui.layout.SearchLayout
import com.chrynan.androidviews.layout.AndroidLayoutProvider
import javax.inject.Inject

class SearchActivity : BaseActivity() {

    @Inject
    lateinit var layout: SearchLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        AndroidLayoutProvider.layout(this, layout)
    }

    override fun setupDependencies() = Injector.inject(this)
}