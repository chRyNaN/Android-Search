package com.chrynan.androidsearch.repository

import android.content.pm.ApplicationInfo

interface ApplicationInfoRepository {

    suspend fun getAll(): Sequence<ApplicationInfo>
}