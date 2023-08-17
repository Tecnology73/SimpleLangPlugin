package org.intellij.sdk.language;

import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import org.intellij.sdk.language.psi.*;
import org.intellij.sdk.language.psi.impl.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@FunctionalInterface
interface ResolverFunction {
    PsiElement resolve(PsiElement element);
}

public class SimpleReference extends PsiReferenceBase<SimpleNamedElement> implements PsiPolyVariantReference {
    private final String key;

    /**
     * This basically tells the IDE what node we want the ctrl+click to take us to.
     * Note: The keys are *always* the Impl classes.
     */
    private static final Map<Class<? extends SimpleNamedElement>, ResolverFunction> RESOLVER_FUNCTION_MAP = Map.of(
            // For Type Declarations `type User {}`, we want to go to the Identifier ("User").
            SimpleTypeDeclarationImpl.class, (element) -> ((SimpleTypeDeclaration) element).getNameIdentifier(),
            // For Function Declarations `func main() {}`, we want to go to the Identifier ("main").
            SimpleFunctionImpl.class, (element) -> ((SimpleFunction) element).getIdentifier(),
            SimpleMemberFieldImpl.class, (element) -> ((SimpleMemberField) element).getIdentifier(),
            SimpleVariableDeclarationImpl.class, (element) -> ((SimpleVariableDeclaration) element).getIdentifier(),
            SimpleTypeNameImpl.class, (element) -> ((SimpleTypeName) element).getIdentifier()
    );

    /**
     * When ctrl+clicking on (key), what do we want to search for (value).
     */
    private static final Map<Class<? extends SimpleNamedElement>, Class<? extends SimpleNamedElement>> MULTI_RESOLVER_MAP = Map.of(
            // When resolving from a Constructor Call, we want to find the Type Declaration.
            SimpleConstructorCallImpl.class, SimpleTypeDeclaration.class,
            // When resolving from a Function Call, we want to find the Function.
            SimpleFunctionCallImpl.class, SimpleFunction.class,
            SimpleMemberFieldImpl.class, SimpleVariableDeclaration.class,
            SimpleFunctionImpl.class, SimpleTypeDeclaration.class,
            SimpleTypeNameImpl.class, SimpleTypeDeclaration.class
    );

    public SimpleReference(@NotNull SimpleNamedElement element, TextRange textRange) {
        super(element, textRange);
        key = element.getText().substring(textRange.getStartOffset(), textRange.getEndOffset());
    }

    @Override
    public ResolveResult @NotNull [] multiResolve(boolean incompleteCode) {
        Class<? extends SimpleNamedElement> multiResolverClass = MULTI_RESOLVER_MAP.get(myElement.getClass());
        if (multiResolverClass == null) multiResolverClass = SimpleNamedElement.class;

        List<SimpleNamedElement> properties = (List<SimpleNamedElement>) SimpleUtil.findDeclarations(myElement.getProject(), key, multiResolverClass);
        List<ResolveResult> results = new ArrayList<>();
        for (PsiElement property : properties) {
            // If we're a member function, only match against functions belonging to the same type.
            if (myElement instanceof SimpleFunctionCall && myElement.getParent().getParent() instanceof SimpleMemberAccessExpr) {
                ASTNode generic = property.getNode().findChildByType(SimpleTypes.GENERIC);
                if (generic == null) {
                    continue;
                }

                if (!(myElement.getParent().getParent().getFirstChild() instanceof SimpleMemberField memberField)) {
                    continue;
                }

                PsiElement decl = memberField.getReference().resolve();
                if (decl == null || !(decl.getParent() instanceof SimpleVariableDeclaration variableDeclaration)) {
                    continue;
                }

                SimpleConstructorCall constructorCall = variableDeclaration.getExpression().getConstructorCall();
                if (constructorCall == null) {
                    continue;
                }

                if (!generic.getPsi(SimpleGeneric.class).getTypeName().getText().equals(constructorCall.getTypeName().getText())) {
                    continue;
                }
            } else {
                // Match against a function that doesn't belong to a generic.
                ASTNode generic = property.getNode().findChildByType(SimpleTypes.GENERIC);
                if (generic != null) {
                    continue;
                }
            }

            // When clicking on the type for a member function `func<User> f() {}`, we want to go to the type declaration.
            // When clicking on a normal function `func f() {}`, we don't want to do anything (for now?)
            if (myElement instanceof SimpleFunction && myElement.getNode().findChildByType(SimpleTypes.GENERIC) != null) {
                if (!(property instanceof SimpleTypeDeclaration)) {
                    continue;
                }
            }

            // Make the cursor go to the right fucking place for Type Declarations.
            if (property instanceof SimpleTypeDeclaration typeDeclaration) {
                property = typeDeclaration.getTypeName();
            }

            results.add(new PsiElementResolveResult(property));
        }

        return results.toArray(new ResolveResult[results.size()]);
    }

    @Nullable
    @Override
    public PsiElement resolve() {
        ResolveResult[] resolveResults = multiResolve(false);
        if (resolveResults.length != 1) return null;

        PsiElement result = resolveResults[0].getElement();
        ResolverFunction resolverFunction = RESOLVER_FUNCTION_MAP.get(result.getClass());
        if (resolverFunction != null) {
            return resolverFunction.resolve(result);
        }

        return null;
    }

    @Override
    public Object @NotNull [] getVariants() {
        Project project = myElement.getProject();
        List<SimpleTypeDeclaration> properties = SimpleUtil.findDeclarations(project, SimpleTypeDeclaration.class);
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