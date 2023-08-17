package com.example.sampleplugin.psi.impl

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReference
import javax.swing.Icon

object SimplePsiImplUtil {
    @JvmStatic
    fun getKey(element: SimpleNamedElementImpl?): String? {
        /*ASTNode keyNode = element.getNode().findChildByType(SimpleTypes.ID);
        if (keyNode == null) {
            keyNode = element.getNode().findChildByType(SimpleTypes.TYPE_NAME);
        }

        if (keyNode != null) {
            return keyNode.getText();
        }*/
        return null
    }

    @JvmStatic
    fun getName(element: SimpleNamedElementImpl?): String? {
        return getKey(element)
    }

    @JvmStatic
    fun setName(element: SimpleNamedElementImpl, newName: String?): PsiElement {
        /*ASTNode keyNode = element.getNode().findChildByType(SimpleTypes.ID);
        if (keyNode == null) {
            keyNode = element.getNode().findChildByType(SimpleTypes.TYPE_NAME);
        }

        if (keyNode != null) {
            PsiElement newElement = SimpleElementFactory.createIdentifier(element.getProject(), newName);
            ASTNode newNode = newElement.getNode();
            ASTNode oldNode = element.getNameIdentifier().getNode();

            element.getNode().replaceChild(oldNode, newNode);
        }*/
        return element
    }

    @JvmStatic
    fun getNameIdentifier(element: SimpleNamedElementImpl?): PsiElement? {
        /*ASTNode keyNode;
        if (element instanceof SimpleTypeDeclaration typeDeclaration) {
            keyNode = element.getNode().findChildByType(SimpleTypes.TYPE_NAME);
        } else {
            keyNode = element.getNode().findChildByType(SimpleTypes.ID);
        }

        if (keyNode != null) {
            return keyNode.getPsi();
        }*/
        return null
    }

    @JvmStatic
    fun getReference(element: ASTWrapperPsiElement?): PsiReference? {
        /*ASTNode keyNode = null;
        if (element instanceof SimpleConstructorCall constructorCall) {
            keyNode = constructorCall.getTypeName().getNode();
        } else if (element instanceof SimpleTypeDeclaration typeDeclaration) {
            keyNode = typeDeclaration.getNameIdentifier().getNode();
        } else if (element instanceof SimpleFunction function) {
            SimpleGeneric generic = function.getGeneric();
            if (generic != null) {
                keyNode = generic.getTypeName().getNode();
            }
        } else if (element instanceof SimpleFunctionCall functionCall) {
            keyNode = functionCall.getIdentifier().getNode();
        } else if (element instanceof SimpleVariableDeclaration variableDeclaration) {
            keyNode = variableDeclaration.getIdentifier().getNode();
        } else {
            keyNode = element.getNode().findChildByType(SimpleTypes.ID);
        }

        if (keyNode != null) {
            int startOffset = keyNode.getStartOffset() - element.getTextRange().getStartOffset();
            TextRange range = new TextRange(startOffset, startOffset + keyNode.getTextLength());
            return new SimpleReference(element, range);
        }*/
        return null
    }

    @JvmStatic
    fun getPresentation(element: SimpleNamedElementImpl): ItemPresentation {
        return object : ItemPresentation {
            override fun getPresentableText(): String? {
                return element.name
            }

            override fun getLocationString(): String? {
                val containingFile = element.containingFile
                return containingFile?.name
            }

            override fun getIcon(unused: Boolean): Icon? {
                return element.getIcon(0)
            }
        }
    }
}
