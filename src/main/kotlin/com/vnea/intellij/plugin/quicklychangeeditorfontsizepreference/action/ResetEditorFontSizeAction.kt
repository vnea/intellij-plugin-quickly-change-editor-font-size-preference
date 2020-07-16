package com.vnea.intellij.plugin.quicklychangeeditorfontsizepreference.action

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.vnea.intellij.plugin.quicklychangeeditorfontsizepreference.wrapper.AppEditorFontPreferences


class ResetEditorFontSizeAction : AnAction() {

    private val appEditorFontPreferences = AppEditorFontPreferences()

    companion object {
        private const val DEFAULT_FONT_SIZE = 18
    }

    override fun actionPerformed(event: AnActionEvent) {
        appEditorFontPreferences.setFontSize(DEFAULT_FONT_SIZE)
    }

}
