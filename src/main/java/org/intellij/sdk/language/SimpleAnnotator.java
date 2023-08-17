// Copyright 2000-2023 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package org.intellij.sdk.language;

import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.lang.annotation.HighlightSeverity;
import com.intellij.psi.PsiElement;
import org.intellij.sdk.language.psi.*;
import org.jetbrains.annotations.NotNull;

import static org.intellij.sdk.language.SimpleSyntaxHighlighterColors.*;


public class SimpleAnnotator implements Annotator {
    @Override
    public void annotate(@NotNull final PsiElement element, @NotNull AnnotationHolder holder) {
        if (element instanceof SimpleTypeDeclaration typeElement) {
            holder.newSilentAnnotation(HighlightSeverity.TEXT_ATTRIBUTES)
                    .range(typeElement.getTypeName())
                    .textAttributes(TYPE_NAME)
                    .create();
        } else if (element instanceof SimpleConstructorCall callElement) {
            holder.newSilentAnnotation(HighlightSeverity.TEXT_ATTRIBUTES)
                    .range(callElement.getTypeName())
                    .textAttributes(TYPE_NAME)
                    .create();
        } /*else if (element instanceof SimpleFunctionCall callElement) {
            holder.newSilentAnnotation(HighlightSeverity.TEXT_ATTRIBUTES)
                    .range(callElement.getIdentifier())
                    .textAttributes(INSTANCE_METHOD)
                    .create();
        }*/ else if (element instanceof SimpleFunction functionElement) {
            SimpleGeneric generic = functionElement.getGeneric();
            if (generic != null) {
                holder.newSilentAnnotation(HighlightSeverity.TEXT_ATTRIBUTES)
                        .range(generic.getTypeName())
                        .textAttributes(TYPE_NAME)
                        .create();
            }

            SimpleTypeName typeName = functionElement.getTypeName();
            if (typeName != null) {
                holder.newSilentAnnotation(HighlightSeverity.TEXT_ATTRIBUTES)
                        .range(typeName)
                        .textAttributes(TYPE_NAME)
                        .create();
            }
        } else if (element instanceof SimpleMemberAccessExpr memberAccessExpr) {
            /*holder.newSilentAnnotation(HighlightSeverity.TEXT_ATTRIBUTES)
                    .range(memberAccessExpr.getMemberField())
                    .textAttributes(MEMBER)
                    .create();*/

            PsiElement expr = memberAccessExpr.getExpression().getFirstChild();
            if (expr instanceof SimpleFunctionCall functionCall) {
                holder.newSilentAnnotation(HighlightSeverity.TEXT_ATTRIBUTES)
                        .range(functionCall.getIdentifier())
                        .textAttributes(INSTANCE_METHOD)
                        .create();
            } else {
                holder.newSilentAnnotation(HighlightSeverity.TEXT_ATTRIBUTES)
                        .range(expr.getTextRange())
                        .textAttributes(INSTANCE_FIELD)
                        .create();
            }
        } else if (element instanceof SimpleVariableDeclaration variableDeclaration) {
            holder.newSilentAnnotation(HighlightSeverity.TEXT_ATTRIBUTES)
                    .range(variableDeclaration.getIdentifier())
                    .textAttributes(MEMBER)
                    .create();


            SimpleTypeName typeName = variableDeclaration.getTypeName();
            if (typeName != null) {
                holder.newSilentAnnotation(HighlightSeverity.TEXT_ATTRIBUTES)
                        .range(typeName)
                        .textAttributes(TYPE_NAME)
                        .create();
            }
        }
    }
}