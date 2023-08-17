package com.example.sampleplugin.psi

import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner

interface SimpleNamedElement : PsiNameIdentifierOwner {
    override fun getNameIdentifier(): PsiElement?
}