package com.chrynan.androidsearch.mapper

import com.chrynan.androidsearch.model.Media
import com.chrynan.androidsearch.resource.MediaMapperResources
import com.chrynan.androidsearch.resource.source.MediaMapperResourcesSource
import com.chrynan.androidsearch.util.AppContext
import com.chrynan.androidsearch.viewmodel.AutoCompleteResultViewModel
import com.chrynan.glidedrawable.ImageVideoThumbnailDrawableFunction
import com.chrynan.mapper.UniDirectionalMapper
import javax.inject.Inject

class MediaMapper @Inject constructor(
        private val context: AppContext,
        res: MediaMapperResourcesSource
) : UniDirectionalMapper<Media, AutoCompleteResultViewModel.Media>,
        MediaMapperResources by res {

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