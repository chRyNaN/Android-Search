package com.chrynan.androidsearch.mapper

import com.chrynan.androidsearch.R
import com.chrynan.androidsearch.model.wrapper.Email
import com.chrynan.androidsearch.util.AppContext
import com.chrynan.androidsearch.viewmodel.AutoCompleteResultViewModel
import com.chrynan.mapper.UniDirectionalMapper
import javax.inject.Inject

class EmailMapper @Inject constructor(private val context: AppContext) : UniDirectionalMapper<String, AutoCompleteResultViewModel.Email> {

    private val emailDescription by lazy { context.getString(R.string.auto_complete_description_email) }

    override fun map(value: String): AutoCompleteResultViewModel.Email =
            AutoCompleteResultViewModel.Email(
                    title = value,
                    description = emailDescription,
                    defaultIconResId = 0,
                    iconFetcher = null,
                    actionIcon = null,
                    email = Email(value))
}