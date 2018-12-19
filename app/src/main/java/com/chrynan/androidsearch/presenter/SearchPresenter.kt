package com.chrynan.androidsearch.presenter

import android.content.Context
import android.support.v7.util.ListUpdateCallback
import android.util.Log
import com.chrynan.aaaah.DiffProcessor
import com.chrynan.aaaah.ManagerRecyclerViewAdapter
import com.chrynan.aaaah.UniqueAdapterItem
import com.chrynan.accore.runInBackground
import com.chrynan.accore.runOnAndroidUI
import com.chrynan.androidsearch.action.AutoCompleteAction
import com.chrynan.androidsearch.action.OpenSearchUrlInBrowserAction
import com.chrynan.androidsearch.model.wrapper.Query
import com.chrynan.androidsearch.provider.SearchProvider
import com.chrynan.androidsearch.util.measureTimeMillisWithResult
import com.chrynan.androidsearch.viewmodel.AutoCompleteResultViewModel
import javax.inject.Inject
import kotlin.system.measureTimeMillis

class SearchPresenter @Inject constructor(
        private val autoCompleteProvider: SearchProvider,
        private val adapter: ManagerRecyclerViewAdapter<UniqueAdapterItem>,
        private val diffProcessor: DiffProcessor<UniqueAdapterItem>,
        private val updateCallback: ListUpdateCallback,
        private val searchAction: OpenSearchUrlInBrowserAction,
        private val autoCompleteAction: AutoCompleteAction
) : CoroutinePresenter() {

    fun performQuery(query: String?) {
        runInBackground {
            val time = measureTimeMillis {
                autoCompleteProvider.query(query) { results ->
                    val queryPair = measureTimeMillisWithResult {
                        results
                    }
                    val resultList = queryPair.first
                    val diffPair = measureTimeMillisWithResult {
                        diffProcessor.calculateDiff(resultList)
                    }
                    val diffResult = diffPair.first

                    runOnAndroidUI {
                        adapter.items = resultList
                        diffResult.dispatchUpdatesTo(updateCallback)
                    }
                }
            }
            Log.d("TimeCount", "totalTime: milliseconds = $time; seconds = ${time / 1000}")
        }
    }

    fun performSearch(context: Context, query: String) {
        searchAction.perform(context, Query(query))
    }

    fun handleSelection(context: Context, result: AutoCompleteResultViewModel) {
        autoCompleteAction.perform(context, result)
    }
}