package com.chrynan.androidsearch.util

import kotlinx.coroutines.experimental.*
import kotlinx.coroutines.experimental.android.Main

fun runOnAndroidUI(block: suspend CoroutineScope.() -> Unit): Job = GlobalScope.launch(context = Dispatchers.Main, block = block)

fun runInBackground(block: suspend CoroutineScope.() -> Unit): Job = GlobalScope.launch(context = Dispatchers.IO, block = block)