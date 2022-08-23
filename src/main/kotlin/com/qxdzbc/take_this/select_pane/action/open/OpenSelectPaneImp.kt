package com.qxdzbc.take_this.select_pane.action.open

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.qxdzbc.common.compose.Ms
import com.qxdzbc.take_this.di.SelectPaneStateMs
import com.qxdzbc.take_this.select_pane.SelectPaneState
import javax.inject.Inject

class OpenSelectPaneImp @Inject constructor(
    @SelectPaneStateMs private val selectPaneStateMs:Ms<SelectPaneState>
) : OpenSelectPane {
    private var selectPane by selectPaneStateMs
    override fun openSelectPane() {
        selectPane = selectPane.open()
    }
}
