package com.qxdzbc.take_this.image_window

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.unit.DpSize

interface ImageWindowState {
    val id:String
    val painter: ImageBitmap
    val size:DpSize

    val pinnedOnTop:Boolean
    fun pin():ImageWindowState
    fun unPin():ImageWindowState

    val prevPosition:Offset
    fun setPrevPosition(i:Offset):ImageWindowState

    val currentPosition:Offset
    fun setCurrentPosition(i:Offset):ImageWindowState

    val wasDragged:Boolean
    fun setWasDragged(i:Boolean):ImageWindowState
}
