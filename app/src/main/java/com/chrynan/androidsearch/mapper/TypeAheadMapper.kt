package com.chrynan.androidsearch.mapper

import com.chrynan.androidsearch.model.TypeAhead
import com.chrynan.androidsearch.resource.TypeAheadMapperResources
import com.chrynan.androidsearch.viewmodel.AutoCompleteResultViewModel
import com.chrynan.mapper.UniDirectionalMapper
import javax.inject.Inject

class TypeAheadMapper @Inject constructor(private val res: TypeAheadMapperResources) : UniDirectionalMapper<TypeAhead, AutoCompleteResultViewModel.TypeAheadSearch> {

    override fun map(value: TypeAhead): AutoCompleteResultViewModel.TypeAheadSearch =
            AutoCompleteResultViewModel.TypeAheadSearch(
                    title = value.suggestion,
                    description = res.typeAheadDescription,
                    defaultIconResId = 0,
                    iconFetcher = null,
                    actionIcon = null,
                    suggestion = value.suggestion)
}