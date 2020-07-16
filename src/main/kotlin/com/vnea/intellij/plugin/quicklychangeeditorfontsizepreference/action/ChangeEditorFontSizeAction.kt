package com.vnea.intellij.plugin.quicklychangeeditorfontsizepreference.action

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.vnea.intellij.plugin.quicklychangeeditorfontsizepreference.wrapper.AppEditorFontPreferences


abstract class ChangeEditorFontSizeAction(private val updateFontSizeBy: Int) : AnAction() {

    private val appEditorFontPreferences = AppEditorFontPreferences()

    override fun actionPerformed(event: AnActionEvent) {
        appEditorFontPreferences.updateCurrentFontSizeBy(updateFontSizeBy)
    }

}
