// This is a generated file. Not intended for manual editing.
package org.intellij.sdk.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.PsiReference;

public interface SimpleVariableDeclaration extends SimpleNamedElement {

  @Nullable
  SimpleExpression getExpression();

  @Nullable
  SimpleTypeName getTypeName();

  @Nullable
  PsiElement getAssign();

  @Nullable
  PsiElement getColon();

  @Nullable
  PsiElement getSemicolon();

  @Nullable
  PsiElement getSemicolonSynthetic();

  @NotNull
  PsiElement getIdentifier();

  String getKey();

  String getName();

  PsiElement setName(String newName);

  PsiElement getNameIdentifier();

  ItemPresentation getPresentation();

  PsiReference getReference();

}
