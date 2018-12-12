package com.chrynan.androidsearch.resource

import com.chrynan.androidsearch.R
import com.chrynan.androidsearch.di.scope.LayoutScope
import com.chrynan.androidsearch.util.AppContext
import javax.inject.Inject

@LayoutScope
class SearchSettingsResources @Inject constructor(appContext: AppContext) : ResourceProvider(appContext) {

    val appsTitleText by string(R.string.settings_toggle_title_apps)
    val audioFilesTitleText by string(R.string.settings_toggle_title_audio_files)
    val imageFilesTitleText by string(R.string.settings_toggle_title_image_files)
    val videoFilesTitleText by string(R.string.settings_toggle_title_video_files)
    val contactsTitleText by string(R.string.settings_toggle_title_contacts)
    val calendarEventsTitleText by string(R.string.settings_toggle_title_calendar_events)
    val textMessagesTitleText by string(R.string.settings_toggle_title_text_messages)
    val emailAddressTitleText by string(R.string.settings_toggle_title_email_links)
    val webAddressTitleText by string(R.string.settings_toggle_title_url_links)
    val phoneNumberTitleText by string(R.string.settings_toggle_title_phone_numbers)
    val suggestionsTitleText by string(R.string.settings_toggle_title_suggestions)
    val searchHistory by string(R.string.auto_complete_description_title_search_history)
    val searchApproach by string(R.string.settings_search_approach_cell_title)
}