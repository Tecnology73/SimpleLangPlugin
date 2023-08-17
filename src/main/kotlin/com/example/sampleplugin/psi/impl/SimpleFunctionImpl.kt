package com.example.sampleplugin.psi.impl

import com.example.sampleplugin.psi.SimpleFunction
import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import org.intellij.sdk.language.psi.SimpleTypes

open class SimpleFunctionImpl(node: ASTNode) : ASTWrapperPsiElement(node), SimpleFunction {
    override fun getNameIdentifier(): PsiElement {
        return findChildByType(SimpleTypes.IDENTIFIER)!!
    }

    override fun getName(): String {
        return getNameIdentifier().text
    }
}