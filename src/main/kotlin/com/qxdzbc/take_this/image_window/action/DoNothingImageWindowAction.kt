package com.qxdzbc.take_this.image_window.action

class DoNothingImageWindowAction : ImageWindowAction {
    override fun showButton(id: String) {
        TODO("Not yet implemented")
    }

    override fun hideButton(id: String) {
        TODO("Not yet implemented")
    }

    override fun closeImage(imageId: String) {
        println("do nothing")
    }

    override fun setAllowCloseAfterClick(id: String, i: Boolean) {
        TODO("Not yet implemented")
    }

    override fun copyImageToClipboard(id: String) {
        TODO("Not yet implemented")
    }

    override fun pinImage(id: String) {
        TODO("Not yet implemented")
    }

    override fun unpinImage(id: String) {
        TODO("Not yet implemented")
    }

    override fun switchPin(id: String) {
        TODO("Not yet implemented")
    }
}
