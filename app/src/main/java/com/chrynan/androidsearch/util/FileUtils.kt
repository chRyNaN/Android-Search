package com.chrynan.androidsearch.util

import android.os.Environment
import java.io.File
import java.io.FileFilter

val DOCUMENT_DIRECTORY: File = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)
val MUSIC_DIRECTORY: File = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC)
val MOVIE_DIRECTORY: File = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES)
val PICTURE_DIRECTORY: File = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)
val MEDIA_DIRECTORY: File = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM)
val PODCAST_DIRECTORY: File = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PODCASTS)
val DOWNLOAD_DIRECTORY: File = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)

val File.isInDocumentDirectory
    get() = !isDirectory and absolutePath.startsWith(DOCUMENT_DIRECTORY.absolutePath)

val File.isInMusicDirectory
    get() = !isDirectory and absolutePath.startsWith(MUSIC_DIRECTORY.absolutePath)

val File.isInMovieDirectory
    get() = !isDirectory and absolutePath.startsWith(MOVIE_DIRECTORY.absolutePath)

val File.isInPictureDirectory
    get() = !isDirectory and absolutePath.startsWith(PICTURE_DIRECTORY.absolutePath)

val File.isInMediaDirectory
    get() = !isDirectory and absolutePath.startsWith(MEDIA_DIRECTORY.absolutePath)

val File.isInPodcastDirectory
    get() = !isDirectory and absolutePath.startsWith(PODCAST_DIRECTORY.absolutePath)

val File.isInDownloadDirectory
    get() = !isDirectory and absolutePath.startsWith(DOWNLOAD_DIRECTORY.absolutePath)

fun File.listFilesIncludingSubdirectories(fileFilter: FileFilter): Sequence<File> {
    val files = listFiles()?.toMutableList() ?: mutableListOf()
    addFilesRecursively(absolutePath, files)
    return files.asSequence()
            .filter { fileFilter.accept(it) }
}

private fun addFilesRecursively(directoryName: String, files: MutableList<File>) {
    val directory = File(directoryName)

    // Get all files from a directory.
    val fList = directory.listFiles()

    if (fList != null) {
        for (file in fList) {
            if (file.isFile) {
                files.add(file)
            } else if (file.isDirectory) {
                addFilesRecursively(file.absolutePath, files)
            }
        }
    }
}