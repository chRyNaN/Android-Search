package com.chrynan.androidsearch.mapper

import android.content.Context
import android.content.pm.ApplicationInfo
import com.chrynan.androidsearch.R
import com.chrynan.androidsearch.model.wrapper.PackageName
import com.chrynan.androidsearch.viewmodel.AutoCompleteResultViewModel
import com.chrynan.glidedrawable.ApplicationIconDrawableFunction
import com.chrynan.mapper.UniDirectionalMapper
import javax.inject.Inject

class AppMapper @Inject constructor(private val context: Context) : UniDirectionalMapper<ApplicationInfo, AutoCompleteResultViewModel.App> {

    private val appDescriptionTitle by lazy { context.getString(R.string.auto_complete_description_title_apps) }
    private val descriptionTextFormatter: (String) -> String = { context.getString(R.string.auto_complete_description, it) }
    private val appDescription by lazy { descriptionTextFormatter(appDescriptionTitle) }

    override fun map(value: ApplicationInfo) =
            with(context.packageManager) {
                AutoCompleteResultViewModel.App(
                        title = getApplicationLabel(value)?.toString() ?: value.name
                        ?: "", // Apparently, this is the culprit to the performance impact. Getting the application Label takes the longest to load.
                        description = appDescription,
                        defaultIconResId = R.drawable.ic_launcher_background,
                        iconFetcher = ApplicationIconDrawableFunction(this, value.packageName),
                        actionIcon = null,
                        packageName = PackageName(value.packageName))
            }
}