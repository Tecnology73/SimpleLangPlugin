package org.intellij.sdk.language;

import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import org.intellij.sdk.language.psi.SimpleTypeDeclaration;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class SimpleReference extends PsiReferenceBase<PsiElement> implements PsiPolyVariantReference {
    private final String key;

    public SimpleReference(@NotNull PsiElement element, TextRange textRange) {
        super(element, textRange);
        key = element.getText().substring(textRange.getStartOffset(), textRange.getEndOffset());
    }

    @Override
    public ResolveResult @NotNull [] multiResolve(boolean incompleteCode) {
        Project project = myElement.getProject();
        final List<SimpleTypeDeclaration> properties = SimpleUtil.findTypeDeclarations(project, key);
        List<ResolveResult> results = new ArrayList<>();
        for (SimpleTypeDeclaration property : properties) {
            results.add(new PsiElementResolveResult(property));
        }

        return results.toArray(new ResolveResult[results.size()]);
    }

    @Nullable
    @Override
    public PsiElement resolve() {
        ResolveResult[] resolveResults = multiResolve(false);
        if (resolveResults.length == 1) {
            return ((SimpleTypeDeclaration) resolveResults[0].getElement()).getNameIdentifier();
        }

        return null;
    }

    @Override
    public Object @NotNull [] getVariants() {
        Project project = myElement.getProject();
        List<SimpleTypeDeclaration> properties = SimpleUtil.findTypeDeclarations(project);
        List<LookupElement> variants = new ArrayList<>();
        for (final SimpleTypeDeclaration property : properties) {
            if (!property.getType_().getText().isEmpty()) {
                variants.add(LookupElementBuilder
                        .create(property).withIcon(SimpleIcons.FILE)
                        .withTypeText(property.getContainingFile().getName())
                );
            }
        }

        return variants.toArray();
    }
}