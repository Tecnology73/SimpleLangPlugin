package org.intellij.sdk.language

import com.example.sampleplugin.completion.DeclarationProcessor
import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.openapi.util.TextRange
import com.intellij.psi.*
import com.intellij.psi.util.PsiTreeUtil
import org.intellij.sdk.language.psi.*

class SimpleReference(element: PsiElement, textRange: TextRange?) : PsiReferenceBase<PsiElement?>(element, textRange), PsiPolyVariantReference {
    override fun multiResolve(incompleteCode: Boolean): Array<ResolveResult> {
        val results = mutableListOf<ResolveResult>()
        val processor = DeclarationProcessor(element)

        PsiTreeUtil.treeWalkUp(processor, element, element.containingFile, ResolveState.initial())

        if (processor.resolved != null) {
            results.add(processor.resolved!!)

            return results.toTypedArray()
        }

        return results.toTypedArray()
    }

    override fun resolve(): PsiElement? {
        val results = multiResolve(false)
        return if (results.size == 1) results[0].element else null
    }

    override fun getVariants(): Array<Any> {
        val project = myElement!!.project
        val objects = SimpleUtil.findDeclarations(project, SimpleTypeDeclaration::class.java)
        val variants = mutableListOf<LookupElement>()

        for (property in objects) {
            if (property.typeName.text.isNotEmpty()) {
                variants.add(
                        LookupElementBuilder
                                .create(property)
                                .withIcon(SimpleIcons.FILE)
                                .withTypeText(property.containingFile.name)
                )
            }
        }

        return variants.toTypedArray()
    }
}