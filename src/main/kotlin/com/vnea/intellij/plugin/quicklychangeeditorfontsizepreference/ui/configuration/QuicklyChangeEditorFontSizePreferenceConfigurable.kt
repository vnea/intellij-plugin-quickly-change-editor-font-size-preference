package com.vnea.intellij.plugin.quicklychangeeditorfontsizepreference.ui.configuration

import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.options.Configurable
import com.vnea.intellij.plugin.quicklychangeeditorfontsizepreference.service.QuicklyChangeEditorFontSizePreferenceService
import com.vnea.intellij.plugin.quicklychangeeditorfontsizepreference.wrapper.AppEditorFontPreferences
import java.awt.FlowLayout
import javax.swing.JComponent
import javax.swing.JLabel
import javax.swing.JPanel
import javax.swing.JTextField

class QuicklyChangeEditorFontSizePreferenceConfigurable : Configurable {

    private val appEditorFontPreferences = AppEditorFontPreferences()
    private val pluginService =
        ApplicationManager.getApplication().getService(QuicklyChangeEditorFontSizePreferenceService::class.java)

    private val defaultFontSizeField = JTextField(pluginService.defaultFontSizeEditor)

    override fun getDisplayName() = "Quickly Change Editor Font Size Preference"

    override fun isModified() =
        isDefaultFontSizeEditorValid() && pluginService.defaultFontSizeEditor.toString() != defaultFontSizeField.text

    override fun createComponent(): JComponent? {
        val rootPanel = JPanel(FlowLayout(FlowLayout.LEFT))

        val defaultFontSizeLabel = JLabel(
            "Default font size when resetting (${AppEditorFontPreferences.MIN_FONT_SIZE} - ${AppEditorFontPreferences.MAX_FONT_SIZE}):"
        )
        rootPanel.add(defaultFontSizeLabel)

        rootPanel.add(defaultFontSizeField)

        return rootPanel
    }

    override fun apply() {
        pluginService.defaultFontSizeEditor = defaultFontSizeField.text.toInt()
    }

    override fun reset() {
        defaultFontSizeField.text = pluginService.defaultFontSizeEditor.toString()
    }

    private fun isDefaultFontSizeEditorValid(): Boolean {
        val newFontSize = defaultFontSizeField.text.toIntOrNull() ?: return false
        return appEditorFontPreferences.isEditorFontSizeAllowed(newFontSize)
    }
}
