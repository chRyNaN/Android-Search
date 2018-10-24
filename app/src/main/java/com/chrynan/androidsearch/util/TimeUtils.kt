package com.chrynan.androidsearch.util

import kotlin.system.measureTimeMillis

fun <T> measureTimeMillisWithResult(block: () -> T): Pair<T, Long> {
    var value: T? = null
    val time = measureTimeMillis {
        value = block()
    }
    return value?.let { it to time } ?: throw NullPointerException()
}