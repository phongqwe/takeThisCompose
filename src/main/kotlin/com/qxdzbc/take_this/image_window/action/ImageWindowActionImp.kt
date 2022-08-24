package com.qxdzbc.take_this.image_window.action

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.qxdzbc.common.compose.Ms
import com.qxdzbc.take_this.app.AppState
import com.qxdzbc.take_this.app.action.close_image.CloseImage
import com.qxdzbc.take_this.di.AppStateMs
import com.qxdzbc.take_this.image_window.action.copy_image.CopyImageToClipboard
import com.qxdzbc.take_this.image_window.action.pin_image.PinImage
import com.qxdzbc.take_this.image_window.action.set_drag.SetDrag
import javax.inject.Inject

class ImageWindowActionImp @Inject constructor(
    val closeImage: CloseImage,
    val setDrag:SetDrag,
    val cp: CopyImageToClipboard,
    val pinImage: PinImage,
    @AppStateMs val appStateMs:Ms<AppState>,
) : ImageWindowAction, CloseImage by closeImage, SetDrag by setDrag, CopyImageToClipboard by cp, PinImage by pinImage {
    private var appState by appStateMs
    override fun showButton(id: String) {
        appState.getImage(id)?.also {
            it.value = it.value.showButton()
        }
    }

    override fun hideButton(id: String) {
        appState.getImage(id)?.also {
            it.value = it.value.hideButton()
        }
    }
}
