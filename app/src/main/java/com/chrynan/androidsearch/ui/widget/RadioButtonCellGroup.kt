@file:Suppress("unused")

package com.chrynan.androidsearch.ui.widget

import com.chrynan.androidviews.builder.LayoutBuilder
import com.chrynan.androidviewutils.setVisibleOrGone

class RadioButtonCellGroup<K : Any>(private val radioButtonCells: Map<K, RadioButtonCell?>) {

    init {
        radioButtonCells.entries.forEach { entry ->
            entry.value?.checkedListener = { checked ->
                // Always consider the item as toggled on because we remove the listener when toggling
                // off the other items and we don't allow toggling off an item (only toggling on another
                // item which turns off the others).
                toggleOnKeyAndOffOtherKeys(entry.key)
                groupCheckedListener?.invoke(entry.key)
            }
        }
    }

    var groupCheckedListener: ((checkedKey: K) -> Unit)? = null

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

    private fun toggleOnKeyAndOffOtherKeys(checkedKey: K) {
        radioButtonCells.entries.forEach { pair ->
            pair.value?.setIsCheckedWithoutTriggeringListener(pair.key == checkedKey)
        }
    }

    private fun RadioButtonCell.setIsCheckedWithoutTriggeringListener(checked: Boolean) {
        val listener = checkedListener
        checkedListener = null
        isChecked = checked
        checkedListener = listener
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