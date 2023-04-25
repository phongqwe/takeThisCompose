package com.qxdzbc.take_this.select_pane.action.mouse_drag

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.geometry.Offset
import com.qxdzbc.common.compose.Ms
import com.qxdzbc.take_this.di.SelectRectStateMs
import com.qxdzbc.take_this.select_rect.SelectRectState
import javax.inject.Inject

class MouseDragActionImp @Inject constructor(
    @SelectRectStateMs
    private val selectRectMs: Ms<SelectRectState>
) : MouseDragAction {
    private var selectRectState by selectRectMs
    override fun startMouseDrag(mousePosition: Offset) {
        selectRectState = selectRectState
            .setAnchorPoint(mousePosition)
            .setMovingPoint(mousePosition)
            .activate().show()
    }

    override fun moveMouseWhileDrag(mousePosition: Offset) {
        if(selectRectState.isActive){
            selectRectState = selectRectState.setMovingPoint(mousePosition)
        }
    }

    override fun stopMouseDrag() {
        selectRectState = selectRectState.hide().deactivate()
    }
}
