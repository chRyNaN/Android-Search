package com.chrynan.androidsearch.resource

import com.chrynan.androidsearch.R
import com.chrynan.androidsearch.util.AppContext
import javax.inject.Inject

class TypeAheadMapperResources @Inject constructor(appContext: AppContext) : ResourceProvider(appContext) {

    val typeAheadDescription by string(R.string.auto_complete_description_type_ahead)
}