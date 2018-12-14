package com.chrynan.androidsearch.mapper

import com.chrynan.androidsearch.R
import com.chrynan.androidsearch.model.TypeAhead
import com.chrynan.androidsearch.resource.TypeAheadMapperResources
import com.chrynan.androidsearch.resource.source.TypeAheadMapperResourcesSource
import com.chrynan.androidsearch.viewmodel.AutoCompleteResultViewModel
import com.chrynan.mapper.UniDirectionalMapper
import javax.inject.Inject

class TypeAheadMapper @Inject constructor(res: TypeAheadMapperResourcesSource) : UniDirectionalMapper<TypeAhead, AutoCompleteResultViewModel.TypeAheadSearch>,
        TypeAheadMapperResources by res {

    override fun map(value: TypeAhead): AutoCompleteResultViewModel.TypeAheadSearch =
            AutoCompleteResultViewModel.TypeAheadSearch(
                    title = value.suggestion,
                    description = typeAheadDescription,
                    defaultIconResId = R.drawable.ic_adapter_search,
                    iconFetcher = null,
                    actionIcon = null,
                    suggestion = value.suggestion)
}