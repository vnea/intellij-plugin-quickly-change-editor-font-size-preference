package com.vnea.intellij.plugin.quicklychangeeditorfontsizepreference.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class ChangeEditorFontSizeUTest {

    @Test
    fun `constructor SHOULD set font size`() {
        // Given
        val fontSize = 10

        // When
        val changeEditorFontSize = ChangeEditorFontSize(fontSize = fontSize)

        // Then
        assertEquals(fontSize, changeEditorFontSize.fontSize)
    }

    @Test
    fun `constructor SHOULD set font size to min WHEN given font size is inferior to min`() {
        // Given
        val min = 4
        val fontSize = 3

        // When
        val changeEditorFontSize = ChangeEditorFontSize(min = min, fontSize = fontSize)

        // Then
        assertEquals(min, changeEditorFontSize.fontSize)
    }

    @Test
    fun `constructor SHOULD set font size to max WHEN given font size is superior to max`() {
        // Given
        val max = 40
        val fontSize = 41

        // When
        val changeEditorFontSize = ChangeEditorFontSize(max = max, fontSize = fontSize)

        // Then
        assertEquals(max, changeEditorFontSize.fontSize)
    }

    @Test
    fun `decreaseFontSizeBy SHOULD decrease the font size by the decrease factor`() {
        // Given
        val decreaseFactor = 2
        val fontSize = 10
        val changeEditorFontSize = ChangeEditorFontSize(fontSize = fontSize)

        // When
        changeEditorFontSize.decreaseFontSizeBy(decreaseFactor)

        // Then
        assertEquals(8, changeEditorFontSize.fontSize)
    }

    @Test
    fun `decreaseFontSizeBy SHOULD set font size to min WHEN font size would be inferior to min`() {
        // Given
        val decreaseFactor = 2
        val min = 4
        val fontSize = 5
        val changeEditorFontSize = ChangeEditorFontSize(min = min, fontSize = fontSize)

        // When
        changeEditorFontSize.decreaseFontSizeBy(decreaseFactor)

        // Then
        assertEquals(min, changeEditorFontSize.fontSize)
    }
}
