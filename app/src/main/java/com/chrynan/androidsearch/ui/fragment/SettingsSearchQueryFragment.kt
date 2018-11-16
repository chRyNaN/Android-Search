package com.chrynan.androidsearch.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chrynan.androidsearch.R
import com.chrynan.androidsearch.presenter.SearchSettingsPresenter
import com.chrynan.androidsearch.ui.widget.RadioButtonCellGroup
import com.chrynan.androidsearch.util.isVisible
import kotlinx.android.synthetic.main.fragment_search_query_settings.*

class SettingsSearchQueryFragment : BaseFragment() {

    companion object {

        fun newInstance() = SettingsSearchQueryFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_search_query_settings, container)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val searchGroup = RadioButtonCellGroup(mapOf(
                SearchSettingsPresenter.SearchCheckedItem.APP to openSearchAppRadioButton,
                SearchSettingsPresenter.SearchCheckedItem.WEB_VIEW to openSearchWebViewRadioButton,
                SearchSettingsPresenter.SearchCheckedItem.CHROME_CUSTOM_TAB to openSearchChromeCustomTabRadioButton,
                SearchSettingsPresenter.SearchCheckedItem.BROWSER to openSearchBrowserAppRadioButton))

        val urlGroup = RadioButtonCellGroup(mapOf(
                SearchSettingsPresenter.SearchUrlCheckedItem.BING to bingUrlRadioButton,
                SearchSettingsPresenter.SearchUrlCheckedItem.CONTEXTUAL_WEB_SEARCH to contextualWebSearchUrlRadioButton,
                SearchSettingsPresenter.SearchUrlCheckedItem.DUCK_DUCK_GO to duckDuckGoUrlRadioButton,
                SearchSettingsPresenter.SearchUrlCheckedItem.GOOGLE to googleUrlRadioButton,
                SearchSettingsPresenter.SearchUrlCheckedItem.CUSTOM to customUrlRadioButton))
                .apply { isVisible = false }


        searchGroup.groupCheckedListener = { key, isChecked ->
            urlGroup.isVisible = (key != SearchSettingsPresenter.SearchCheckedItem.APP) and isChecked
            customUrlTextInputLayout?.isVisible = (key != SearchSettingsPresenter.SearchCheckedItem.APP) and
                    isChecked and
                    (customUrlRadioButton?.isChecked ?: false)

            //presenter.toggleSearchApproach(key, isChecked)
        }

        urlGroup.groupCheckedListener = { key, isChecked ->
            customUrlTextInputLayout?.isVisible = (key == SearchSettingsPresenter.SearchUrlCheckedItem.CUSTOM) and isChecked
        }
    }
}