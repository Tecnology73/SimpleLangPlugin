package com.example.sampleplugin.psi.impl

import com.example.sampleplugin.psi.SimpleMemberCallExpr
import com.example.sampleplugin.psi.SimpleTypes
import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiReference

open class SimpleMemberCallExprMixinImpl(node: ASTNode) : ASTWrapperPsiElement(node) {
    fun getAccessor(): SimpleMemberAccessExprImpl? {
        return findChildByType(SimpleTypes.MEMBER_ACCESS_EXPR)
    }

    override fun getReference(): PsiReference? {
        if (this is SimpleMemberCallExpr) {
            val accessor = getAccessor()
            if (accessor != null) {
                return accessor.reference
            }
        }

        return SimplePsiImplUtil.getReference(this)
    }
}