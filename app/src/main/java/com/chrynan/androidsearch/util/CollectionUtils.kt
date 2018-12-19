@file:Suppress("unused")

package com.chrynan.androidsearch.util

import java.text.Collator

inline fun <reified T> Sequence<T>.sortAlphabeticallyBy(crossinline selector: (T) -> String): Sequence<T> {
    val collator = Collator.getInstance()

    return sortedWith(Comparator { a, b -> collator.compare(selector(a), selector(b)) })
}

inline fun <reified T> List<T>.containsQueryIgnoreCase(query: String, crossinline compareBy: (T) -> String): List<T> =
        filter { compareBy(it).toLowerCase().contains(query.toLowerCase()) }