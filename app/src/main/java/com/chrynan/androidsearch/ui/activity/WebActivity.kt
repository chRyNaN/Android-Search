package com.chrynan.androidsearch.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.chrynan.androidsearch.di.Injector
import com.chrynan.androidsearch.model.wrapper.Url
import com.chrynan.androidsearch.ui.layout.WebLayout
import com.chrynan.androidviews.layout.AndroidLayoutProvider
import javax.inject.Inject

class WebActivity : BaseActivity() {

    companion object {

        fun newIntent(context: Context, url: Url) = Intent(context, WebActivity::class.java)
    }

    @Inject
    lateinit var layout: WebLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        AndroidLayoutProvider.layout(this, layout)
    }

    override fun setupDependencies() = Injector.inject(this)
}