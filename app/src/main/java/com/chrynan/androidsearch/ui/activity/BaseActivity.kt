package com.chrynan.androidsearch.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import org.koin.android.scope.ext.android.bindScope
import org.koin.android.scope.ext.android.createScope

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindScope(createScope(this.javaClass.name))
    }
}