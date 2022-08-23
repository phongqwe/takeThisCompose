package com.qxdzbc.take_this.select_pane.action.update_layout_coor

import androidx.compose.ui.layout.LayoutCoordinates
import com.qxdzbc.common.compose.Ms
import com.qxdzbc.take_this.di.SelectPaneStateMs
import com.qxdzbc.take_this.select_pane.SelectPaneState
import javax.inject.Inject

class UpdateSelectPaneLayoutCoorImp @Inject constructor(
    @SelectPaneStateMs
    private val selectPaneMs:Ms<SelectPaneState>
) : UpdateSelectPaneLayoutCoor {

    override fun updateSelectPaneLayoutCoor(layout: LayoutCoordinates) {
        selectPaneMs.value = selectPaneMs.value.setLayoutCoor(layout)
    }
}
