package com.example.sampleplugin

import com.intellij.openapi.util.IconLoader

class Icons {
    companion object {
        @JvmField
        val LogoLight = IconLoader.getIcon("/icons/jar-gray.png", ::Icons.javaClass)
    }
}