package com.chrynan.androidsearch.presenter

import com.chrynan.aclifecycle.BaseCoroutineScope
import kotlinx.coroutines.Job

abstract class CoroutinePresenter : BaseCoroutineScope, Presenter {

    override val job: Job = Job()

    override fun detachView() {
        job.cancel()
    }
}