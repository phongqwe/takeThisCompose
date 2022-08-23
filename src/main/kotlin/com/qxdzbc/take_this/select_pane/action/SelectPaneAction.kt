package com.qxdzbc.take_this.select_pane.action

import com.qxdzbc.take_this.select_pane.action.close.CloseSelectPane
import com.qxdzbc.take_this.select_pane.action.mouse_drag.MouseDragAction
import com.qxdzbc.take_this.select_pane.action.open.OpenSelectPane
import com.qxdzbc.take_this.select_pane.action.take_screenshot.TakeScreenshot
import com.qxdzbc.take_this.select_pane.action.update_layout_coor.UpdateSelectPaneLayoutCoor

interface SelectPaneAction : OpenSelectPane, CloseSelectPane,MouseDragAction, UpdateSelectPaneLayoutCoor,TakeScreenshot {
}

