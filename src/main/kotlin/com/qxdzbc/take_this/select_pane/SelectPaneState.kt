package com.qxdzbc.take_this.select_pane

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.layout.LayoutCoordinates
import com.qxdzbc.common.compose.layout_coor_wrapper.P6Layout
import com.qxdzbc.take_this.select_rect.SelectRectState

interface SelectPaneState {
    val isFocus: Boolean
    val isOpened: Boolean
    fun open(): SelectPaneState
    fun close(): SelectPaneState

    val layout:P6Layout?
    fun setLayoutCoor(layout:LayoutCoordinates?):SelectPaneState

    val selectRect:SelectRectState
}

