package com.example.sampleplugin.psi

import com.example.sampleplugin.SimpleLanguage
import com.intellij.psi.tree.IElementType

class SimpleTokenType(debugName: String) : IElementType(debugName, SimpleLanguage.INSTANCE) {
    override fun toString(): String {
        return "SimpleTokenTypes." + super.toString()
    }
}