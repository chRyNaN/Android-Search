package com.chrynan.androidsearch.ui.fragment

import android.os.Bundle
import com.chrynan.aclifecycle.CoroutineAppCompatFragment
import org.koin.android.scope.ext.android.bindScope
import org.koin.android.scope.ext.android.getOrCreateScope

abstract class BaseFragment : CoroutineAppCompatFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindScope(getOrCreateScope(this.javaClass.name))
    }
}