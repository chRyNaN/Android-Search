package com.chrynan.androidsearch.repository.source

import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import com.chrynan.androidsearch.repository.ApplicationInfoRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApplicationInfoSource @Inject constructor(private val packageManager: PackageManager) : ApplicationInfoRepository {

    override suspend fun getAll(): List<ApplicationInfo> =
            packageManager.getInstalledApplications(PackageManager.GET_META_DATA)
                    .filter { packageManager.getLaunchIntentForPackage(it.packageName) != null }
}