package com.qxdzbc.take_this.image_window.action

import androidx.compose.ui.geometry.Offset
import com.qxdzbc.take_this.app.action.close_image.CloseImage
import com.qxdzbc.take_this.image_window.action.set_drag.SetDrag

interface ImageDrag{

}

interface ImageWindowAction : CloseImage,SetDrag {

}
