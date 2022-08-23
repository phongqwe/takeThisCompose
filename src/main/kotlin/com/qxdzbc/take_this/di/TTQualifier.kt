package com.qxdzbc.take_this.di

import javax.inject.Qualifier
import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class TTSingleton

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class EmptyImageMap

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class SelectPaneStateMs

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class SelectRectStateMs

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class AppStateMs
