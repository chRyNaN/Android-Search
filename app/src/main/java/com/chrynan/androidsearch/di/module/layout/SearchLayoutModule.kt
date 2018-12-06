@file:Suppress("unused")

package com.chrynan.androidsearch.di.module.layout

import android.support.v7.util.ListUpdateCallback
import com.chrynan.aaaah.DiffProcessor
import com.chrynan.aaaah.ManagerRecyclerViewAdapter
import com.chrynan.aaaah.UniqueAdapterItem
import com.chrynan.androidsearch.di.scope.LayoutScope
import com.chrynan.androidsearch.ui.adapter.AnswerAdapter
import com.chrynan.androidsearch.ui.adapter.AutoCompleteResultViewModelAdapter
import com.chrynan.androidsearch.ui.adapter.DefinitionAdapter
import com.chrynan.androidsearch.ui.adapter.TopicListAdapter
import com.chrynan.androidsearch.ui.layout.SearchLayout
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class SearchLayoutModule {

    @Module
    companion object {

        @JvmStatic
        @Provides
        @LayoutScope
        fun provideAdapter(autoCompleteAdapter: AutoCompleteResultViewModelAdapter,
                           answerAdapter: AnswerAdapter,
                           definitionAdapter: DefinitionAdapter,
                           topicListAdapter: TopicListAdapter) =
                ManagerRecyclerViewAdapter<UniqueAdapterItem>(setOf(autoCompleteAdapter, answerAdapter, definitionAdapter, topicListAdapter))

        @JvmStatic
        @Provides
        @LayoutScope
        fun provideDiffProcessor() = DiffProcessor<UniqueAdapterItem>()
    }

    @Binds
    @LayoutScope
    abstract fun provideAutoCompleteSelectedListener(layout: SearchLayout): AutoCompleteResultViewModelAdapter.AutoCompleteResultSelectedListener

    @Binds
    @LayoutScope
    abstract fun bindListUpdateCallback(adapter: ManagerRecyclerViewAdapter<UniqueAdapterItem>): ListUpdateCallback
}