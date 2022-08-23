package com.qxdzbc.take_this.image_window.action

import com.qxdzbc.take_this.app.action.close_image.CloseImage
import com.qxdzbc.take_this.image_window.action.set_drag.SetDrag
import javax.inject.Inject

class ImageWindowActionImp @Inject constructor(
    val closeImage: CloseImage,
    val setDrag:SetDrag
) : ImageWindowAction, CloseImage by closeImage, SetDrag by setDrag
