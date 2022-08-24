package com.qxdzbc.take_this.image_window

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.pointer.PointerEventType
import androidx.compose.ui.input.pointer.onPointerEvent
import androidx.compose.ui.unit.dp
import com.qxdzbc.common.compose.PointerEventUtils.consumeAllChanges
import com.qxdzbc.common.compose.view.MBox

@Composable
fun IconButton(
    onClick:()->Unit,
    iconImageVector: ImageVector,
    tint:Color = Color.Black,
    background:Color = Color.White,
    description:String = ""
) {
    MBox(
        modifier = Modifier
            .border(width = 1.dp, color = Color.Black)
            .background(background)
            .clickable{onClick()}
    ) {
        Icon(
            imageVector = iconImageVector,
            contentDescription = description,
            modifier = Modifier.align(Alignment.Center).padding(1.dp),
            tint = tint
        )
    }
}
