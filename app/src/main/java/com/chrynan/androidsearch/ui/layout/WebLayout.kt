package com.chrynan.androidsearch.ui.layout

import android.content.Context
import com.chrynan.androidsearch.di.Injector
import com.chrynan.androidsearch.ui.view.WebBrowserView
import com.chrynan.androidsearch.ui.widget.websiteContainer
import com.chrynan.androidsearch.util.AppContext
import com.chrynan.androidviews.builder.frameLayout
import javax.inject.Inject

class WebLayout @Inject constructor(appContext: AppContext) : BaseLayout(appContext),
        WebBrowserView {

    override fun setupDependencies() = Injector.inject(this)

    override fun onCreateLayout(context: Context) =
            frameLayout(context) {
                websiteContainer {

                }
            }
}