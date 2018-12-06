package com.chrynan.androidsearch.mapper

import android.content.Context
import com.chrynan.androidsearch.R
import com.chrynan.androidsearch.viewmodel.AutoCompleteResultViewModel
import com.chrynan.mapper.UniDirectionalMapper
import javax.inject.Inject

class EmailMapper @Inject constructor(private val context: Context) : UniDirectionalMapper<String, AutoCompleteResultViewModel.Email> {

    private val emailDescription by lazy { context.getString(R.string.auto_complete_description_email) }

    override fun map(value: String): AutoCompleteResultViewModel.Email =
            AutoCompleteResultViewModel.Email(
                    title = value,
                    description = emailDescription,
                    defaultIconResId = 0,
                    iconFetcher = null,
                    actionIcon = null,
                    email = value)
}