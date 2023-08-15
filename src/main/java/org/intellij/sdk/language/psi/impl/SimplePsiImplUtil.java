package org.intellij.sdk.language.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiReference;
import com.intellij.openapi.util.TextRange;
import org.intellij.sdk.language.SimpleReference;
import org.intellij.sdk.language.psi.SimpleConstructorCall;
import org.intellij.sdk.language.psi.SimpleElementFactory;
import org.intellij.sdk.language.psi.SimpleTypeDeclaration;
import org.intellij.sdk.language.psi.SimpleTypes;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class SimplePsiImplUtil {
    public static String getKey(SimpleNamedElementImpl element) {
        ASTNode keyNode = element.getNode().findChildByType(SimpleTypes.IDENTIFIER);
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
        if (keyNode != null) {
            PsiElement newElement = SimpleElementFactory.createIdentifier(element.getProject(), newName);
            ASTNode newNode = newElement.getNode();
            ASTNode oldNode = element.getNameIdentifier().getNode();

            element.getNode().replaceChild(oldNode, newNode);
        }

        return element;
    }

    public static PsiElement getNameIdentifier(SimpleNamedElementImpl element) {
        ASTNode keyNode = element.getNode().findChildByType(SimpleTypes.IDENTIFIER);
        if (keyNode != null) {
            return keyNode.getPsi();
        }

        return null;
    }

    public static PsiReference getReference(SimpleNamedElementImpl element) {
        ASTNode keyNode = element.getNode().findChildByType(SimpleTypes.IDENTIFIER);
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
