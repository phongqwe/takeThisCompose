package com.qxdzbc.take_this.select_pane.action.mouse_drag

import androidx.compose.ui.geometry.Offset

interface MouseDragAction {
    fun startMouseDrag(mousePosition:Offset)
    fun moveMouseWhileDrag(mousePosition: Offset)
    fun stopMouseDrag()
}
