package com.vnea.intellij.plugin.quicklychangeeditorfontsizepreference.model

class ChangeEditorFontSize(min: Int = 4, max: Int = 40, fontSize: Int) {

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
}
