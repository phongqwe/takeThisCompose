package com.qxdzbc.take_this.image_window

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.window.WindowDraggableArea
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerEventType
import androidx.compose.ui.input.pointer.isPrimaryPressed
import androidx.compose.ui.input.pointer.onPointerEvent
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import com.qxdzbc.common.compose.StateUtils.rms
import com.qxdzbc.common.compose.view.MBox
import com.qxdzbc.take_this.image_window.action.ImageWindowAction

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun ImageWindow(
    state: ImageWindowState,
    action: ImageWindowAction
) {
    val size = state.size
    val windowState = rememberWindowState(
        size = size, position = WindowPosition(
            x = state.currentPosition.x.dp, y = state.currentPosition.y.dp,
        ),
    )

    Window(
        onCloseRequest = { action.closeImage(state.id) },
        state = windowState,
        resizable = false,
//        alwaysOnTop = state.pinnedOnTop,
        alwaysOnTop = false,
        undecorated = true,

    ) {
        WindowDraggableArea {
            MBox(modifier = Modifier
                .onPointerEvent(PointerEventType.Press){

                }.onPointerEvent(PointerEventType.Move){
                    if(it.buttons.isPrimaryPressed){
                        action.setDragged(id =state.id,true)
                    }
                }
                .onPointerEvent(PointerEventType.Release) {
                    if(state.wasDragged.not()){
                        action.closeImage(state.id)
                    }
                    action.setDragged(id =state.id,false)
                }
            ) {
                Image(
                    bitmap = state.painter,
                    contentDescription = "Icon",
                    modifier = Modifier.size(size)
                )
            }
        }
    }
}


fun main() {
    application {
//        val image = painterResource("cat.jpg").
//        var state by rms(ImageWindowStateImp(
//            stateId = "123",
//            painter =image,
//            pinnedOnTop = false
//        ))
//        ImageWindow(
//            state=state,
//            action = DoNothingImageWindowAction()
//        )
    }
}
