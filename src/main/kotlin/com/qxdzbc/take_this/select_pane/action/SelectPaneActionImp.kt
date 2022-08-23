package com.qxdzbc.take_this.select_pane.action

import com.qxdzbc.take_this.select_pane.action.close.CloseSelectPane
import com.qxdzbc.take_this.select_pane.action.mouse_drag.MouseDragAction
import com.qxdzbc.take_this.select_pane.action.open.OpenSelectPane
import com.qxdzbc.take_this.select_pane.action.take_screenshot.TakeScreenshot
import com.qxdzbc.take_this.select_pane.action.update_layout_coor.UpdateSelectPaneLayoutCoor
import javax.inject.Inject

class SelectPaneActionImp @Inject constructor(
    private val openSelectPane: OpenSelectPane,
    private val closeSelectPane: CloseSelectPane,
    private val mouseDragAction: MouseDragAction,
    private val updateSelectPaneLayout: UpdateSelectPaneLayoutCoor,
    private val takeScreenshot: TakeScreenshot,
) : SelectPaneAction, OpenSelectPane by openSelectPane, CloseSelectPane by closeSelectPane,
    MouseDragAction by mouseDragAction,
    UpdateSelectPaneLayoutCoor by updateSelectPaneLayout, TakeScreenshot by takeScreenshot {

}
