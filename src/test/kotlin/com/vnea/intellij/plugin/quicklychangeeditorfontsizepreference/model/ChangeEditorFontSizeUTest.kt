package com.vnea.intellij.plugin.quicklychangeeditorfontsizepreference.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class ChangeEditorFontSizeUTest {

    @Test
    fun `fontSize SHOULD return given font size`() {
        // Given
        val changeEditorFontSize = ChangeEditorFontSize(10)

        // When
        val fontSizeReturned = changeEditorFontSize.fontSize

        // Then
        assertEquals(10, fontSizeReturned)
    }
}
