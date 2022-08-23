package com.qxdzbc.take_this

import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.window.Tray
import androidx.compose.ui.window.application
import com.qxdzbc.common.compose.Ms
import com.qxdzbc.take_this.app.AppState
import com.qxdzbc.take_this.di.DaggerTTComponent
import com.qxdzbc.take_this.image_window.ImageWindow
import com.qxdzbc.take_this.select_pane.SelectPane

fun main() {
    val comp = DaggerTTComponent.builder().build()
    application {
        val cs = rememberCoroutineScope()
        val appState by remember{ comp.appStateMs()}
        val selectPaneAction = comp.selectPanelAction()
        val trayIcon = painterResource("cat.jpg")
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

        Tray(
            icon = trayIcon,
            tooltip = "take this app",
            onAction = { },
            menu = {
                Item("Exit", onClick = ::exitApplication)
                Item("take screen shot", onClick = {
                    selectPaneAction.openSelectPane()
                })
            },
        )
    }
}
