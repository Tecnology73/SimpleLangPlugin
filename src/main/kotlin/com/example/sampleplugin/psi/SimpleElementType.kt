package com.example.sampleplugin.psi

import com.example.sampleplugin.SimpleLanguage
import com.intellij.psi.tree.IElementType
import org.jetbrains.annotations.NonNls

class SimpleElementType(debugName: @NonNls String) : IElementType(debugName, SimpleLanguage.INSTANCE)
