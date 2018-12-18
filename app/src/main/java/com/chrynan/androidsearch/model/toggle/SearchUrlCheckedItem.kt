package com.chrynan.androidsearch.model.toggle

import com.chrynan.androidsearch.model.QueryUrls
import com.chrynan.androidsearch.model.wrapper.Url

sealed class SearchUrlCheckedItem(val url: Url) {

    companion object {

        fun fromUrl(url: Url): SearchUrlCheckedItem =
                when (url.value) {
                    QueryUrls.BING -> Bing
                    QueryUrls.CONTEXTUAL_WEB_SEARCH -> ContextualWebSearch
                    QueryUrls.DUCK_DUCK_GO -> DuckDuckGo
                    QueryUrls.GOOGLE -> Google
                    else -> Custom(url = url)
                }
    }

    object Bing : SearchUrlCheckedItem(url = Url(QueryUrls.BING))

    object ContextualWebSearch : SearchUrlCheckedItem(url = Url(QueryUrls.CONTEXTUAL_WEB_SEARCH))

    object DuckDuckGo : SearchUrlCheckedItem(url = Url(QueryUrls.DUCK_DUCK_GO))

    object Google : SearchUrlCheckedItem(url = Url(QueryUrls.GOOGLE))

    class Custom(url: Url) : SearchUrlCheckedItem(url = url)
}