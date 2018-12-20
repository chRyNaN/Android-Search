package com.chrynan.androidsearch.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.chrynan.androidsearch.di.Injector
import com.chrynan.androidsearch.model.wrapper.Query
import com.chrynan.androidsearch.ui.layout.WebLayout
import com.chrynan.androidsearch.util.EMPTY_STRING
import com.chrynan.androidviews.layout.AndroidLayoutProvider
import javax.inject.Inject

class WebActivity : BaseActivity() {

    companion object {

        private const val KEY_QUERY = "com.chrynan.androidsearch.webactivity.query"

        fun newIntent(context: Context, query: Query) = Intent(context, WebActivity::class.java).apply {
            putExtra(KEY_QUERY, query.value)
        }
    }

    @Inject
    lateinit var layout: WebLayout

    private val query: String by lazy {
        intent.extras.getString(KEY_QUERY) ?: EMPTY_STRING
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        layout.query = query

        AndroidLayoutProvider.layout(this, layout)
    }

    override fun setupDependencies() = Injector.inject(this)
}