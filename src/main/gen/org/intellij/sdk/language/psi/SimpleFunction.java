// This is a generated file. Not intended for manual editing.
package org.intellij.sdk.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.PsiReference;

public interface SimpleFunction extends SimpleNamedElement {

  @NotNull
  SimpleBlock getBlock();

  @Nullable
  SimpleGeneric getGeneric();

  @NotNull
  SimpleParameters getParameters();

  @Nullable
  SimpleTypeName getTypeName();

  @NotNull
  PsiElement getFunc();

  @NotNull
  PsiElement getIdentifier();

  String getKey();

  String getName();

  PsiElement setName(String newName);

  PsiElement getNameIdentifier();

  ItemPresentation getPresentation();

  PsiReference getReference();

}
