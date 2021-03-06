@file:Suppress("EXPERIMENTAL_API_USAGE")

package com.chrynan.androidsearch.provider

import com.chrynan.aaaah.UniqueAdapterItem
import com.chrynan.androidsearch.preference.SearchPreferences
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SearchProvider @Inject constructor(
        private val appProvider: AppProvider,
        private val audioProvider: AudioProvider,
        private val imageProvider: ImageProvider,
        private val videoProvider: VideoProvider,
        private val contactProvider: ContactProvider,
        private val emailProvider: EmailProvider,
        private val phoneNumberProvider: PhoneNumberProvider,
        private val searchHistoryProvider: SearchHistoryProvider,
        private val typeAheadProvider: TypeAheadProvider,
        private val webAddressProvider: WebAddressProvider,
        private val searchPreferences: SearchPreferences
) : SearchPreferences.SearchPreferenceChangedListener {

    init {
        searchPreferences.addSearchPreferenceChangedListener(this)
    }

    private var providers: Set<QueryResultProvider<UniqueAdapterItem>> = getUpdatedProviders()

    @Suppress("ConvertCallChainIntoSequence")
    suspend fun query(query: String?, onUpdate: (List<UniqueAdapterItem>) -> Unit) = coroutineScope {
        val list = mutableListOf<UniqueAdapterItem>()

        if (query.isNullOrBlank()) {
            onUpdate(list)
        } else {
            providers
                    .filter { it.handlesQuery(query) }
                    .map { async { it.query(query) } }
                    .forEach {
                        list.addAll(it.await())
                        onUpdate(list)
                    }
        }
    }

    override fun onPreferenceChanged() {
        providers = getUpdatedProviders()
    }

    private fun getUpdatedProviders(): Set<QueryResultProvider<UniqueAdapterItem>> {
        val newProviders = mutableSetOf<QueryResultProvider<UniqueAdapterItem>>()

        with(searchPreferences) {
            //if (instantAnswers) newProviders += instantAnswerProvider
            if (typeAhead) newProviders += typeAheadProvider
            if (history) newProviders += searchHistoryProvider
            if (audioFiles) newProviders += audioProvider
            if (imageFiles) newProviders += imageProvider
            if (videoFiles) newProviders += videoProvider
            if (contacts) newProviders += contactProvider
            if (emailLink) newProviders += emailProvider
            if (phoneNumberLink) newProviders += phoneNumberProvider
            if (webAddressLink) newProviders += webAddressProvider
            if (apps) newProviders += appProvider
        }

        return newProviders
    }
}