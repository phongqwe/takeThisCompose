package com.qxdzbc.take_this.image_window.action.copy_image

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.toAwtImage
import com.qxdzbc.common.compose.Ms
import com.qxdzbc.common.copiers.image_copier.ImageCopier
import com.qxdzbc.take_this.app.AppState
import com.qxdzbc.take_this.di.AppStateMs
import javax.inject.Inject

class CopyImageToClipboardImp @Inject constructor(
    @AppStateMs val appStateMs:Ms<AppState>,
    val copier: ImageCopier,
) : CopyImageToClipboard {
    private var appState by appStateMs
    override fun copyImageToClipboard(id: String) {
        appState.getImage(id)?.also {
            copier.copy(it.value.image.toAwtImage())
        }
    }
}
