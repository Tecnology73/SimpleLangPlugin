package org.intellij.sdk.language.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiReference;
import com.intellij.openapi.util.TextRange;
import org.intellij.sdk.language.SimpleReference;
import org.intellij.sdk.language.psi.*;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class SimplePsiImplUtil {
    public static String getKey(SimpleNamedElementImpl element) {
        ASTNode keyNode = element.getNode().findChildByType(SimpleTypes.IDENTIFIER);
        if (keyNode == null) {
            keyNode = element.getNode().findChildByType(SimpleTypes.TYPE_NAME);
        }

        if (keyNode != null) {
            return keyNode.getText();
        }

        return null;
    }

    public static String getName(SimpleNamedElementImpl element) {
        return getKey(element);
    }

    public static PsiElement setName(SimpleNamedElementImpl element, String newName) {
        ASTNode keyNode = element.getNode().findChildByType(SimpleTypes.IDENTIFIER);
        if (keyNode == null) {
            keyNode = element.getNode().findChildByType(SimpleTypes.TYPE_NAME);
        }

        if (keyNode != null) {
            PsiElement newElement = SimpleElementFactory.createIdentifier(element.getProject(), newName);
            ASTNode newNode = newElement.getNode();
            ASTNode oldNode = element.getNameIdentifier().getNode();

            element.getNode().replaceChild(oldNode, newNode);
        }

        return element;
    }

    public static PsiElement getNameIdentifier(SimpleNamedElementImpl element) {
        ASTNode keyNode;
        if (element instanceof SimpleTypeDeclaration typeDeclaration) {
            keyNode = element.getNode().findChildByType(SimpleTypes.TYPE_NAME);
        } else {
            keyNode = element.getNode().findChildByType(SimpleTypes.IDENTIFIER);
        }

        if (keyNode != null) {
            return keyNode.getPsi();
        }

        return null;
    }

    public static PsiReference getReference(SimpleNamedElementImpl element) {
        ASTNode keyNode = null;
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
            keyNode = element.getNode().findChildByType(SimpleTypes.IDENTIFIER);
        }

        if (keyNode != null) {
            int startOffset = keyNode.getStartOffset() - element.getTextRange().getStartOffset();
            TextRange range = new TextRange(startOffset, startOffset + keyNode.getTextLength());
            return new SimpleReference(element, range);
        }

        return null;
    }

    public static ItemPresentation getPresentation(final SimpleNamedElementImpl element) {
        return new ItemPresentation() {
            @Nullable
            @Override
            public String getPresentableText() {
                return element.getName();
            }

            @Nullable
            @Override
            public String getLocationString() {
                PsiFile containingFile = element.getContainingFile();
                return containingFile == null ? null : containingFile.getName();
            }

            @Override
            public Icon getIcon(boolean unused) {
                return element.getIcon(0);
            }
        };
    }
}
