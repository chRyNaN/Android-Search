package com.chrynan.androidsearch.ui.activity

import android.Manifest
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.chrynan.aaaah.ManagerRecyclerViewAdapter
import com.chrynan.aaaah.UniqueAdapterItem
import com.chrynan.androidsearch.R
import com.chrynan.androidsearch.presenter.SearchPresenter
import com.chrynan.androidsearch.ui.adapter.AutoCompleteResultViewModelAdapter
import com.chrynan.androidsearch.util.doOnLayout
import com.chrynan.androidsearch.util.onEnterAction
import com.chrynan.androidsearch.util.onTextChanged
import com.chrynan.androidsearch.viewmodel.AutoCompleteResultViewModel
import com.fondesa.kpermissions.extension.listeners
import com.fondesa.kpermissions.extension.permissionsBuilder
import kotlinx.android.synthetic.main.activity_search.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class SearchActivity : BaseActivity(),
        AutoCompleteResultViewModelAdapter.AutoCompleteResultSelectedListener {

    private val managerAdapter: ManagerRecyclerViewAdapter<UniqueAdapterItem> by inject { parametersOf(this) }
    private val presenter: SearchPresenter by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        permissionsBuilder(Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.READ_CONTACTS).build().apply {
            listeners {

            }
        }.send()

        searchWidget?.apply {
            onTextChanged { presenter.performQuery(it) }
            onEnterAction { presenter.performSearch(this@SearchActivity, it ?: "") }
        }

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
        presenter.handleSelection(this, result)
    }
}