package com.chrynan.androidsearch.resource

import com.chrynan.androidsearch.R
import com.chrynan.androidsearch.util.AppContext
import javax.inject.Inject

class ContactMapperResources @Inject constructor(appContext: AppContext) : ResourceProvider(appContext) {

    val descriptionFormatter by formattedString<String>(R.string.auto_complete_description)
    val contactDescription by lazy { descriptionFormatter(contactDescriptionTitle) }

    private val contactDescriptionTitle by string(R.string.auto_complete_description_title_contacts)
}