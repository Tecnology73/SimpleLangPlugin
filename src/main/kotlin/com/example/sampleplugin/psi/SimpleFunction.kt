package com.example.sampleplugin.psi

import com.intellij.psi.PsiElement

interface SimpleFunction : PsiElement {
    fun getNameIdentifier(): PsiElement?

    fun getName(): String
}