package com.chrynan.androidsearch.repository.source

import android.net.Uri
import android.provider.ContactsContract
import com.chrynan.androidsearch.model.Contact
import com.chrynan.androidsearch.repository.ContactRepository
import com.chrynan.androidsearch.util.AppContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ContactSource @Inject constructor(private val context: AppContext) : ContactRepository {

    private val projection = arrayOf(
            Projection.ID.columnName,
            Projection.NAME.columnName,
            Projection.LOOKUP_KEY.columnName,
            Projection.PHOTO_URI.columnName)

    override suspend fun getBy(query: String): List<Contact> {
        val uri = Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_FILTER_URI, Uri.encode(query))

        val cursor = context.contentResolver.query(uri, projection, null, null, null)

        val list = mutableListOf<Contact>()

        while (cursor.moveToNext()) {
            val id = cursor.getString(Projection.ID.columnIndex)
            val name = cursor.getString(Projection.NAME.columnIndex)
            val photoUri = cursor.getString(Projection.PHOTO_URI.columnIndex)
            val lookupKey = cursor.getString(Projection.LOOKUP_KEY.columnIndex)

            list.add(Contact(id = id, name = name, photoUri = photoUri, lookupKey = lookupKey))
        }

        cursor.close()

        return list
    }

    private enum class Projection(val columnName: String, val columnIndex: Int) {

        ID(columnName = ContactsContract.Data._ID, columnIndex = 0),
        NAME(columnName = ContactsContract.Data.DISPLAY_NAME_PRIMARY, columnIndex = 1),
        LOOKUP_KEY(columnName = ContactsContract.Data.LOOKUP_KEY, columnIndex = 2),
        PHOTO_URI(columnName = ContactsContract.Data.PHOTO_THUMBNAIL_URI, columnIndex = 3)
    }
}