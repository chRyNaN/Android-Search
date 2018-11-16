package com.chrynan.androidsearch.di.module

import android.support.v7.util.ListUpdateCallback
import com.chrynan.aaaah.DiffProcessor
import com.chrynan.aaaah.ManagerRecyclerViewAdapter
import com.chrynan.aaaah.UniqueAdapterItem
import com.chrynan.androidsearch.presenter.SearchPresenter
import com.chrynan.androidsearch.ui.adapter.*
import com.chrynan.androidsearch.ui.fragment.SearchFragment
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module.module

private val SEARCH_SCOPE_NAME = SearchFragment::class.java.name

val SEARCH_MODULE = module {
    scope(SEARCH_SCOPE_NAME) {
        ManagerRecyclerViewAdapter<UniqueAdapterItem>(adapters = setOf(
                get<AutoCompleteResultViewModelAdapter>(parameters = { it }),
                get<AnswerAdapter>(parameters = { it }),
                get<DefinitionAdapter>(parameters = { it }),
                get<TopicListAdapter>(parameters = { it })
        ))
    }
    scope(SEARCH_SCOPE_NAME) { get<ManagerRecyclerViewAdapter<UniqueAdapterItem>>() as ListUpdateCallback }
    scope(SEARCH_SCOPE_NAME) {
        SearchPresenter(
                autoCompleteProvider = get(),
                adapter = get(),
                diffProcessor = get(),
                updateCallback = get(),
                searchAction = get(),
                autoCompleteAction = get())
    }
    scope(SEARCH_SCOPE_NAME) { (fragment: SearchFragment) -> fragment as AutoCompleteResultViewModelAdapter.AutoCompleteResultSelectedListener }
    scope(SEARCH_SCOPE_NAME) { AutoCompleteResultViewModelAdapter(listener = get(parameters = { it })) }
    scope(SEARCH_SCOPE_NAME) { AnswerAdapter() }
    scope(SEARCH_SCOPE_NAME) { DefinitionAdapter() }
    scope(SEARCH_SCOPE_NAME) { TopicListAdapter(context = androidContext(), topicAdapter = get()) }
    scope(SEARCH_SCOPE_NAME) { TopicAdapter() }
    scope(SEARCH_SCOPE_NAME) { DiffProcessor<UniqueAdapterItem>() }
}