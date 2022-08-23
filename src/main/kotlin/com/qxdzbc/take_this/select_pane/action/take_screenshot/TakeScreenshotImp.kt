package com.qxdzbc.take_this.select_pane.action.take_screenshot

import androidx.compose.runtime.getValue
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.toComposeImageBitmap
import com.qxdzbc.common.compose.Ms
import com.qxdzbc.take_this.app.AppState
import com.qxdzbc.take_this.app.action.add_image.AddImage
import com.qxdzbc.take_this.di.AppStateMs
import com.qxdzbc.take_this.di.SelectRectStateMs
import com.qxdzbc.take_this.image_window.ImageWindowState
import com.qxdzbc.take_this.image_window.ImageWindowStateImp
import com.qxdzbc.take_this.select_rect.SelectRectState
import kotlinx.coroutines.delay
import org.jetbrains.skia.Image
import org.jetbrains.skiko.toBitmap
import java.awt.Rectangle
import java.awt.Robot
import java.awt.image.BufferedImage
import java.util.*
import javax.inject.Inject

class TakeScreenshotImp @Inject constructor(
    private val robot: Robot = Robot(),
    @SelectRectStateMs
    val selectRectMs: Ms<SelectRectState>,
    val addImage: AddImage,
    @AppStateMs
    val appStateMs:Ms<AppState>
) : TakeScreenshot {
    val appState by appStateMs
    override fun takeScreenshot(rect: Rect): ImageWindowState? {
        if (rect.width <= 0 || rect.height <= 0) {
            return null
        } else {
            val tl: Offset = rect.topLeft
            val bImage: BufferedImage = robot.createScreenCapture(
                Rectangle(
                    tl.x.toInt(), tl.y.toInt(), rect.width.toInt(), rect.height.toInt()
                )
            )
            val rt = Image.makeFromBitmap(bImage.toBitmap()).toComposeImageBitmap()
            return ImageWindowStateImp(
                id = UUID.randomUUID().toString(),
                painter = rt,
                pinnedOnTop = false,
                wasDragged = false,
                currentPosition = tl,
                prevPosition = tl,
            )
        }
    }

    override suspend fun takeScreenshot() {
        delay(400)
        val rect = selectRectMs.value.rect
        val newImage: ImageWindowState? = this.takeScreenshot(rect)
        if (newImage != null) {
            addImage.addImage(newImage)
        }
    }
}
