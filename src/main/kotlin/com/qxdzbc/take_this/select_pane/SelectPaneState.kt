package com.qxdzbc.take_this.select_pane

import androidx.compose.ui.layout.LayoutCoordinates
import com.qxdzbc.common.compose.layout_coor_wrapper.LayoutCoorWrapper
import com.qxdzbc.take_this.select_rect.SelectRectState

interface SelectPaneState {
    val isFocus: Boolean
    val isOpened: Boolean
    fun open(): SelectPaneState
    fun close(): SelectPaneState

    val layout:LayoutCoorWrapper?
    fun setLayoutCoor(layout:LayoutCoordinates?):SelectPaneState

    val selectRect:SelectRectState
}

