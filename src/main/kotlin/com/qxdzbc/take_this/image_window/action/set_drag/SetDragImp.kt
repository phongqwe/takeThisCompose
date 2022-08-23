package com.qxdzbc.take_this.image_window.action.set_drag

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.qxdzbc.common.compose.Ms
import com.qxdzbc.take_this.app.AppState
import com.qxdzbc.take_this.di.AppStateMs
import javax.inject.Inject

class SetDragImp @Inject constructor(
    @AppStateMs private val appStateMs:Ms<AppState>
) : SetDrag {
    private var appState by appStateMs
    override fun setDragged(id: String, i: Boolean) {
        appState.getImage(id)?.also { ims->
            ims.value = ims.value.setWasDragged(i)
        }
    }
}
