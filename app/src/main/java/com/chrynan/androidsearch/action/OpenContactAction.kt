package com.chrynan.androidsearch.action

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.ContactsContract
import com.chrynan.androidsearch.model.wrapper.ContactId
import com.chrynan.androidsearch.util.startIntentIfItExists
import javax.inject.Inject

class OpenContactAction @Inject constructor() : QueryResultAction<ContactId> {

    override fun perform(context: Context, item: ContactId): Boolean {
        val intent = Intent(Intent.ACTION_VIEW, Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_URI, item.value))

        return context.startIntentIfItExists(intent)
    }
}