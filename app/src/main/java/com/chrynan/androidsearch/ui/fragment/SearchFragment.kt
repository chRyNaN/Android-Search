@file:Suppress("EXPERIMENTAL_API_USAGE")

package com.chrynan.androidsearch.ui.fragment

import android.Manifest
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chrynan.aaaah.ManagerRecyclerViewAdapter
import com.chrynan.aaaah.UniqueAdapterItem
import com.chrynan.acview.onEnterAction
import com.chrynan.acview.onTextChanged
import com.chrynan.androidsearch.R
import com.chrynan.androidsearch.presenter.SearchPresenter
import com.chrynan.androidsearch.ui.activity.SettingsActivity
import com.chrynan.androidsearch.ui.adapter.AutoCompleteResultViewModelAdapter
import com.chrynan.androidsearch.util.doOnLayout
import com.chrynan.androidsearch.viewmodel.AutoCompleteResultViewModel
import com.fondesa.kpermissions.extension.listeners
import com.fondesa.kpermissions.extension.permissionsBuilder
import kotlinx.android.synthetic.main.fragment_search.*
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class SearchFragment : BaseFragment(),
        AutoCompleteResultViewModelAdapter.AutoCompleteResultSelectedListener {

    private val managerAdapter: ManagerRecyclerViewAdapter<UniqueAdapterItem> by inject { parametersOf(this) }
    private val presenter: SearchPresenter by inject { parametersOf(this) }

    companion object {

        fun newInstance() = SearchFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_search, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        permissionsBuilder(Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.READ_CONTACTS).build().apply {
            listeners {

            }
        }.send()

        launch {
            searchWidget?.apply {
                onTextChanged { presenter.performQuery(it.charSequence.toString()) }
                onEnterAction { presenter.performSearch(context!!, text.toString()) }
            }
        }

        settingsButton?.setOnClickListener { startActivity(SettingsActivity.newIntent(context!!)) }

        // There's this odd thing happening with android extensions. This was working normally before but not anymore
        // and I'm not sure why. Pretty much the nested view extension (here searchWidget) isn't available in the
        // listener function anymore. So, initialize a variable here and access it that way.
        val searchWidgetNonNull = searchWidget!!

        resultsRecyclerView?.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = managerAdapter

            doOnLayout {
                setPadding(paddingLeft,
                        paddingTop + searchWidgetNonNull.measuredHeight,
                        paddingRight,
                        paddingBottom)
            }
        }
    }

    override fun onAutoCompleteResultSelected(result: AutoCompleteResultViewModel) {
        presenter.handleSelection(context!!, result)
    }
}