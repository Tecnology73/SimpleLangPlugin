// This is a generated file. Not intended for manual editing.
package org.intellij.sdk.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.PsiReference;

public interface SimpleTypeDeclaration extends SimpleNamedElement {

  @NotNull
  SimpleBlock getBlock();

  @NotNull
  PsiElement getType_();

  @NotNull
  PsiElement getIdentifier();

  String getName();

  PsiElement setName(String newName);

  PsiElement getNameIdentifier();

  ItemPresentation getPresentation();

  PsiReference getReference();

}
