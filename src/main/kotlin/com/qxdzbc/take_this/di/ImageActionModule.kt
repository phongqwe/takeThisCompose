package com.qxdzbc.take_this.di

import com.qxdzbc.take_this.image_window.action.*
import com.qxdzbc.take_this.image_window.action.copy_image.CopyImageToClipboard
import com.qxdzbc.take_this.image_window.action.copy_image.CopyImageToClipboardImp
import com.qxdzbc.take_this.image_window.action.pin_image.PinImage
import com.qxdzbc.take_this.image_window.action.pin_image.PinImageImp
import com.qxdzbc.take_this.image_window.action.set_drag.SetDrag
import com.qxdzbc.take_this.image_window.action.set_drag.SetDragImp
import dagger.Binds

@dagger.Module
interface ImageActionModule {
    @Binds
    @TTSingleton
    fun CopyImageToClipboard(i: CopyImageToClipboardImp): CopyImageToClipboard

    @Binds
    @TTSingleton
    fun imageWindowAction(i: ImageWindowActionImp): ImageWindowAction

    @Binds
    @TTSingleton
    fun SetDrag(i: SetDragImp): SetDrag

    @Binds
    @TTSingleton
    fun PinImage(i: PinImageImp): PinImage
}
