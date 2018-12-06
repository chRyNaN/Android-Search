package com.chrynan.androidsearch.ui.activity

import android.os.Bundle
import com.chrynan.aclifecycle.CoroutineAppCompatActivity

abstract class BaseActivity : CoroutineAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupDependencies()
    }

    abstract fun setupDependencies()
}