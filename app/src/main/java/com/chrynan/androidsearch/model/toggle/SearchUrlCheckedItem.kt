package com.chrynan.androidsearch.model.toggle

import com.chrynan.androidsearch.model.wrapper.Url

sealed class SearchUrlCheckedItem {

    object Bing : SearchUrlCheckedItem()

    object ContextualWebSearch : SearchUrlCheckedItem()

    object DuckDuckGo : SearchUrlCheckedItem()

    object Google : SearchUrlCheckedItem()

    data class Custom(val url: Url) : SearchUrlCheckedItem()
}