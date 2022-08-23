package com.qxdzbc.take_this.select_pane

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawOutline
import androidx.compose.ui.graphics.drawscope.DrawStyle
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.key.*
import androidx.compose.ui.input.pointer.PointerEventType
import androidx.compose.ui.input.pointer.isPrimaryPressed
import androidx.compose.ui.input.pointer.onPointerEvent
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPlacement
import androidx.compose.ui.window.rememberWindowState
import com.qxdzbc.common.compose.view.MBox
import com.qxdzbc.take_this.select_pane.action.SelectPaneAction
import com.qxdzbc.take_this.select_rect.SelectRect
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SelectPane(
    state: SelectPaneState,
    action: SelectPaneAction,
    coroutineScope: CoroutineScope
) {
    val fq = remember { FocusRequester() }
    if (state.isOpened) {
        val l = state.layout
        val wState = rememberWindowState(
            placement = WindowPlacement.Maximized,
        )
        Window(
            onCloseRequest = {
                action.closeSelectPane()
            },
            state = wState,
            alwaysOnTop = true,
            undecorated = true,
            transparent = true
        ) {
            MBox(
                modifier = Modifier
                    .focusRequester(fq)
                    .focusable()
                    .onGloballyPositioned {
                        action.updateSelectPaneLayoutCoor(it)
                        println("q")
                    }
                    .fillMaxSize()
                    .background(Color(0xB6B6B6).copy(alpha = 0.5F))
                    .onPointerEvent(PointerEventType.Press) {
                        if (l != null && l.isAttached()) {
                            val mousePos = l.localToWindow(it.changes.first().position)
                            action.startMouseDrag(mousePos)
                        }
                    }
                    .onPointerEvent(PointerEventType.Move) {
                        if (it.buttons.isPrimaryPressed) {
                            if (l != null && l.isAttached()) {
                                val mousePos = l.localToWindow(it.changes.first().position)
                                action.moveMouseWhileDrag(mousePos)
                            }
                        }
                    }
                    .onPointerEvent(PointerEventType.Release) {
                        action.stopMouseDrag()
                        action.closeSelectPane()
                        coroutineScope.launch(Dispatchers.Main) {
                            action.takeScreenshot()
                        }
                    }.onPreviewKeyEvent {
                        if (it.type == KeyEventType.KeyDown) {
                            when (it.key) {
                                Key.Escape -> {
                                    action.closeSelectPane()
                                    true
                                }
                                else -> {
                                    false
                                }
                            }
                        } else {
                            false
                        }
                    }
            ) {
                val rectState = state.selectRect
                if (state.selectRect.isActive)
                    if (rectState.isActive && rectState.isShow) {
                        val position = if (l != null && l.isAttached()) {
                            l.localToWindow(state.selectRect.rect.topLeft)
                        } else {
                            state.selectRect.rect.topLeft
                        }
                        Canvas(modifier = Modifier.fillMaxSize()) {
                            drawRect(
                                color = Color.Blue,
                                topLeft = position,
                                alpha = 0.5F,
                                size = state.selectRect.rect.size,
                            )
                        }
                    }
            }
        }
        SideEffect {
            if (state.isFocus) {
                fq.requestFocus()
            }
        }
    }
}


fun main() {
//    val p6Comp = DaggerTTComponent.builder().build()
//    application {
//        val action: SelectPaneAction = p6Comp.selectPanelAction()
//        val selectPanel by p6Comp.appStateMs().value.selectorPaneMs
//        SelectPane(
//            state = selectPanel,
//            action = action
//        )
//    }
}
