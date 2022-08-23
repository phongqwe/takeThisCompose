package com.qxdzbc.take_this.select_pane.action

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.layout.LayoutCoordinates
import com.qxdzbc.take_this.image_window.ImageWindowState

class DoNothingSelectPaneAction : SelectPaneAction {
    override fun closeSelectPane() {
        println("do nothing")
    }

    override fun startMouseDrag(mousePosition: Offset) {
        TODO("Not yet implemented")
    }

    override fun moveMouseWhileDrag(mousePosition: Offset) {
        TODO("Not yet implemented")
    }

    override fun stopMouseDrag() {
        TODO("Not yet implemented")
    }

    override fun updateSelectPaneLayoutCoor(layout: LayoutCoordinates) {
        TODO("Not yet implemented")
    }

    override fun takeScreenshot(rect: Rect): ImageWindowState? {
        TODO("Not yet implemented")
    }

    override suspend fun takeScreenshot() {
        TODO("Not yet implemented")
    }


    override fun openSelectPane() {
        println("do nothing")
    }
}
