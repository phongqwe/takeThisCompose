package com.qxdzbc.take_this.app

import com.qxdzbc.common.compose.Ms
import com.qxdzbc.take_this.image_window.ImageWindowState
import com.qxdzbc.take_this.select_pane.SelectPaneState
import com.qxdzbc.take_this.select_rect.SelectRectState

interface AppState {
    val selectorPaneMs:Ms<SelectPaneState>
    val selectorRectMs:Ms<SelectRectState>
    val imageList:List<Ms<ImageWindowState>>
    val imageMap:Map<String,Ms<ImageWindowState>>
    fun getImage(id:String):Ms<ImageWindowState>?
    fun removeImage(imageId:String):AppState
    fun addImage(newImage: ImageWindowState): AppState
}
