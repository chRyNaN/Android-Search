package com.chrynan.androidsearch.mapper

import android.content.Context
import com.chrynan.androidsearch.R
import com.chrynan.androidsearch.model.wrapper.Url
import com.chrynan.androidsearch.viewmodel.AutoCompleteResultViewModel
import com.chrynan.mapper.UniDirectionalMapper
import javax.inject.Inject

class WebAddressMapper @Inject constructor(private val context: Context) : UniDirectionalMapper<String, AutoCompleteResultViewModel.WebAddress> {

    private val urlDescription by lazy { context.getString(R.string.auto_complete_description_web_address) }

    override fun map(value: String): AutoCompleteResultViewModel.WebAddress =
            AutoCompleteResultViewModel.WebAddress(
                    title = value,
                    description = urlDescription,
                    defaultIconResId = 0,
                    iconFetcher = null,
                    actionIcon = null,
                    url = Url(value))
}