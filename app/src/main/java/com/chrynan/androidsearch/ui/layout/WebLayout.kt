package com.chrynan.androidsearch.ui.layout

import android.content.Context
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toolbar
import com.chrynan.androidsearch.di.Injector
import com.chrynan.androidsearch.preference.SearchPreferences
import com.chrynan.androidsearch.resource.WebLayoutResources
import com.chrynan.androidsearch.resource.source.WebLayoutResourcesSource
import com.chrynan.androidsearch.ui.view.WebBrowserView
import com.chrynan.androidsearch.ui.widget.websiteContainer
import com.chrynan.androidsearch.util.AppContext
import com.chrynan.androidviews.builder.appBarLayout
import com.chrynan.androidviews.builder.horizontalProgressBar
import com.chrynan.androidviews.builder.toolbar
import com.chrynan.androidviews.builder.verticalLayout
import com.chrynan.androidviewutils.setVisibleOrGone
import mozilla.components.browser.engine.gecko.GeckoEngine
import mozilla.components.browser.engine.system.SystemEngine
import mozilla.components.browser.session.Session
import mozilla.components.browser.session.SessionManager
import javax.inject.Inject
import kotlin.properties.Delegates

class WebLayout @Inject constructor(
        appContext: AppContext,
        resources: WebLayoutResourcesSource,
        private val searchPreferences: SearchPreferences
) : BaseLayout(appContext),
        WebBrowserView,
        WebLayoutResources by resources {

    var query: String by Delegates.notNull()

    @Inject
    lateinit var geckoEngine: GeckoEngine
    @Inject
    lateinit var systemEngine: SystemEngine

    private lateinit var toolbar: Toolbar
    private lateinit var progressBar: ProgressBar

    override fun setupDependencies() = Injector.inject(this)

    override fun onCreateLayout(context: Context) =
            verticalLayout(context) {
                appBarLayout {
                    toolbar = toolbar {
                        init {
                            subtitle = searchPreferences.webUrl + query
                            setSubtitleTextColor(toolbarSubtitleTextColor)
                            navigationIcon = toolbarNavigationIcon
                            setNavigationOnClickListener { }
                        }
                    }
                    progressBar = horizontalProgressBar {
                        isIndeterminate = false
                        max = progressBarMax

                        layoutParams {
                            width = ViewGroup.LayoutParams.MATCH_PARENT
                            height = progressBarHeight
                        }
                    }
                }

                websiteContainer {
                    val engine = if (searchPreferences.webView) systemEngine else geckoEngine

                    setEngine(engine)

                    val sessionManager = SessionManager(engine = engine)

                    val session = Session(initialUrl = searchPreferences.webUrl + query, private = searchPreferences.geckoView).apply {
                        register(object : Session.Observer {
                            override fun onProgress(session: Session, progress: Int) {
                                progressBar.progress = progress
                            }

                            override fun onLoadingStateChanged(session: Session, loading: Boolean) {
                                progressBar.setVisibleOrGone(loading)
                            }

                            override fun onTitleChanged(session: Session, title: String) {
                                toolbar.title = title
                            }
                        })
                    }

                    sessionManager.add(session = session, selected = true)

                    engineView.render(sessionManager.getOrCreateEngineSession())
                }
            }
}