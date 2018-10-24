package com.chrynan.androidsearch.mapper

import android.content.Context
import com.chrynan.androidsearch.R
import com.chrynan.androidsearch.util.*
import com.chrynan.androidsearch.viewmodel.AutoCompleteResultViewModel
import com.chrynan.mapper.UniDirectionalMapper
import java.io.File

class FileMapper(context: Context) : UniDirectionalMapper<File, AutoCompleteResultViewModel.File> {

    private val descriptionTextFormatter: (String) -> String = { context.getString(R.string.auto_complete_description, it) }

    private val filesDescription by lazy { descriptionTextFormatter(context.getString(R.string.auto_complete_description_title_files)) }
    private val documentsDescription by lazy { descriptionTextFormatter(context.getString(R.string.auto_complete_description_title_documents)) }
    private val musicDescription by lazy { descriptionTextFormatter(context.getString(R.string.auto_complete_description_title_music)) }
    private val moviesDescription by lazy { descriptionTextFormatter(context.getString(R.string.auto_complete_description_title_movies)) }
    private val picturesDescription by lazy { descriptionTextFormatter(context.getString(R.string.auto_complete_description_title_pictures)) }
    private val mediaDescription by lazy { descriptionTextFormatter(context.getString(R.string.auto_complete_description_title_media)) }
    private val podcastsDescription by lazy { descriptionTextFormatter(context.getString(R.string.auto_complete_description_title_podcasts)) }
    private val downloadsDescription by lazy { descriptionTextFormatter(context.getString(R.string.auto_complete_description_title_documents)) }

    override fun map(value: File): AutoCompleteResultViewModel.File =
            AutoCompleteResultViewModel.File(
                    title = value.name,
                    description = getDescription(value),
                    defaultIconResId = 0,
                    iconFetcher = null,
                    actionIcon = null,
                    location = value.absolutePath)

    private fun getDescription(file: File): String =
            when {
                file.isInDocumentDirectory -> documentsDescription
                file.isInMusicDirectory -> musicDescription
                file.isInMovieDirectory -> moviesDescription
                file.isInPictureDirectory -> picturesDescription
                file.isInMediaDirectory -> mediaDescription
                file.isInPodcastDirectory -> podcastsDescription
                file.isInDownloadDirectory -> downloadsDescription
                else -> filesDescription
            }
}