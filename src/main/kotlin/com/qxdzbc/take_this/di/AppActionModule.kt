package com.qxdzbc.take_this.di

import com.qxdzbc.take_this.app.action.add_image.AddImage
import com.qxdzbc.take_this.app.action.add_image.AddImageImp
import com.qxdzbc.take_this.app.action.close_image.CloseImage
import com.qxdzbc.take_this.app.action.close_image.CloseImageImp
import dagger.Binds
import dagger.Provides

@dagger.Module
interface AppActionModule {
    @Binds
    @TTSingleton
    fun AddImage(i: AddImageImp):AddImage

    @Binds
    @TTSingleton
    fun CloseImage(i: CloseImageImp): CloseImage
}
