package com.qxdzbc.take_this.image_window

import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.DpSize

interface ImageWindowState {
    val id:String
    val image: ImageBitmap
    fun dpSize(density: Density):DpSize

    val isButtonVisible:Boolean
    fun showButton():ImageWindowState
    fun hideButton():ImageWindowState

    val pinnedOnTop:Boolean
    fun pin():ImageWindowState
    fun unPin():ImageWindowState
    fun switchPin():ImageWindowState

    val prevPosition:Offset
    fun setPrevPosition(i:Offset):ImageWindowState

    fun currentPosition(density: Density):Offset
    val currentPosition:Offset
    fun setCurrentPosition(i:Offset):ImageWindowState

    val allowCloseAfterClick:Boolean
    fun setWasDragged(i:Boolean):ImageWindowState
}
