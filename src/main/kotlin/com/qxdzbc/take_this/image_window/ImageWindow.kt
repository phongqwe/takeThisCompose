package com.qxdzbc.take_this.image_window

import androidx.compose.foundation.ContextMenuArea
import androidx.compose.foundation.ContextMenuItem
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.window.WindowDraggableArea
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Place
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerEventType
import androidx.compose.ui.input.pointer.isPrimaryPressed
import androidx.compose.ui.input.pointer.isSecondaryPressed
import androidx.compose.ui.input.pointer.onPointerEvent
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.rememberWindowState
import com.qxdzbc.common.compose.view.MBox
import com.qxdzbc.take_this.image_window.action.ImageWindowAction

@OptIn(ExperimentalComposeUiApi::class, ExperimentalFoundationApi::class)
@Composable
fun ImageWindow(
    state: ImageWindowState,
    action: ImageWindowAction
) {
    val density = LocalDensity.current
    val windowSize = state.dpSize(density)
    val windowPosition = state.currentPosition(density)
    val windowState = rememberWindowState(
        size = windowSize,
        position = WindowPosition(
            x = windowPosition.x.dp, y = windowPosition.y.dp,
        ),
    )

    Window(
        onCloseRequest = { action.closeImage(state.id) },
        state = windowState,
        resizable = false,
        alwaysOnTop = state.pinnedOnTop,
        undecorated = true,

        ) {
        WindowDraggableArea {
            MBox(
            ) {
                MBox {
                    ContextMenuArea(items = {
                        listOf(ContextMenuItem("Copy") {
                            action.copyImageToClipboard(state.id)
                        })
                    }) {
                        Image(
                            bitmap = state.image,
                            contentDescription = "Icon",
                            modifier = Modifier.size(windowSize).onPointerEvent(PointerEventType.Press) {
                                if (it.buttons.isSecondaryPressed) {
                                    action.setAllowCloseAfterClick(id = state.id, true)
                                }
                            }.onPointerEvent(PointerEventType.Move) {
                                if (it.buttons.isPrimaryPressed) {
                                    action.setAllowCloseAfterClick(id = state.id, true)
                                }
                            }
                                .onPointerEvent(PointerEventType.Release) {
                                    if (state.allowCloseAfterClick.not()) {
                                        action.closeImage(state.id)
                                    }
                                    action.setAllowCloseAfterClick(id = state.id, false)
                                }
                        )
                    }

                    MBox(modifier = Modifier
                        .align(Alignment.TopEnd)
                        .widthIn(min=50.dp,max=50.dp)
                        .fillMaxHeight()
                        .onPointerEvent(PointerEventType.Enter){
                            action.showButton(state.id)
                        }
                        .onPointerEvent(PointerEventType.Exit){
                            action.hideButton(state.id)
                        }
                    ) {
                        if(state.isButtonVisible){
                            Column(modifier = Modifier
                                .align(Alignment.TopEnd)) {
                                IconButton(
                                    onClick = { action.switchPin(state.id) },
                                    iconImageVector = if (state.pinnedOnTop) Icons.Filled.Place else Icons.Default.Add,
                                    description = "Pin image on top"
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
