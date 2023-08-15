package org.intellij.sdk.language;

import com.intellij.psi.*;
import org.intellij.sdk.language.psi.SimpleTypeDeclaration;
import org.intellij.sdk.language.psi.impl.SimpleConstructorCallImpl;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class SimpleTypeReference extends PsiReferenceBase<SimpleConstructorCallImpl> {
    private final String typeName;

    public SimpleTypeReference(SimpleConstructorCallImpl element) {
        super(element);
        typeName = element.getName();
    }

    @Override
    public PsiElement resolve() {
        List<SimpleTypeDeclaration> matches = SimpleUtil.findTypeDeclarations(myElement.getProject(), typeName);
        if (matches.isEmpty()) {
            return null;
        }

        return matches.get(0).getNameIdentifier();
    }

    @NotNull
    @Override
    public Object @NotNull [] getVariants() {
        return EMPTY_ARRAY;
    }
}