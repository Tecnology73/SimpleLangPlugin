package com.example.sampleplugin.completion

import com.intellij.psi.PsiElement
import com.intellij.psi.PsiElementResolveResult
import com.intellij.psi.ResolveState
import com.intellij.psi.scope.PsiScopeProcessor
import com.example.sampleplugin.psi.*

class DeclarationProcessor(private val reference: PsiElement) : PsiScopeProcessor {
    var locatedType: SimpleTypeDeclaration? = null

    var resolved: PsiElementResolveResult? = null

    override fun execute(element: PsiElement, state: ResolveState): Boolean {
        when (reference) {
            is SimpleTypeDeclaration -> executeTypeDeclaration(reference, element, state)
            is SimpleMemberAccessExpr -> executeMemberAccessExpr(reference, element, state)
            is SimpleConstructorCall -> executeConstructorCall(reference, element, state)
            is SimpleFunction -> executeFunction(reference, element, state)
            is SimpleFunctionCall -> executeFunctionCall(reference, element, state)
//            is SimpleMemberField -> executeMemberField(reference, element, state)
        }

        return true
    }

    private fun executeTypeDeclaration(reference: SimpleTypeDeclaration, element: PsiElement, state: ResolveState): Boolean {
        /*if (element !is SimpleTypeName) {
            return true
        }*/

        /*if (element.name == reference.typeName.name) {
            locatedType = element.parent as SimpleTypeDeclaration
            resolved = PsiElementResolveResult(element.identifier)
            return false
        }*/

        return true
    }

    private fun executeMemberAccessExpr(reference: SimpleMemberAccessExpr, element: PsiElement, state: ResolveState): Boolean {
        return true
    }

    private fun executeConstructorCall(reference: SimpleConstructorCall, element: PsiElement, state: ResolveState): Boolean {
        if (element !is SimpleTypeDeclaration) {
            return true
        }

        /*if (element.name == reference.typeName.name) {
            locatedType = element
            resolved = PsiElementResolveResult(element.typeName)
            return false
        }*/

        return true
    }

    private fun executeFunction(reference: SimpleFunction, element: PsiElement, state: ResolveState): Boolean {
        /*if (element is SimpleTypeDeclaration) {
            if (element.name == reference.functionReceiver?.typeName!!.name) {
                resolved = PsiElementResolveResult(element)
                return false
            }
        }*/

        return true
    }

    private fun executeFunctionCall(reference: SimpleFunctionCall, target: PsiElement, state: ResolveState): Boolean {
        if (target is SimpleFunction) {
            if (reference.parent?.parent is SimpleMemberAccessExpr) {
                // Member function call like `user.getAge()`
                return executeFunctionCallToMember(reference, target, state)
            }
        }

        return true
    }

    private fun executeFunctionCallToMember(reference: SimpleFunctionCall, target: SimpleFunction, state: ResolveState): Boolean {
        /*val memberAccessExpr = reference.parent!!.parent as SimpleMemberAccessExpr
        val memberField = memberAccessExpr.firstChild as? SimpleMemberField ?: return true
        val variableDeclaration = memberField.reference?.resolve()?.parent as? SimpleVariableDeclaration ?: return true
        val constructorCall = variableDeclaration.expression?.constructorCall ?: return true

        if (constructorCall.typeName.name != target.functionReceiver?.typeName!!.name) {
            return true
        }*/

        return true
    }

    /*private fun executeMemberField(reference: SimpleMemberField, target: PsiElement, state: ResolveState): Boolean {
        if (target is SimpleVariableDeclaration) {
            if (target.name == reference.name) {
                resolved = PsiElementResolveResult(target)
                return false
            }
        }

        return true
    }*/
}