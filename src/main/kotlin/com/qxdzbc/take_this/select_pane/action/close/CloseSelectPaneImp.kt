package com.qxdzbc.take_this.select_pane.action.close

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.qxdzbc.common.compose.Ms
import com.qxdzbc.take_this.di.SelectPaneStateMs
import com.qxdzbc.take_this.select_pane.SelectPaneState
import javax.inject.Inject

class CloseSelectPaneImp @Inject constructor(
    @SelectPaneStateMs private val selectPaneStateMs:Ms<SelectPaneState>
) : CloseSelectPane {
    private var selectPane by selectPaneStateMs
    override fun closeSelectPane() {
        selectPane = selectPane.close()
    }
}
