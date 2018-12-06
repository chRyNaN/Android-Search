@file:Suppress("unused")

package com.chrynan.androidsearch.ui.widget

import com.chrynan.androidviews.builder.LayoutBuilder
import com.chrynan.androidviewutils.setVisibleOrGone

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
                    .forEach { it?.setVisibleOrGone(value) }
        }
}

fun <K : Any> LayoutBuilder<*, *>.radioButtonCellGroup(block: RadioButtonCellGroupBuilder<K>.() -> Unit): RadioButtonCellGroup<K> {
    val builder = RadioButtonCellGroupBuilder<K>(this)
    block(builder)
    return builder.build()
}

class RadioButtonCellGroupBuilder<K : Any>(private val layoutBuilder: LayoutBuilder<*, *>) {

    private val map = mutableMapOf<K, RadioButtonCell>()

    fun radioButtonCell(key: K, block: (RadioButtonCell.() -> Unit)? = null): RadioButtonCell {
        val cell = layoutBuilder.radioButtonCell(block)
        map[key] = cell
        return cell
    }

    fun build() = RadioButtonCellGroup(map)
}