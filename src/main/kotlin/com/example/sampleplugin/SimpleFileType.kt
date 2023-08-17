package com.example.sampleplugin

import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon

class SimpleFileType : LanguageFileType(SimpleLanguage.INSTANCE) {
    override fun getName(): String {
        return "Simple Language"
    }

    override fun getDescription(): String {
        return "Simple Language language file"
    }

    override fun getDefaultExtension(): String {
        return "simple"
    }

    override fun getIcon(): Icon {
        return Icons.LogoLight
    }

    companion object {
        @JvmField
        val INSTANCE = SimpleFileType()
    }
}