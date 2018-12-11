package com.chrynan.androidsearch.mapper

import com.chrynan.androidsearch.R
import com.chrynan.androidsearch.model.TypeAhead
import com.chrynan.androidsearch.util.AppContext
import com.chrynan.androidsearch.viewmodel.AutoCompleteResultViewModel
import com.chrynan.mapper.UniDirectionalMapper
import javax.inject.Inject

class TypeAheadMapper @Inject constructor(private val context: AppContext) : UniDirectionalMapper<TypeAhead, AutoCompleteResultViewModel.TypeAheadSearch> {

    private val typeAheadDescription by lazy { context.getString(R.string.auto_complete_description_type_ahead) }

    override fun map(value: TypeAhead): AutoCompleteResultViewModel.TypeAheadSearch =
            AutoCompleteResultViewModel.TypeAheadSearch(
                    title = value.suggestion,
                    description = typeAheadDescription,
                    defaultIconResId = 0,
                    iconFetcher = null,
                    actionIcon = null,
                    suggestion = value.suggestion)
}