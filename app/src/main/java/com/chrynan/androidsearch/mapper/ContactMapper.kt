package com.chrynan.androidsearch.mapper

import com.chrynan.androidsearch.R
import com.chrynan.androidsearch.model.Contact
import com.chrynan.androidsearch.model.wrapper.ContactId
import com.chrynan.androidsearch.resource.ContactMapperResources
import com.chrynan.androidsearch.resource.source.ContactMapperResourcesSource
import com.chrynan.androidsearch.util.AppContext
import com.chrynan.androidsearch.viewmodel.AutoCompleteResultViewModel
import com.chrynan.glidedrawable.ContactThumbnailDrawableFunction
import com.chrynan.mapper.UniDirectionalMapper
import javax.inject.Inject

class ContactMapper @Inject constructor(
        private val context: AppContext,
        res: ContactMapperResourcesSource
) : UniDirectionalMapper<Contact, AutoCompleteResultViewModel.Contact>,
        ContactMapperResources by res {

    override fun map(value: Contact): AutoCompleteResultViewModel.Contact =
            AutoCompleteResultViewModel.Contact(
                    title = value.name,
                    description = contactDescription,
                    defaultIconResId = R.drawable.ic_adapter_contact,
                    iconFetcher = value.photoUri?.let { ContactThumbnailDrawableFunction(context, it) },
                    actionIcon = null,
                    name = value.name,
                    id = ContactId(value.id),
                    lookupKey = value.lookupKey,
                    photoUri = value.photoUri)
}