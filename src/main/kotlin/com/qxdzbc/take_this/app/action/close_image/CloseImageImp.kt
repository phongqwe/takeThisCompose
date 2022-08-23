package com.qxdzbc.take_this.app.action.close_image

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.qxdzbc.common.compose.Ms
import com.qxdzbc.take_this.app.AppState
import com.qxdzbc.take_this.di.AppStateMs
import javax.inject.Inject

class CloseImageImp @Inject constructor(
    @AppStateMs
    private val appStateMs: Ms<AppState>
) : CloseImage {
    private var appState by appStateMs
    override fun closeImage(imageId: String) {
        appState = appState.removeImage(imageId)
    }
}
