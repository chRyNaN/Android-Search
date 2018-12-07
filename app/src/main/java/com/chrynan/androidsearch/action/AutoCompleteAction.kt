package com.chrynan.androidsearch.action

import android.content.Context
import com.chrynan.androidsearch.model.wrapper.Query
import com.chrynan.androidsearch.viewmodel.AutoCompleteResultViewModel
import javax.inject.Inject

class AutoCompleteAction @Inject constructor(
        private val openAppAction: OpenAppAction,
        private val openContactAction: OpenContactAction,
        private val openDialerAction: OpenDialerAction,
        private val openSmsAppAction: OpenSmsAction,
        private val openFileAction: OpenFileAction,
        private val openUrlAction: OpenUrlAction,
        private val openEmailAction: OpenEmailAction,
        private val searchAction: SearchAction
) : QueryResultAction<AutoCompleteResultViewModel> {

    override fun perform(context: Context, item: AutoCompleteResultViewModel) =
            when (item) {
                is AutoCompleteResultViewModel.App -> openAppAction.perform(context, item.packageName)
                is AutoCompleteResultViewModel.PhoneNumber -> {
                    if (item.callAction) {
                        openDialerAction.perform(context, item.phoneNumber)
                    } else {
                        openSmsAppAction.perform(context, item.phoneNumber)
                    }
                }
                is AutoCompleteResultViewModel.File -> openFileAction.perform(context, item.location)
                is AutoCompleteResultViewModel.WebAddress -> openUrlAction.perform(context, item.url)
                is AutoCompleteResultViewModel.Email -> openEmailAction.perform(context, item.email)
                is AutoCompleteResultViewModel.Contact -> openContactAction.perform(context, item.id)
                else -> searchAction.perform(context, Query(item.title))
            }
}