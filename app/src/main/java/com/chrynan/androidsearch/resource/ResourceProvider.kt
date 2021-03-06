package com.chrynan.androidsearch.resource

import android.content.res.Resources
import android.graphics.drawable.Drawable
import androidx.annotation.ColorRes
import androidx.annotation.DimenRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.chrynan.androidsearch.util.*
import com.chrynan.inlinepixel.ContextScreenDimensionUnitConverter
import com.chrynan.inlinepixel.ScreenDimensionUnitConverter

open class ResourceProvider(private val appContext: AppContext) : ScreenDimensionUnitConverter by ContextScreenDimensionUnitConverter(appContext) {

    protected fun string(@StringRes resourceId: StringResourceId): Lazy<String> =
            lazy { appContext.getString(resourceId) }

    protected fun <T : Any> formattedString(@StringRes resourceId: StringResourceId): Lazy<(T) -> String> =
            lazyOf({ args -> appContext.resources.getString(resourceId, args) })

    protected fun color(@ColorRes resourceId: ColorResourceId, theme: Resources.Theme = appContext.theme): Lazy<Int> =
            lazy { appContext.resources.getColor(resourceId, theme) }

    protected fun dimenPixelSize(@DimenRes resourceId: DimenResourceId): Lazy<Int> =
            lazy { appContext.resources.getDimensionPixelSize(resourceId) }

    protected fun dimenPixelOffset(@DimenRes resourceId: DimenResourceId): Lazy<Int> =
            lazy { appContext.resources.getDimensionPixelOffset(resourceId) }

    protected fun dimen(@DimenRes resourceId: DimenResourceId): Lazy<Float> =
            lazy { appContext.resources.getDimension(resourceId) }

    protected fun drawable(@DrawableRes resourceId: DrawableResourceId, theme: Resources.Theme = appContext.theme): Lazy<Drawable> =
            lazy { appContext.resources.getDrawable(resourceId, theme) }
}