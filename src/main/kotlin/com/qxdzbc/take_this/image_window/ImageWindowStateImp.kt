package com.qxdzbc.take_this.image_window

import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import java.awt.Toolkit

data class ImageWindowStateImp(
    override val id: String,
    override val image: ImageBitmap,
    override val pinnedOnTop: Boolean = true,
    override val allowCloseAfterClick: Boolean = false,
    override val prevPosition: Offset = Offset(0F, 0F),
    override val currentPosition: Offset = Offset(0F, 0F),
    override val isButtonVisible: Boolean = false,
) : ImageWindowState {
    override fun currentPosition(density: Density): Offset {
        return Offset(
            x=currentPosition.x/density.density,
            y=currentPosition.y/density.density,
        )
    }

    override fun dpSize(density: Density): DpSize {
        // TODO currently not use density for size
//        val width = image.width / density.density
//        val height = image.height / density.density
        val width = image.width
        val height = image.height
        return DpSize(
            width = width.dp,
            height = height.dp
        )
    }

    override fun showButton(): ImageWindowState {
        return this.copy(isButtonVisible = true)
    }

    override fun hideButton(): ImageWindowState {
        return this.copy(isButtonVisible = false)
    }

    override fun pin(): ImageWindowState {
        return this.copy(pinnedOnTop = true)
    }

    override fun unPin(): ImageWindowState {
        return this.copy(pinnedOnTop = false)
    }

    override fun switchPin(): ImageWindowState {
        return this.copy(pinnedOnTop = !pinnedOnTop)
    }

    override fun setPrevPosition(i: Offset): ImageWindowState {
        return this.copy(prevPosition = i)
    }

    override fun setCurrentPosition(i: Offset): ImageWindowState {
        return this.copy(currentPosition = i)
    }

    override fun setWasDragged(i: Boolean): ImageWindowState {
        return this.copy(allowCloseAfterClick = i)
    }
}
