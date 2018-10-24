package com.chrynan.androidsearch.mapper

import android.content.Context
import com.chrynan.androidsearch.R
import com.chrynan.androidsearch.model.TypeAhead
import com.chrynan.androidsearch.viewmodel.AutoCompleteResultViewModel
import com.chrynan.mapper.UniDirectionalMapper

class TypeAheadMapper(private val context: Context) : UniDirectionalMapper<TypeAhead, AutoCompleteResultViewModel.TypeAheadSearch> {

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