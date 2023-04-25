package com.qxdzbc.take_this.select_pane.action.take_screenshot

import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.unit.Density
import com.qxdzbc.take_this.image_window.ImageWindowState

interface TakeScreenshot {
    fun takeScreenshot(rect:Rect,density: Density): ImageWindowState?
    suspend fun takeScreenshot(density: Density)
}
