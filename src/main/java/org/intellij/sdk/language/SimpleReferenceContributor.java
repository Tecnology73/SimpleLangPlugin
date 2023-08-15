// Copyright 2000-2022 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package org.intellij.sdk.language;

import com.intellij.openapi.util.TextRange;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.*;
import com.intellij.util.ProcessingContext;
import org.intellij.sdk.language.psi.SimpleConstructorCall;
import org.jetbrains.annotations.NotNull;

public class SimpleReferenceContributor extends PsiReferenceContributor {
    @Override
    public void registerReferenceProviders(@NotNull PsiReferenceRegistrar registrar) {
        // Adjust the target class here
        /*registrar.registerReferenceProvider(PlatformPatterns.psiElement(SimpleConstructorCall.class),
                new PsiReferenceProvider() {
                    @Override
                    public PsiReference @NotNull [] getReferencesByElement(@NotNull PsiElement element,
                                                                           @NotNull ProcessingContext context) {
                        // Cast the element to your type declaration class
                        SimpleConstructorCall typeDeclaration = (SimpleConstructorCall) element;

                        // Extract the relevant information from the type declaration
                        String typeName = typeDeclaration.getName();

                        // (Optional) Some logic to determine if you want to create a reference for this type name
                        // For example:
                        if (typeName != null && !typeName.isEmpty()) {
                            // Adjust the TextRange to cover the range of the type's name in the file
                            TextRange range = new TextRange(0, typeName.length());
                            return new PsiReference[]{new SimpleReference(element, range)};
                        }

                        return PsiReference.EMPTY_ARRAY;
                    }
                });*/

        registrar.registerReferenceProvider(PlatformPatterns.psiElement(SimpleConstructorCall.class),
                new PsiReferenceProvider() {
                    @Override
                    public PsiReference @NotNull [] getReferencesByElement(@NotNull PsiElement element, @NotNull ProcessingContext context) {
                        if (element instanceof SimpleConstructorCall) {
                            return new PsiReference[]{element.getReference()};
                        }

                        return PsiReference.EMPTY_ARRAY;
                    }
                });
    }
}
