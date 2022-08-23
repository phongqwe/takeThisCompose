package com.qxdzbc.take_this.select_pane.action.take_screenshot

import androidx.compose.ui.geometry.Rect
import com.qxdzbc.take_this.image_window.ImageWindowState

interface TakeScreenshot {
    fun takeScreenshot(rect:Rect): ImageWindowState?
    suspend fun takeScreenshot()
}
