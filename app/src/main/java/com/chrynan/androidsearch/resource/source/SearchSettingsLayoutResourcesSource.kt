package com.chrynan.androidsearch.resource.source

import com.chrynan.androidsearch.R
import com.chrynan.androidsearch.di.scope.ActivityScope
import com.chrynan.androidsearch.resource.ResourceProvider
import com.chrynan.androidsearch.resource.SearchSettingsLayoutResources
import com.chrynan.androidsearch.util.AppContext
import javax.inject.Inject

@ActivityScope
class SearchSettingsLayoutResourcesSource @Inject constructor(appContext: AppContext) : ResourceProvider(appContext),
        SearchSettingsLayoutResources {

    override val appsTitleText by string(R.string.settings_toggle_title_apps)
    override val audioFilesTitleText by string(R.string.settings_toggle_title_audio_files)
    override val imageFilesTitleText by string(R.string.settings_toggle_title_image_files)
    override val videoFilesTitleText by string(R.string.settings_toggle_title_video_files)
    override val contactsTitleText by string(R.string.settings_toggle_title_contacts)
    override val calendarEventsTitleText by string(R.string.settings_toggle_title_calendar_events)
    override val textMessagesTitleText by string(R.string.settings_toggle_title_text_messages)
    override val emailAddressTitleText by string(R.string.settings_toggle_title_email_links)
    override val webAddressTitleText by string(R.string.settings_toggle_title_url_links)
    override val phoneNumberTitleText by string(R.string.settings_toggle_title_phone_numbers)
    override val suggestionsTitleText by string(R.string.settings_toggle_title_suggestions)
    override val searchHistory by string(R.string.auto_complete_description_title_search_history)
    override val searchApproach by string(R.string.settings_search_approach_cell_title)
}