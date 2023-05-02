package com.qxdzbc.take_this.select_pane

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect

/**
 * This is an empty view. It is only showed if the SelectPane has disappeared, and acts as a signal, so that a screenshot can be taken safely.
 */
@Composable
fun SelectPaneDisapperedFlagView(
    onShow:()->Unit,
) {
    LaunchedEffect(Unit){
        onShow()
    }
}