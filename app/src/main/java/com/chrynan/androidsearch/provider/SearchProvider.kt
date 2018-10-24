package com.chrynan.androidsearch.provider

import com.chrynan.aaaah.UniqueAdapterItem
import com.chrynan.androidsearch.preference.SearchPreferences
import kotlinx.coroutines.experimental.channels.produce

class SearchProvider(
        private val appProvider: AppProvider,
        private val audioProvider: AudioProvider,
        private val imageProvider: ImageProvider,
        private val videoProvider: VideoProvider,
        private val contactProvider: ContactProvider,
        private val emailProvider: EmailProvider,
        private val instantAnswerProvider: InstantAnswerProvider,
        private val phoneNumberProvider: PhoneNumberProvider,
        private val searchHistoryProvider: SearchHistoryProvider,
        private val typeAheadProvider: TypeAheadProvider,
        private val webAddressProvider: WebAddressProvider,
        private val searchPreferences: SearchPreferences
) : SearchPreferences.SearchPreferenceChangedListener {

    init {
        searchPreferences.addSearchPreferenceChangedListener(this)
    }

    private var providers: Set<ResultProvider<UniqueAdapterItem>> = getUpdatedProviders()

    @Suppress("ConvertCallChainIntoSequence")
    suspend fun query(query: String?) = produce {
        var sequence = emptySequence<UniqueAdapterItem>()

        if (query.isNullOrBlank()) {
            send(sequence)
        } else {
            val nonNullQuery = query!!

            providers
                    .filter { it.handlesQuery(nonNullQuery) }
                    .map { it.query(nonNullQuery) }
                    .forEach {
                        sequence += it.await()
                        send(sequence)
                    }
        }
    }

    override fun onPreferenceChanged() {
        providers = getUpdatedProviders()
    }

    private fun getUpdatedProviders(): Set<ResultProvider<UniqueAdapterItem>> {
        val newProviders = mutableSetOf<ResultProvider<UniqueAdapterItem>>()

        with(searchPreferences) {
            if (instantAnswers) newProviders += instantAnswerProvider
            if (typeAhead) newProviders += typeAheadProvider
            if (history) newProviders += searchHistoryProvider
            if (apps) newProviders += appProvider
            if (audioFiles) newProviders += audioProvider
            if (imageFiles) newProviders += imageProvider
            if (videoFiles) newProviders += videoProvider
            if (contacts) newProviders += contactProvider
            if (emailLink) newProviders += emailProvider
            if (phoneNumberLink) newProviders += phoneNumberProvider
            if (webAddressLink) newProviders += webAddressProvider
        }

        return newProviders
    }
}