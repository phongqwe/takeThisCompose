package com.qxdzbc.take_this.image_window

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.unit.DpSize

interface ImageWindowState {
    val id:String
    val image: ImageBitmap
    val size:DpSize

    val isButtonVisible:Boolean
    fun showButton():ImageWindowState
    fun hideButton():ImageWindowState

    val pinnedOnTop:Boolean
    fun pin():ImageWindowState
    fun unPin():ImageWindowState
    fun switchPin():ImageWindowState

    val prevPosition:Offset
    fun setPrevPosition(i:Offset):ImageWindowState

    val currentPosition:Offset
    fun setCurrentPosition(i:Offset):ImageWindowState

    val allowCloseAfterClick:Boolean
    fun setWasDragged(i:Boolean):ImageWindowState
}
