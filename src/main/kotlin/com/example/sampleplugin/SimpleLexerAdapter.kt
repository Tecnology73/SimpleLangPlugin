package com.example.sampleplugin

import com.intellij.lexer.FlexAdapter

class SimpleLexerAdapter : FlexAdapter(SimpleLexer(null)) {
}