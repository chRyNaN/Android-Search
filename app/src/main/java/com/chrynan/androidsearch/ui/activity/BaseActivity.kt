package com.chrynan.androidsearch.ui.activity

import android.os.Bundle
import com.chrynan.aclifecycle.CoroutineAppCompatActivity
import org.koin.android.scope.ext.android.bindScope
import org.koin.android.scope.ext.android.getOrCreateScope

abstract class BaseActivity : CoroutineAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindScope(getOrCreateScope(this.javaClass.name))
    }
}