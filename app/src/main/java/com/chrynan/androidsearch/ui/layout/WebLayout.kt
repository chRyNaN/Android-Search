package com.chrynan.androidsearch.ui.layout

import android.content.Context
import com.chrynan.androidsearch.di.Injector
import com.chrynan.androidsearch.ui.view.WebBrowserView
import com.chrynan.androidsearch.util.AppContext
import com.chrynan.androidviews.builder.LayoutBuilder
import javax.inject.Inject

class WebLayout @Inject constructor(appContext: AppContext) : BaseLayout(appContext),
        WebBrowserView {

    override fun setupDependencies() = Injector.inject(this)

    override fun onCreateLayout(context: Context): LayoutBuilder<*, *> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}