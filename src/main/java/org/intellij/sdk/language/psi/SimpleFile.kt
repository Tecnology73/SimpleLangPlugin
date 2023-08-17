package org.intellij.sdk.language.psi

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.ResolveState
import com.intellij.psi.scope.PsiScopeProcessor
import com.intellij.psi.util.PsiTreeUtil
import org.intellij.sdk.language.SimpleFileType
import org.intellij.sdk.language.SimpleLanguage

class SimpleFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, SimpleLanguage.INSTANCE) {
    override fun getFileType(): FileType {
        return SimpleFileType.INSTANCE
    }

    override fun toString(): String {
        return "Simple File"
    }

    override fun processDeclarations(processor: PsiScopeProcessor, state: ResolveState, lastParent: PsiElement?, place: PsiElement): Boolean {
        PsiTreeUtil.findChildrenOfType(this, SimpleTopLevelDeclaration::class.java).forEach {
            if (it.typeDeclaration != null) {
                if (!processor.execute(it.typeDeclaration!!, state)) {
                    return false
                }
            }

            if (it.function != null) {
                if (!processor.execute(it.function!!, state)) {
                    return false
                }
            }
        }

        return true
    }
}
