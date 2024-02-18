package com.qxdzbc.take_this.app

import androidx.compose.ui.layout.LayoutCoordinates
import com.qxdzbc.common.compose.Ms
import com.qxdzbc.common.compose.StateUtils.toMs
import com.qxdzbc.take_this.di.EmptyImageMap
import com.qxdzbc.take_this.di.SelectPaneStateMs
import com.qxdzbc.take_this.di.SelectRectStateMs
import com.qxdzbc.take_this.image_window.ImageWindowState
import com.qxdzbc.take_this.select_pane.SelectPaneState
import com.qxdzbc.take_this.select_rect.SelectRectState
import javax.inject.Inject

data class AppStateImp @Inject constructor(
    @SelectPaneStateMs
    override val selectorPaneMs: Ms<SelectPaneState>,
    @SelectRectStateMs
    override val selectorRectMs: Ms<SelectRectState>,
    @EmptyImageMap override val imageMap: Map<@JvmSuppressWildcards String, @JvmSuppressWildcards Ms<ImageWindowState>>,
//    override val lcw: LayoutCoorWrapper? = null
) : AppState {

    override val imageList: List< Ms<ImageWindowState>> get()=imageMap.values.toList()
    override fun getImage(id: String): Ms<ImageWindowState>? {
        return this.imageMap[id]
    }

    override fun removeImage(imageId: String): AppState {
        return this.copy(imageMap = imageMap.filter { it.key!=imageId }
        )
    }

    override fun addImage(newImage: ImageWindowState): AppState {
        return this.copy(imageMap = imageMap +(newImage.id to newImage.toMs()) )
    }

//    override fun setLcW(i: LayoutCoordinates): AppState {
//        return this
//    }
}
