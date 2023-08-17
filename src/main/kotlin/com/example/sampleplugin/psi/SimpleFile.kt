package com.example.sampleplugin.psi

import com.example.sampleplugin.SimpleFileType
import com.example.sampleplugin.SimpleLanguage
import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.ResolveState
import com.intellij.psi.scope.PsiScopeProcessor
import com.intellij.psi.util.PsiTreeUtil

class SimpleFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, SimpleLanguage.INSTANCE) {
    override fun getFileType(): FileType {
        return SimpleFileType.INSTANCE
    }

    override fun toString(): String {
        return "Simple Language"
    }

    override fun processDeclarations(processor: PsiScopeProcessor, state: ResolveState, lastParent: PsiElement?, place: PsiElement): Boolean {
        PsiTreeUtil.findChildrenOfType(this, SimpleTopLevelDeclaration::class.java).forEach {
            if (it.typeDeclaration != null) {
                if (!processor.execute(it.typeDeclaration!!, state)) {
                    return false
                }
            }

            if (it.functionDeclaration != null) {
                if (!processor.execute(it.functionDeclaration!!, state)) {
                    return false
                }
            }
        }

        return true
    }
}
