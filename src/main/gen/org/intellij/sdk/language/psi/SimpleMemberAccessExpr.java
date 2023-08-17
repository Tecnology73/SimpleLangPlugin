// This is a generated file. Not intended for manual editing.
package org.intellij.sdk.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;

public interface SimpleMemberAccessExpr extends PsiElement {

  @NotNull
  SimpleExpression getExpression();

  @NotNull
  PsiElement getDot();

  @Nullable
  PsiElement getIdentifier();

  @Nullable
  PsiReference getReference();

  boolean isCallExpression();

  @Nullable
  PsiElement getLHS();

  @Nullable
  PsiElement getRHS();

}
