package com.chrynan.androidsearch.mapper

import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import com.chrynan.androidsearch.R
import com.chrynan.androidsearch.model.wrapper.PackageName
import com.chrynan.androidsearch.resource.AppMapperResources
import com.chrynan.androidsearch.viewmodel.AutoCompleteResultViewModel
import com.chrynan.glidedrawable.ApplicationIconDrawableFunction
import com.chrynan.mapper.UniDirectionalMapper
import javax.inject.Inject

class AppMapper @Inject constructor(
        private val packageManager: PackageManager,
        private val res: AppMapperResources
) : UniDirectionalMapper<ApplicationInfo, AutoCompleteResultViewModel.App> {

    override fun map(value: ApplicationInfo) =
            with(packageManager) {
                AutoCompleteResultViewModel.App(
                        title = getApplicationLabel(value)?.toString() ?: value.name
                        ?: "", // Apparently, this is the culprit to the performance impact. Getting the application Label takes the longest to load.
                        description = res.appDescription,
                        defaultIconResId = R.drawable.ic_launcher_background,
                        iconFetcher = ApplicationIconDrawableFunction(this, value.packageName),
                        actionIcon = null,
                        packageName = PackageName(value.packageName))
            }
}