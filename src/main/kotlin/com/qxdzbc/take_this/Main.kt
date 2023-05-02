package com.qxdzbc.take_this

import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.window.Tray
import androidx.compose.ui.window.application
import com.qxdzbc.take_this.di.DaggerTTComponent
import com.qxdzbc.take_this.image_window.ImageWindow
import com.qxdzbc.take_this.select_pane.SelectPane
import com.qxdzbc.take_this.select_pane.SelectPaneDisapperedFlagView
import kotlinx.coroutines.launch

fun main() {
    val comp = DaggerTTComponent.builder().build()
    application {
        val cs = rememberCoroutineScope()
        val appState by remember{ comp.appStateMs()}
        val selectPaneAction = comp.selectPanelAction()
        val trayIcon = painterResource("icon_neon.png")
        for (image in appState.imageList) {
            ImageWindow(
                state = image.value,
                action = comp.imageWindowAction()
            )
        }

        SelectPane(
            state = appState.selectorPaneMs.value,
            action = selectPaneAction,
            coroutineScope = cs
        )

        val density = LocalDensity.current
        if(!appState.selectorPaneMs.value.isOpened){
            SelectPaneDisapperedFlagView {
                cs.launch {
                    selectPaneAction.takeScreenshot(density)
                }
            }
        }

        Tray(
            icon = trayIcon,
            tooltip = "takeThis app",
            onAction = { },
            menu = {
                Item("take screen shot", onClick = {
                    selectPaneAction.openSelectPane()
                })
                Item("Exit", onClick = ::exitApplication)
            },
        )
    }
}
