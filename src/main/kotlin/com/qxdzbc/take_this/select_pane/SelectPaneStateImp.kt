package com.qxdzbc.take_this.select_pane

import androidx.compose.runtime.getValue
import androidx.compose.ui.layout.LayoutCoordinates
import com.qxdzbc.common.compose.Ms
import com.qxdzbc.common.compose.layout_coor_wrapper.P6Layout
import com.qxdzbc.common.compose.layout_coor_wrapper.P6LayoutImp
import com.qxdzbc.take_this.select_rect.SelectRectState

data class SelectPaneStateImp(
    override val isOpened: Boolean = false,
    private val layoutMs:Ms<P6Layout?>,
    private val selectRectMs:Ms<SelectRectState>,
    override val isFocus: Boolean = true,
) : SelectPaneState {
    override val layout: P6Layout? by layoutMs
    override val selectRect: SelectRectState by selectRectMs

    override fun open(): SelectPaneState {
        return this.copy(isOpened=true)
    }

    override fun close(): SelectPaneState {
        return this.copy(isOpened=false)
    }

    override fun setLayoutCoor(layout: LayoutCoordinates?): SelectPaneState {
        layoutMs.value = layout?.let { P6LayoutImp(it) }
        return this
    }
}
