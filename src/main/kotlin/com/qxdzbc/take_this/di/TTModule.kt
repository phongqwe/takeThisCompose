package com.qxdzbc.take_this.di

import com.qxdzbc.common.compose.Ms
import com.qxdzbc.common.compose.StateUtils.ms
import com.qxdzbc.common.compose.StateUtils.toMs
import com.qxdzbc.common.copiers.image_copier.ImageCopier
import com.qxdzbc.common.copiers.image_copier.ImageCopierImp
import com.qxdzbc.take_this.app.AppState
import com.qxdzbc.take_this.app.AppStateImp
import com.qxdzbc.take_this.image_window.ImageWindowState
import com.qxdzbc.take_this.select_pane.SelectPaneState
import com.qxdzbc.take_this.select_pane.SelectPaneStateImp
import com.qxdzbc.take_this.select_rect.SelectRectState
import com.qxdzbc.take_this.select_rect.SelectRectStateImp
import dagger.Binds
import dagger.Provides
import java.awt.Robot

@dagger.Module
interface TTModule {

    @Binds
    fun appState(a:AppStateImp):AppState

    companion object {
        @Provides
        @TTSingleton
        @AppStateMs
        fun AppStateMs(a:AppState):Ms<AppState>{
            return a.toMs()
        }

        @Provides
        @EmptyImageMap
        fun EmptyImageMap(): Map<String, Ms<ImageWindowState>> {
            return emptyMap()
        }

        @Provides
        @TTSingleton
        @SelectRectStateMs
        fun SelectRectStateMs(): Ms<SelectRectState> {
            return SelectRectStateImp().toMs()
        }

        @Provides
        @TTSingleton
        @SelectPaneStateMs
        fun SelectorPaneStateMs(
            @SelectRectStateMs rectMs:Ms<SelectRectState>
        ): Ms<SelectPaneState> {
            return SelectPaneStateImp(
                isOpened = false,
                layoutMs= ms(null),
                selectRectMs = rectMs
            ).toMs()
        }

        @Provides
        @TTSingleton
        fun robot():Robot{
            return Robot()
        }

        @Provides
        @TTSingleton
        fun ImageCopier(): ImageCopier {
            return ImageCopierImp()
        }

    }
}
