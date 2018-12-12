package com.chrynan.androidsearch.resource.source

import com.chrynan.androidsearch.R
import com.chrynan.androidsearch.resource.ResourceProvider
import com.chrynan.androidsearch.resource.TypeAheadMapperResources
import com.chrynan.androidsearch.util.AppContext
import javax.inject.Inject

class TypeAheadMapperResourcesSource @Inject constructor(appContext: AppContext) : ResourceProvider(appContext),
        TypeAheadMapperResources {

    override val typeAheadDescription by string(R.string.auto_complete_description_type_ahead)
}