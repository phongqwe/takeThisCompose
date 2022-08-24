package com.qxdzbc.take_this.image_window.action.pin_image

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.qxdzbc.common.compose.Ms
import com.qxdzbc.take_this.app.AppState
import com.qxdzbc.take_this.di.AppStateMs
import javax.inject.Inject

class PinImageImp @Inject constructor(
    @AppStateMs val appStateMs:Ms<AppState>,
) : PinImage {
    private var appState by appStateMs
    override fun pinImage(id: String) {
        appState.getImage(id)?.also {
            it.value = it.value.pin()
        }
    }

    override fun unpinImage(id: String) {
        appState.getImage(id)?.also {
            it.value = it.value.unPin()
        }
    }

    override fun switchPin(id: String) {
        appState.getImage(id)?.also {
            it.value = it.value.switchPin()
        }
    }
}
