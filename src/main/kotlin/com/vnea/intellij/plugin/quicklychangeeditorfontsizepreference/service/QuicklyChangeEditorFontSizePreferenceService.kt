package com.vnea.intellij.plugin.quicklychangeeditorfontsizepreference.service

import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage
import com.intellij.util.xmlb.XmlSerializerUtil
import com.vnea.intellij.plugin.quicklychangeeditorfontsizepreference.wrapper.AppEditorFontPreferences

@State(
    name = "QuicklyChangeEditorFontSizePreferenceSettings",
    storages = [Storage("quicklychangeeditorfontsizepreference_settings.xml")]
)
class QuicklyChangeEditorFontSizePreferenceService(
    var defaultFontSizeEditor: Int = AppEditorFontPreferences.DEFAULT_FONT_SIZE
) : PersistentStateComponent<QuicklyChangeEditorFontSizePreferenceService> {

    override fun getState() = this

    override fun loadState(state: QuicklyChangeEditorFontSizePreferenceService) {
        XmlSerializerUtil.copyBean(state, this)
    }

}
