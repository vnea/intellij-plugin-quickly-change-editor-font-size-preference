package com.vnea.intellij.plugin.quicklychangeeditorfontsizepreference.action

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.components.ServiceManager
import com.vnea.intellij.plugin.quicklychangeeditorfontsizepreference.service.QuicklyChangeEditorFontSizePreferenceService
import com.vnea.intellij.plugin.quicklychangeeditorfontsizepreference.wrapper.AppEditorFontPreferences


class ResetEditorFontSizeAction : AnAction() {

    private val appEditorFontPreferences = AppEditorFontPreferences()
    private val pluginService = ServiceManager.getService(QuicklyChangeEditorFontSizePreferenceService::class.java)

    override fun actionPerformed(event: AnActionEvent) {
        appEditorFontPreferences.setFontSize(pluginService.defaultFontSizeEditor)
    }

}
