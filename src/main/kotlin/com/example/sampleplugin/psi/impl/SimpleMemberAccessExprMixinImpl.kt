package com.example.sampleplugin.psi.impl

import com.example.sampleplugin.psi.SimpleReference
import com.example.sampleplugin.psi.SimpleTypes
import com.example.sampleplugin.psi.SimpleValueExpr
import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReference
import com.intellij.refactoring.suggested.startOffset

open class SimpleMemberAccessExprMixinImpl(node: ASTNode) : ASTWrapperPsiElement(node) {
    fun isCallExpression(): Boolean {
        return false
    }

    fun getLHS(): SimpleValueExpr? {
        return findChildByType(SimpleTypes.VALUE_EXPR)
    }

    fun getRHS(): PsiElement? {
        return findChildByType(SimpleTypes.ID)
    }

    override fun getReference(): PsiReference? {
        val id = getRHS() ?: return null
        val startOffset = id.startOffset - textRange.startOffset
        val range = TextRange(startOffset, startOffset + id.textLength)

        return SimpleReference(this, range)
    }
}