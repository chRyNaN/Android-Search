package com.chrynan.androidsearch.action

import android.content.Context
import com.chrynan.androidsearch.viewmodel.AutoCompleteResultViewModel

class AutoCompleteAction(
        private val openAppAction: OpenAppAction,
        private val openContactAction: OpenContactAction,
        private val openDialerAction: OpenDialerAction,
        private val openSmsAppAction: OpenSmsAction,
        private val openFileAction: OpenFileAction,
        private val openUrlAction: OpenUrlAction,
        private val openEmailAction: OpenEmailAction,
        private val searchAction: SearchAction
) {

    fun perform(context: Context, result: AutoCompleteResultViewModel) {
        when (result) {
            is AutoCompleteResultViewModel.App -> openAppAction.perform(context, result.packageName)
            is AutoCompleteResultViewModel.PhoneNumber -> {
                if (result.callAction) {
                    openDialerAction.perform(context, result.phoneNumber)
                } else {
                    openSmsAppAction.perform(context, result.phoneNumber)
                }
            }
            is AutoCompleteResultViewModel.File -> openFileAction.perform(context, result.location)
            is AutoCompleteResultViewModel.WebAddress -> openUrlAction.perform(context, result.url)
            is AutoCompleteResultViewModel.Email -> openEmailAction.perform(context, result.email)
            is AutoCompleteResultViewModel.Contact -> openContactAction.perform(context, result.id)
            else -> searchAction.perform(context, result.title)
        }
    }
}