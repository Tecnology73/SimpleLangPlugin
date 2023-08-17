package com.example.sampleplugin

import com.intellij.lang.Language

class SimpleLanguage : Language("Simple") {
    companion object {
        @JvmField
        val INSTANCE = SimpleLanguage()
    }
}