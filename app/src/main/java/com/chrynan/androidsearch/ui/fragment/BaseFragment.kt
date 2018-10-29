package com.chrynan.androidsearch.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import org.koin.android.scope.ext.android.bindScope
import org.koin.android.scope.ext.android.createScope

abstract class BaseFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindScope(createScope(this.javaClass.name))
    }
}