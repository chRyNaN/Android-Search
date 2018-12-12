package com.chrynan.androidsearch.resource.source

import com.chrynan.androidsearch.R
import com.chrynan.androidsearch.resource.ContactMapperResources
import com.chrynan.androidsearch.resource.ResourceProvider
import com.chrynan.androidsearch.util.AppContext
import javax.inject.Inject

class ContactMapperResourcesSource @Inject constructor(appContext: AppContext) : ResourceProvider(appContext),
        ContactMapperResources {

    override val contactDescription by lazy { descriptionFormatter(contactDescriptionTitle) }

    private val contactDescriptionTitle by string(R.string.auto_complete_description_title_contacts)
    private val descriptionFormatter by formattedString<String>(R.string.auto_complete_description)
}