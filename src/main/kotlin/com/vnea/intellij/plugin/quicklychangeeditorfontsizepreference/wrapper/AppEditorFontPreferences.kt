package com.vnea.intellij.plugin.quicklychangeeditorfontsizepreference.wrapper

import com.intellij.application.options.EditorFontsConstants
import com.intellij.openapi.editor.EditorFactory
import com.intellij.openapi.editor.colors.impl.AppEditorFontOptions
import com.intellij.openapi.editor.colors.impl.FontPreferencesImpl

class AppEditorFontPreferences {

    private val fontPreferences = AppEditorFontOptions.getInstance().fontPreferences as FontPreferencesImpl

    companion object {
        val DEFAULT_FONT_SIZE = EditorFontsConstants.getDefaultEditorFontSize()
        val MIN_FONT_SIZE = EditorFontsConstants.getMinEditorFontSize()
        val MAX_FONT_SIZE = EditorFontsConstants.getMaxEditorFontSize()
    }

    fun setFontSize(fontSize: Int) {
        if (isEditorFontSizeAllowed(fontSize)) {
            fontPreferences.setFontSize(fontPreferences.fontFamily, fontSize)
            EditorFactory.getInstance().refreshAllEditors()
        }
    }

    fun updateCurrentFontSizeBy(updateFontSizeBy: Int) {
        val currentFontSize = fontPreferences.getSize(fontPreferences.fontFamily)
        val newFontSize = currentFontSize + updateFontSizeBy

        setFontSize(newFontSize)
    }

    fun isEditorFontSizeAllowed(fontSize: Int) = fontSize in MIN_FONT_SIZE..MAX_FONT_SIZE

}
