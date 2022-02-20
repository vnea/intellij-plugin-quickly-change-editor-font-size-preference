package com.vnea.intellij.plugin.quicklychangeeditorfontsizepreference.model

import kotlin.math.max

class ChangeEditorFontSize(private val min: Int = 4, private val max: Int = 40, fontSize: Int) {
    var fontSize: Int
        private set

    init {
        if (fontSize < min) {
            this.fontSize = min
        } else if (fontSize > max) {
            this.fontSize = max
        } else {
            this.fontSize = fontSize
        }
    }

    fun decreaseFontSizeBy(decreaseFactor: Int) {
        fontSize = max(min, fontSize - decreaseFactor)
    }
}
