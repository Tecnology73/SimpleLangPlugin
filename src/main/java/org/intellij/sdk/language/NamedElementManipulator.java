package org.intellij.sdk.language;

import com.intellij.lang.ASTNode;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.ElementManipulator;
import com.intellij.psi.PsiElement;
import org.intellij.sdk.language.psi.SimpleElementFactory;
import org.intellij.sdk.language.psi.SimpleTypes;
import org.intellij.sdk.language.psi.impl.SimpleNamedElementImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class NamedElementManipulator implements ElementManipulator<SimpleNamedElementImpl> {

    @Override
    public SimpleNamedElementImpl handleContentChange(@NotNull SimpleNamedElementImpl element, @NotNull TextRange range, String newContent) {
        PsiElement newElement = SimpleElementFactory.createIdentifier(element.getProject(), newContent);
        ASTNode newNode = newElement.getNode();
        ASTNode oldNode = element.getNameIdentifier().getNode();

        element.getNode().replaceChild(oldNode, newNode);

        return element;
    }

    @NotNull
    @Override
    public TextRange getRangeInElement(@NotNull SimpleNamedElementImpl element) {
        ASTNode keyNode = element.getNode().findChildByType(SimpleTypes.IDENTIFIER);
        if (keyNode != null) {
            int startOffset = keyNode.getStartOffsetInParent();
            return new TextRange(startOffset, startOffset + keyNode.getTextLength());
        }

        return TextRange.EMPTY_RANGE;
    }

    @Nullable
    @Override
    public SimpleNamedElementImpl handleContentChange(@NotNull SimpleNamedElementImpl element, String newContent) {
        TextRange range = getRangeInElement(element);
        return handleContentChange(element, range, newContent);
    }
}


