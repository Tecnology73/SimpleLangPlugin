package com.example.sampleplugin.psi.impl

import com.example.sampleplugin.psi.SimpleFunction
import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReference
import org.intellij.sdk.language.psi.SimpleMemberAccessExpr
import org.intellij.sdk.language.psi.SimpleTypes

open class SimpleMemberAccessExprImpl(node: ASTNode) : ASTWrapperPsiElement(node) {
    fun isCallExpression(): Boolean {
        return false
    }

    fun getLHS(): PsiElement? {
        return null
    }

    fun getRHS(): PsiElement? {
        return null
    }

    override fun getReference(): PsiReference? {
        return null
    }
}