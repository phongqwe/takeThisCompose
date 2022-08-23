package com.qxdzbc.take_this.app.action.add_image

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.qxdzbc.common.compose.Ms
import com.qxdzbc.take_this.app.AppState
import com.qxdzbc.take_this.di.AppStateMs
import com.qxdzbc.take_this.image_window.ImageWindowState
import javax.inject.Inject

class AddImageImp @Inject constructor(
    @AppStateMs val appStateMs: Ms<AppState>
) : AddImage {
    private var appState by appStateMs
    override fun addImage(newImage: ImageWindowState) {
        appState = appState.addImage(newImage)
    }
}
