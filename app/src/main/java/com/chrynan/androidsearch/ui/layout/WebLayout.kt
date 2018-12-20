package com.chrynan.androidsearch.ui.layout

import android.content.Context
import com.chrynan.androidsearch.di.Injector
import com.chrynan.androidsearch.preference.SearchPreferences
import com.chrynan.androidsearch.ui.view.WebBrowserView
import com.chrynan.androidsearch.ui.widget.websiteContainer
import com.chrynan.androidsearch.util.AppContext
import com.chrynan.androidviews.builder.frameLayout
import mozilla.components.browser.engine.gecko.GeckoEngine
import mozilla.components.browser.engine.system.SystemEngine
import javax.inject.Inject
import kotlin.properties.Delegates

class WebLayout @Inject constructor(
        appContext: AppContext,
        private val searchPreferences: SearchPreferences
) : BaseLayout(appContext),
        WebBrowserView {

    var query: String by Delegates.notNull()

    @Inject
    lateinit var geckoEngine: GeckoEngine
    @Inject
    lateinit var systemEngine: SystemEngine

    override fun setupDependencies() = Injector.inject(this)

    override fun onCreateLayout(context: Context) =
            frameLayout(context) {
                websiteContainer {
                    val engine = if (searchPreferences.webView) systemEngine else geckoEngine
                    setEngine(engine)
                    val session = engine.createSession(private = searchPreferences.geckoView)
                    engineView.render(session)
                    session.loadUrl(searchPreferences.webUrl + query)
                }
            }
}