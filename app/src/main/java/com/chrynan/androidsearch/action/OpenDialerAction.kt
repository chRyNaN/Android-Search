package com.chrynan.androidsearch.action

import android.content.Context
import android.content.Intent
import android.net.Uri
import com.chrynan.androidsearch.model.wrapper.PhoneNumber
import com.chrynan.androidsearch.util.startIntentIfItExists
import javax.inject.Inject


class OpenDialerAction @Inject constructor() : QueryResultAction<PhoneNumber> {

    override fun perform(context: Context, item: PhoneNumber): Boolean {
        val intent = Intent(Intent.ACTION_DIAL).apply {
            data = Uri.parse("tel:${item.value}")
        }

        return context.startIntentIfItExists(intent)
    }
}