package com.chrynan.androidsearch.viewmodel

import android.graphics.drawable.Drawable
import com.chrynan.aaaah.AdapterId
import com.chrynan.aaaah.UniqueAdapterItem
import com.chrynan.androidsearch.model.wrapper.*

sealed class AutoCompleteResultViewModel : ResultViewModel,
        UniqueAdapterItem {

    data class App(
            override val title: String,
            override val uniqueAdapterId: AdapterId = title.hashCode().toLong(),
            override val description: String? = null,
            override val defaultIconResId: Int,
            override val iconFetcher: (() -> Drawable)? = null,
            override val actionIcon: Drawable? = null,
            val packageName: PackageName
    ) : AutoCompleteResultViewModel()

    data class PhoneNumber(
            override val title: String,
            override val uniqueAdapterId: AdapterId = title.hashCode().toLong(),
            override val description: String? = null,
            override val defaultIconResId: Int,
            override val iconFetcher: (() -> Drawable)? = null,
            override val actionIcon: Drawable? = null,
            val phoneNumber: com.chrynan.androidsearch.model.wrapper.PhoneNumber,
            val callAction: Boolean = true
    ) : AutoCompleteResultViewModel()

    data class File(
            override val title: String,
            override val uniqueAdapterId: AdapterId = title.hashCode().toLong(),
            override val description: String? = null,
            override val defaultIconResId: Int,
            override val iconFetcher: (() -> Drawable)? = null,
            override val actionIcon: Drawable? = null,
            val location: FileLocation
    ) : AutoCompleteResultViewModel()

    data class WebAddress(
            override val title: String,
            override val uniqueAdapterId: AdapterId = title.hashCode().toLong(),
            override val description: String? = null,
            override val defaultIconResId: Int,
            override val iconFetcher: (() -> Drawable)? = null,
            override val actionIcon: Drawable? = null,
            val url: Url
    ) : AutoCompleteResultViewModel()

    data class Email(
            override val title: String,
            override val uniqueAdapterId: AdapterId = title.hashCode().toLong(),
            override val description: String? = null,
            override val defaultIconResId: Int,
            override val iconFetcher: (() -> Drawable)? = null,
            override val actionIcon: Drawable? = null,
            val email: com.chrynan.androidsearch.model.wrapper.Email
    ) : AutoCompleteResultViewModel()

    data class SearchHistory(
            override val title: String,
            override val uniqueAdapterId: AdapterId = title.hashCode().toLong(),
            override val description: String? = null,
            override val defaultIconResId: Int,
            override val iconFetcher: (() -> Drawable)? = null,
            override val actionIcon: Drawable? = null,
            val query: Query
    ) : AutoCompleteResultViewModel()

    data class Contact(
            override val title: String,
            override val uniqueAdapterId: AdapterId = title.hashCode().toLong(),
            override val description: String? = null,
            override val defaultIconResId: Int,
            override val iconFetcher: (() -> Drawable)? = null,
            override val actionIcon: Drawable? = null,
            val name: String,
            val id: ContactId,
            val lookupKey: String,
            val photoUri: String? = null
    ) : AutoCompleteResultViewModel()

    data class TypeAheadSearch(
            override val title: String,
            override val uniqueAdapterId: AdapterId = title.hashCode().toLong(),
            override val description: String? = null,
            override val defaultIconResId: Int,
            override val iconFetcher: (() -> Drawable)? = null,
            override val actionIcon: Drawable? = null,
            val suggestion: String
    ) : AutoCompleteResultViewModel()

    data class Media(
            override val title: String,
            override val uniqueAdapterId: AdapterId = title.hashCode().toLong(),
            override val description: String? = null,
            override val defaultIconResId: Int,
            override val iconFetcher: (() -> Drawable)? = null,
            override val actionIcon: Drawable? = null,
            val id: Long,
            val mimeType: String? = null,
            val type: com.chrynan.androidsearch.model.Media.Type,
            val data: String
    ) : AutoCompleteResultViewModel()
}

interface ResultViewModel {

    val title: String
    val description: String?
    val defaultIconResId: Int
    val iconFetcher: (() -> Drawable)?
    val actionIcon: Drawable?
}