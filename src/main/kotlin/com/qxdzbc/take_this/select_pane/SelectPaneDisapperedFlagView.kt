package com.qxdzbc.take_this.select_pane

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect

/**
 * This is an empty view
 * The showing of this view signal that select pane has disappeared
 */
@Composable
fun SelectPaneDisapperedFlagView(
    onShow:()->Unit,
) {
    LaunchedEffect(Unit){
        onShow()
    }
}