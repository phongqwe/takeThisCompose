package com.qxdzbc.take_this.image_window.action.pin_image

interface PinImage{
    fun pinImage(id: String)
    fun unpinImage(id: String)
    fun switchPin(id:String)
}
