package com.chrynan.androidsearch.mapper

import android.content.Context
import com.chrynan.androidsearch.R
import com.chrynan.androidsearch.model.Contact
import com.chrynan.androidsearch.model.wrapper.ContactId
import com.chrynan.androidsearch.viewmodel.AutoCompleteResultViewModel
import com.chrynan.glidedrawable.ContactThumbnailDrawableFunction
import com.chrynan.mapper.UniDirectionalMapper
import javax.inject.Inject

class ContactMapper @Inject constructor(private val context: Context) : UniDirectionalMapper<Contact, AutoCompleteResultViewModel.Contact> {

    private val contactDescriptionTitle by lazy { context.getString(R.string.auto_complete_description_title_contacts) }
    private val descriptionFormatter: (String) -> String = { context.getString(R.string.auto_complete_description, it) }
    private val contactDescription by lazy { descriptionFormatter(contactDescriptionTitle) }

    override fun map(value: Contact): AutoCompleteResultViewModel.Contact =
            AutoCompleteResultViewModel.Contact(
                    title = value.name,
                    description = contactDescription,
                    defaultIconResId = 0,
                    iconFetcher = value.photoUri?.let { ContactThumbnailDrawableFunction(context, it) },
                    actionIcon = null,
                    name = value.name,
                    id = ContactId(value.id),
                    lookupKey = value.lookupKey,
                    photoUri = value.photoUri)
}