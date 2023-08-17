// This is a generated file. Not intended for manual editing.
package com.example.sampleplugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;

public interface SimpleTypeDeclaration extends SimpleNamedElement {

  @Nullable
  SimpleType getType();

  @Nullable
  SimpleTypeBlock getTypeBlock();

  @NotNull
  PsiElement getTypeKw();

  @Nullable
  String getName();

  @Nullable
  PsiElement getNameIdentifier();

  @Nullable
  PsiReference getReference();

}
