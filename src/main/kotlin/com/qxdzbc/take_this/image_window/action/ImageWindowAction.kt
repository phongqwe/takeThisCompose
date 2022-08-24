package com.qxdzbc.take_this.image_window.action

import com.qxdzbc.take_this.app.action.close_image.CloseImage
import com.qxdzbc.take_this.image_window.action.copy_image.CopyImageToClipboard
import com.qxdzbc.take_this.image_window.action.pin_image.PinImage
import com.qxdzbc.take_this.image_window.action.set_drag.SetDrag

interface ImageWindowAction : CloseImage, SetDrag, CopyImageToClipboard, PinImage {
    fun showButton(id: String)
    fun hideButton(id: String)

}
