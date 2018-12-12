package com.chrynan.androidsearch.navigator.source

import android.app.Activity
import android.content.Context
import android.content.Intent
import com.chrynan.androidsearch.navigator.Navigator
import com.chrynan.androidviews.layout.AndroidLayout
import com.chrynan.androidviews.layout.AndroidLayoutProvider
import com.chrynan.queue.mutableStackOf

abstract class BaseNavigatorSource(private val parentActivity: Activity) : Navigator {

    private val layoutStack = mutableStackOf<AndroidLayout>()

    override fun goBack() {
        // Remove the current layout
        layoutStack.pop()

        if (layoutStack.isNotEmpty()) {
            // Go to the previous layout
            showLayoutInParentActivity(layoutStack.peek())
        } else {
            // Go back on the Activity
            parentActivity.onBackPressed()
        }
    }

    protected fun goToLayout(layout: AndroidLayout) {
        showLayoutInParentActivity(layout)
        layoutStack.push(layout)
    }

    protected fun goToActivity(block: (Context) -> Intent) {
        parentActivity.startActivity(block(parentActivity))
    }

    private fun showLayoutInParentActivity(layout: AndroidLayout) {
        AndroidLayoutProvider.layout(parentActivity, layout)
    }
}