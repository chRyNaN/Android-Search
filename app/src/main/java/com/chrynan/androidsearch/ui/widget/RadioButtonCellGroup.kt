package com.chrynan.androidsearch.ui.widget

import com.chrynan.androidsearch.util.isVisible

class RadioButtonCellGroup<K : Any>(private val radioButtonCells: Map<K, RadioButtonCell?>) {

    var groupCheckedListener: ((K, Boolean) -> Unit)? = null
        set(value) {
            field = value

            radioButtonCells.entries
                    .forEach { entry ->
                        if (value == null) {
                            entry.value?.checkedListener = null
                        } else {
                            entry.value?.checkedListener = { checked ->
                                value.invoke(entry.key, checked)

                                radioButtonCells.entries
                                        .forEach { it.value?.isChecked = it.key == entry.key }
                            }
                        }
                    }
        }

    var isEnabled: Boolean = true
        set(value) {
            field = value

            radioButtonCells.values
                    .forEach { it?.isEnabled = value }
        }

    var isVisible: Boolean = true
        set(value) {
            field = value

            radioButtonCells.values
                    .forEach { it?.isVisible = value }
        }
}