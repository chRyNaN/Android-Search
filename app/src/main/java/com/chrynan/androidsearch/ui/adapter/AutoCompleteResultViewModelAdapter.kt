package com.chrynan.androidsearch.ui.adapter

import com.chrynan.aaaah.Adapter
import com.chrynan.aaaah.AdapterViewType
import com.chrynan.aaaah.from
import com.chrynan.androidsearch.ui.layout.AdapterAutoCompleteResultLayout
import com.chrynan.androidsearch.viewmodel.AutoCompleteResultViewModel
import javax.inject.Inject

@Adapter
class AutoCompleteResultViewModelAdapter @Inject constructor(override val layout: AdapterAutoCompleteResultLayout) : BaseLayoutAdapter<AutoCompleteResultViewModel>() {

    override val viewType = AdapterViewType.from(this::class.java)

    override fun onHandlesItem(item: Any) = item is AutoCompleteResultViewModel

    interface AutoCompleteResultSelectedListener {

        fun onAutoCompleteResultSelected(result: AutoCompleteResultViewModel)
    }
}