package com.chrynan.androidsearch.repository.source

import android.content.Context
import android.provider.MediaStore
import com.chrynan.androidsearch.model.Media
import com.chrynan.androidsearch.repository.VideoMediaRepository
import javax.inject.Inject

class VideoMediaSource @Inject constructor(private val context: Context) : VideoMediaRepository {

    private val uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI
    private val projection = arrayOf(Projection.TITLE.columnName, Projection.MIME_TYPE.columnName,
            Projection.ID.columnName, Projection.DATA.columnName, Projection.THUMBNAIL.columnName)
    private val selection = "${Projection.TITLE.columnName} like ?"

    override suspend fun getBy(query: String): Sequence<Media> {
        val cursor = context.contentResolver.query(uri, projection, selection, arrayOf("%$query%"), null)

        val list = mutableListOf<Media>()

        while (cursor.moveToNext()) {
            val id = cursor.getLong(Projection.ID.columnIndex)
            val title = cursor.getString(Projection.TITLE.columnIndex)
            val mimeType = cursor.getString(Projection.MIME_TYPE.columnIndex)
            val data = cursor.getString(Projection.DATA.columnIndex)
            val thumbnailId = cursor.getLong(Projection.THUMBNAIL.columnIndex)

            list.add(Media(id = id, title = title, mimeType = mimeType, data = data, type = Media.Type.VIDEO, thumbnailId = thumbnailId))
        }

        cursor.close()

        return list.asSequence()
    }

    private enum class Projection(val columnName: String, val columnIndex: Int) {

        TITLE(columnName = MediaStore.Video.VideoColumns.TITLE, columnIndex = 0),
        MIME_TYPE(columnName = MediaStore.Video.VideoColumns.MIME_TYPE, columnIndex = 1),
        ID(columnName = MediaStore.Video.VideoColumns._ID, columnIndex = 2),
        DATA(columnName = MediaStore.Video.VideoColumns.DATA, columnIndex = 3),
        THUMBNAIL(columnName = MediaStore.Video.Thumbnails._ID, columnIndex = 4)
    }
}