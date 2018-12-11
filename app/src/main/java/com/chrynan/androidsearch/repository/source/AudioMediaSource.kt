package com.chrynan.androidsearch.repository.source

import android.provider.MediaStore
import com.chrynan.androidsearch.model.Media
import com.chrynan.androidsearch.repository.AudioMediaRepository
import com.chrynan.androidsearch.util.AppContext
import javax.inject.Inject

class AudioMediaSource @Inject constructor(private val context: AppContext) : AudioMediaRepository {

    private val uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI
    private val projection = arrayOf(Projection.TITLE.columnName, Projection.MIME_TYPE.columnName,
            Projection.ID.columnName, Projection.DATA.columnName)
    private val selection = "${Projection.TITLE.columnName} like ?"

    override suspend fun getBy(query: String): Sequence<Media> {
        val cursor = context.contentResolver.query(uri, projection, selection, arrayOf("%$query%"), null)

        val list = mutableListOf<Media>()

        while (cursor.moveToNext()) {
            val id = cursor.getLong(Projection.ID.columnIndex)
            val title = cursor.getString(Projection.TITLE.columnIndex)
            val mimeType = cursor.getString(Projection.MIME_TYPE.columnIndex)
            val data = cursor.getString(Projection.DATA.columnIndex)

            list.add(Media(id = id, title = title, mimeType = mimeType, data = data, type = Media.Type.AUDIO))
        }

        cursor.close()

        return list.asSequence()
    }

    private enum class Projection(val columnName: String, val columnIndex: Int) {

        TITLE(columnName = MediaStore.Audio.AudioColumns.TITLE, columnIndex = 0),
        MIME_TYPE(columnName = MediaStore.Audio.AudioColumns.MIME_TYPE, columnIndex = 1),
        ID(columnName = MediaStore.Audio.AudioColumns._ID, columnIndex = 2),
        DATA(columnName = MediaStore.Audio.AudioColumns.DATA, columnIndex = 3)
    }
}