package com.chrynan.androidsearch.repository.source

import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import com.chrynan.androidsearch.repository.ApplicationInfoRepository

class ApplicationInfoSource(private val packageManager: PackageManager) : ApplicationInfoRepository {

    override suspend fun getAll(): Sequence<ApplicationInfo> =
            packageManager.getInstalledApplications(PackageManager.GET_META_DATA)
                    .asSequence()
                    .filter { packageManager.getLaunchIntentForPackage(it.packageName) != null }
}