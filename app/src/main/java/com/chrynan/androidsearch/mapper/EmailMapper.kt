package com.chrynan.androidsearch.mapper

import com.chrynan.androidsearch.model.wrapper.Email
import com.chrynan.androidsearch.resource.EmailMapperResources
import com.chrynan.androidsearch.resource.source.EmailMapperResourcesSource
import com.chrynan.androidsearch.viewmodel.AutoCompleteResultViewModel
import com.chrynan.mapper.UniDirectionalMapper
import javax.inject.Inject

class EmailMapper @Inject constructor(res: EmailMapperResourcesSource) : UniDirectionalMapper<String, AutoCompleteResultViewModel.Email>,
        EmailMapperResources by res {

    override fun map(value: String): AutoCompleteResultViewModel.Email =
            AutoCompleteResultViewModel.Email(
                    title = value,
                    description = emailDescription,
                    defaultIconResId = 0,
                    iconFetcher = null,
                    actionIcon = null,
                    email = Email(value))
}