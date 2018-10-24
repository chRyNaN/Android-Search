package com.chrynan.androidsearch.ui

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.provider.MediaStore
import com.bumptech.glide.load.Key
import com.bumptech.glide.signature.ObjectKey
import com.chrynan.glidedrawable.DrawableFunction

class ImageVideoThumbnailDrawableFunction(
        private val context: Context,
        private val thumbnailId: Long,
        private val isImage: Boolean
) : DrawableFunction {

    companion object {

        private const val KEY_PREFIX = "media:thumbnail"
    }

    override val uniqueKey: Key = ObjectKey("$KEY_PREFIX:$thumbnailId")

    override val function: () -> Drawable = {
        BitmapDrawable(
                context.resources,
                getBitmap())
    }

    private fun getBitmap() =
            if (isImage) {
                MediaStore.Images.Thumbnails.getThumbnail(context.contentResolver, thumbnailId, MediaStore.Images.Thumbnails.MICRO_KIND, BitmapFactory.Options())
            } else {
                MediaStore.Video.Thumbnails.getThumbnail(context.contentResolver, thumbnailId, MediaStore.Video.Thumbnails.MICRO_KIND, BitmapFactory.Options())
            }
}