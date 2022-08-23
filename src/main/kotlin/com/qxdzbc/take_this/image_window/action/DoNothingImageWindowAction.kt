package com.qxdzbc.take_this.image_window.action

class DoNothingImageWindowAction : ImageWindowAction {
    override fun closeImage(imageId: String) {
        println("do nothing")
    }

    override fun setDragged(id: String, i: Boolean) {
        TODO("Not yet implemented")
    }
}
