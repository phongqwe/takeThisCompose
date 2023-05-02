package com.qxdzbc.take_this.select_pane.action.take_screenshot

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.toComposeImageBitmap
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Density
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
    override fun takeScreenshot(rect: Rect, density: Density): ImageWindowState? {
        if (rect.width <= 0 || rect.height <= 0) {
            return null
        } else {
            // this topleft can be used in compose function, but can it be used with awt rectange?
            val topLeft: Offset = rect.topLeft
            val x = (topLeft.x/density.density).toInt()
            val y = (topLeft.y/density.density).toInt()
            val width = (rect.width/density.density).toInt()
            val height = (rect.height/density.density).toInt()
            val bImage: BufferedImage = robot.createScreenCapture(
                Rectangle(
                    // image position is wrong
                    x,y, width,height
                )
            )
            val img:ImageBitmap = Image.makeFromBitmap(bImage.toBitmap()).toComposeImageBitmap()
            return ImageWindowStateImp(
                id = UUID.randomUUID().toString(),
                image = img,
                pinnedOnTop = true,
                allowCloseAfterClick = false,
                currentPosition = topLeft,
                prevPosition = topLeft,
            )
        }
    }

    override suspend fun takeScreenshot(density: Density) {
//        delay(200)
        val rect = selectRectMs.value.rect
        val newImage: ImageWindowState? = this.takeScreenshot(rect,density)
        if (newImage != null) {
            addImage.addImage(newImage)
        }
    }
}
