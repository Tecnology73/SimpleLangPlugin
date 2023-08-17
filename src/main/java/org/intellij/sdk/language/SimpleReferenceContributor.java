package org.intellij.sdk.language;

import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.*;
import com.intellij.util.ProcessingContext;
import org.intellij.sdk.language.psi.SimpleConstructorCall;
import org.intellij.sdk.language.psi.SimpleTypes;
import org.intellij.sdk.language.psi.SimpleVariableDeclaration;
import org.jetbrains.annotations.NotNull;

public class SimpleReferenceContributor extends PsiReferenceContributor {
    @Override
    public void registerReferenceProviders(@NotNull PsiReferenceRegistrar registrar) {
        /*registrar.registerReferenceProvider(PlatformPatterns.psiElement(SimpleConstructorCall.class),
                new PsiReferenceProvider() {
                    @Override
                    public PsiReference @NotNull [] getReferencesByElement(@NotNull PsiElement element, @NotNull ProcessingContext context) {
                        if (element instanceof SimpleConstructorCall) {
                            return new PsiReference[]{element.getReference()};
                        }

                        return PsiReference.EMPTY_ARRAY;
                    }
                });*/
    }
}
