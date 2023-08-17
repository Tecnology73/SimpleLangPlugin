package com.example.sampleplugin.psi.impl

import com.example.sampleplugin.psi.SimpleFunction
import com.example.sampleplugin.psi.SimpleFunctionId
import com.example.sampleplugin.psi.SimpleTypes
import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement

open class SimpleFunctionImpl(node: ASTNode) : ASTWrapperPsiElement(node), SimpleFunction {
    override fun getNameIdentifier(): SimpleFunctionId {
        return findChildByType(SimpleTypes.FUNCTION_ID)!!
    }

    override fun getName(): String {
        return getNameIdentifier().text
    }
}