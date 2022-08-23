package com.qxdzbc.take_this.image_window

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp

data class ImageWindowStateImp(
    override val id: String,
    override val painter: ImageBitmap,
    override val pinnedOnTop: Boolean,
    override val wasDragged: Boolean = false,
    override val prevPosition: Offset = Offset(0F,0F),
    override val currentPosition: Offset = Offset(0F,0F),
) : ImageWindowState {
    override val size: DpSize
        get() = DpSize(
            width = painter.width.dp,
            height = painter.height.dp
        )

    override fun pin(): ImageWindowState {
        return this.copy(pinnedOnTop = true)
    }

    override fun unPin(): ImageWindowState {
        return this.copy(pinnedOnTop = false)
    }

    override fun setPrevPosition(i: Offset): ImageWindowState {
        return this.copy(prevPosition = i)
    }

    override fun setCurrentPosition(i: Offset): ImageWindowState {
        return this.copy(currentPosition = i)
    }

    override fun setWasDragged(i: Boolean): ImageWindowState {
        return this.copy(wasDragged = i)
    }
}
