package com.qxdzbc.take_this.di

import com.qxdzbc.take_this.image_window.action.ImageWindowAction
import com.qxdzbc.take_this.image_window.action.ImageWindowActionImp
import com.qxdzbc.take_this.app.action.close_image.CloseImage
import com.qxdzbc.take_this.app.action.close_image.CloseImageImp
import com.qxdzbc.take_this.image_window.action.set_drag.SetDrag
import com.qxdzbc.take_this.image_window.action.set_drag.SetDragImp
import dagger.Binds

@dagger.Module
interface ImageActionModule {
    @Binds
    @TTSingleton
    fun imageWindowAction(i: ImageWindowActionImp): ImageWindowAction

    @Binds
    @TTSingleton
    fun SetDrag(i:SetDragImp): SetDrag
}
