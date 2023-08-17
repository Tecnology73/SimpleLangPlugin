// This is a generated file. Not intended for manual editing.
package org.intellij.sdk.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface SimpleTypeField extends PsiElement {

  @Nullable
  SimpleTypeName getTypeName();

  @Nullable
  SimpleValueExpr getValueExpr();

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

}
