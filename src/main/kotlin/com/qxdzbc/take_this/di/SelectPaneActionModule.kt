package com.qxdzbc.take_this.di

import com.qxdzbc.take_this.select_pane.action.SelectPaneAction
import com.qxdzbc.take_this.select_pane.action.SelectPaneActionImp
import com.qxdzbc.take_this.select_pane.action.close.CloseSelectPane
import com.qxdzbc.take_this.select_pane.action.close.CloseSelectPaneImp
import com.qxdzbc.take_this.select_pane.action.mouse_drag.MouseDragAction
import com.qxdzbc.take_this.select_pane.action.mouse_drag.MouseDragActionImp
import com.qxdzbc.take_this.select_pane.action.open.OpenSelectPane
import com.qxdzbc.take_this.select_pane.action.open.OpenSelectPaneImp
import com.qxdzbc.take_this.select_pane.action.take_screenshot.TakeScreenshot
import com.qxdzbc.take_this.select_pane.action.take_screenshot.TakeScreenshotImp
import com.qxdzbc.take_this.select_pane.action.update_layout_coor.UpdateSelectPaneLayoutCoor
import com.qxdzbc.take_this.select_pane.action.update_layout_coor.UpdateSelectPaneLayoutCoorImp
import dagger.Binds

@dagger.Module
interface SelectPaneActionModule {

    @Binds
    @TTSingleton
    fun TakeScreenshotImp(i: TakeScreenshotImp): TakeScreenshot

    @Binds
    @TTSingleton
    fun SelectPaneAction(i: SelectPaneActionImp):SelectPaneAction

    @Binds
    @TTSingleton
    fun CloseSelectPane(i: CloseSelectPaneImp): CloseSelectPane

    @Binds
    @TTSingleton
    fun OpenSelectPane(i: OpenSelectPaneImp): OpenSelectPane

    @Binds
    @TTSingleton
    fun UpdateSelectPaneLayoutCoor(i: UpdateSelectPaneLayoutCoorImp): UpdateSelectPaneLayoutCoor

    @Binds
    @TTSingleton
    fun MouseDragAction(i: MouseDragActionImp): MouseDragAction
}
