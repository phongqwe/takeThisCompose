package com.qxdzbc.take_this.di

import com.qxdzbc.common.compose.Ms
import com.qxdzbc.take_this.app.AppState
import com.qxdzbc.take_this.image_window.action.ImageWindowAction
import com.qxdzbc.take_this.select_pane.SelectPaneState
import com.qxdzbc.take_this.select_pane.action.SelectPaneAction
import com.qxdzbc.take_this.select_rect.SelectRectState
import dagger.Component

@TTSingleton
@Component(
    modules = [
        TTModule::class,
        ImageActionModule::class,
        SelectPaneActionModule::class,
        AppActionModule::class
    ]
)
interface TTComponent {
    @TTSingleton
    @AppStateMs
    fun appStateMs():Ms<AppState>
    @TTSingleton
    fun imageWindowAction(): ImageWindowAction
    @TTSingleton
    fun selectPanelAction(): SelectPaneAction
    @SelectRectStateMs
    @TTSingleton
    fun selectRectMs(): Ms<SelectRectState>
    @SelectPaneStateMs
    @TTSingleton
    fun selectPanelMs():Ms<SelectPaneState>
}
