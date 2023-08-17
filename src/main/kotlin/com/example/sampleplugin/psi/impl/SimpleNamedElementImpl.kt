package com.example.sampleplugin.psi.impl

import com.example.sampleplugin.psi.SimpleNamedElement
import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReference

abstract class SimpleNamedElementImpl(node: ASTNode) : ASTWrapperPsiElement(node), SimpleNamedElement {
    override fun getNameIdentifier(): PsiElement? {
        return SimplePsiImplUtil.getNameIdentifier(this)
    }

    override fun setName(name: String): PsiElement {
        return SimplePsiImplUtil.setName(this, name)
    }

    override fun getReference(): PsiReference? {
        return SimplePsiImplUtil.getReference(this)
    }
}
