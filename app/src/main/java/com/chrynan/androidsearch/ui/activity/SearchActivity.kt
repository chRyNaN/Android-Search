package com.chrynan.androidsearch.ui.activity

import android.os.Bundle
import com.chrynan.androidsearch.R
import com.chrynan.androidsearch.ui.fragment.SearchFragment
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
class SearchActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_fragment_container)

        supportFragmentManager.beginTransaction().add(R.id.fragmentContainer, SearchFragment.newInstance()).commit()
    }
}