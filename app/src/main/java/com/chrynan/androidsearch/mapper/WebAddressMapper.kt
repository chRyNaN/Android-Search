package com.chrynan.androidsearch.mapper

import com.chrynan.androidsearch.model.wrapper.Url
import com.chrynan.androidsearch.resource.WebAddressMapperResources
import com.chrynan.androidsearch.resource.source.WebAddressMapperResourcesSource
import com.chrynan.androidsearch.viewmodel.AutoCompleteResultViewModel
import com.chrynan.mapper.UniDirectionalMapper
import javax.inject.Inject

class WebAddressMapper @Inject constructor(res: WebAddressMapperResourcesSource) : UniDirectionalMapper<String, AutoCompleteResultViewModel.WebAddress>,
        WebAddressMapperResources by res {

    override fun map(value: String): AutoCompleteResultViewModel.WebAddress =
            AutoCompleteResultViewModel.WebAddress(
                    title = value,
                    description = urlDescription,
                    defaultIconResId = 0,
                    iconFetcher = null,
                    actionIcon = null,
                    url = Url(value))
}