package com.chrynan.androidsearch.util

import android.content.Context
import android.graphics.drawable.Drawable
import com.bumptech.glide.Glide
import com.bumptech.glide.Registry
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.module.AppGlideModule
import com.chrynan.glidedrawable.ApplicationIconDrawableFunction
import com.chrynan.glidedrawable.ContactThumbnailDrawableFunction
import com.chrynan.glidedrawable.DrawableFunctionLoaderFactory
import com.chrynan.glidedrawable.ImageVideoThumbnailDrawableFunction

@GlideModule
class SearchAppGlideModule : AppGlideModule() {

    override fun registerComponents(context: Context, glide: Glide, registry: Registry) {
        registry.prepend(ApplicationIconDrawableFunction::class.java, Drawable::class.java, DrawableFunctionLoaderFactory())
        registry.prepend(ContactThumbnailDrawableFunction::class.java, Drawable::class.java, DrawableFunctionLoaderFactory())
        registry.prepend(ImageVideoThumbnailDrawableFunction::class.java, Drawable::class.java, DrawableFunctionLoaderFactory())
    }
}