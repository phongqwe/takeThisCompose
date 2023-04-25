package com.qxdzbc.take_this.select_rect

import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect


interface SelectRectState {
    val isShow: Boolean
    fun show(): SelectRectState
    fun hide(): SelectRectState

    val rect: Rect
    @Composable fun rect2(): Rect

    val anchorPoint: Offset
    val movingPoint: Offset

    /**
     * active == can be resized
     */
    val isActive: Boolean
    fun setMovingPoint(point: Offset): SelectRectState
    fun setAnchorPoint(anchorPoint: Offset): SelectRectState
    fun setActiveStatus(isDown: Boolean): SelectRectState
    fun activate(): SelectRectState {
        return this.setActiveStatus(true)
    }

    fun deactivate(): SelectRectState {
        return this.setActiveStatus(false)
    }
}
