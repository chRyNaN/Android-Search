package com.chrynan.androidsearch.mapper

import android.content.Context
import com.chrynan.androidsearch.R
import com.chrynan.androidsearch.model.Media
import com.chrynan.androidsearch.viewmodel.AutoCompleteResultViewModel
import com.chrynan.glidedrawable.ImageVideoThumbnailDrawableFunction
import com.chrynan.mapper.UniDirectionalMapper
import javax.inject.Inject

class MediaMapper @Inject constructor(private val context: Context) : UniDirectionalMapper<Media, AutoCompleteResultViewModel.Media> {

    private val descriptionFormatter: (String) -> String = { context.getString(R.string.auto_complete_description, it) }

    private val filesDescription by lazy { descriptionFormatter(context.getString(R.string.auto_complete_description_title_files)) }
    private val musicDescription by lazy { descriptionFormatter(context.getString(R.string.auto_complete_description_title_music)) }
    private val moviesDescription by lazy { descriptionFormatter(context.getString(R.string.auto_complete_description_title_movies)) }
    private val picturesDescription by lazy { descriptionFormatter(context.getString(R.string.auto_complete_description_title_pictures)) }

    override fun map(value: Media): AutoCompleteResultViewModel.Media =
            AutoCompleteResultViewModel.Media(
                    title = value.title,
                    description = getDescription(value),
                    defaultIconResId = 0,
                    iconFetcher = value.thumbnailId?.let {
                        if (value.type == Media.Type.IMAGE || value.type == Media.Type.VIDEO) {
                            ImageVideoThumbnailDrawableFunction(context = context, thumbnailId = it, isImage = value.type == Media.Type.IMAGE)
                        } else null
                    },
                    actionIcon = null,
                    id = value.id,
                    mimeType = value.mimeType,
                    data = value.data,
                    type = value.type)

    private fun getDescription(media: Media): String =
            when {
                media.isAudio -> musicDescription
                media.isVideo -> moviesDescription
                media.isImage -> picturesDescription
                else -> filesDescription
            }

    private val Media.isAudio: Boolean
        get() = type == Media.Type.AUDIO

    private val Media.isVideo: Boolean
        get() = type == Media.Type.VIDEO

    private val Media.isImage: Boolean
        get() = type == Media.Type.IMAGE
}